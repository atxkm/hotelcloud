package cn.zhsit.common.utils;

import cn.zhsit.hotel.models.po.Rcu;
import cn.zhsit.hotel.models.po.RcuSetparam;
import cn.zhsit.hotel.models.po.RcuSettime;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadExcelSetparam {
    //总行数
    private int totalRows = 0;
    //总条数
    private int totalCells = 0;
    //错误信息接收器
    private String errorMsg;

    //构造方法
    public ReadExcelSetparam() {
    }

    //获取总行数
    public int getTotalRows() {
        return totalRows;
    }

    //获取总列数
    public int getTotalCells() {
        return totalCells;
    }

    //获取错误信息
    public String getErrorInfo() {
        return errorMsg;
    }

    /**
     * 验证EXCEL文件
     *
     * @param filePath
     * @return
     */
    public boolean validateExcel(String filePath) {
        if (filePath == null || !(WDWUtil.isExcel2003(filePath) || WDWUtil.isExcel2007(filePath))) {
            errorMsg = "文件名不是excel格式";
            return false;
        }
        return true;
    }

    /**
     * 上传excel文件到临时目录后并开始解析
     * @param fileName
     * @param file
     * @param userName
     * @return
     */
    public static List<RcuSetparam> batchImport(String fileName,MultipartFile mfile,String userName){

        File uploadDir = new  File("./fileupload");
        //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
        if (!uploadDir.exists()) uploadDir.mkdirs();
        //新建一个文件
        File tempFile = new File("./fileupload/" + new Date().getTime() + ".xlsx");
        //初始化输入流
        InputStream is = null;
        try{
            //将上传的文件写入新建的文件中
            mfile.transferTo(tempFile);

            //根据新建的文件实例化输入流
            is = new FileInputStream(tempFile);

            //根据版本选择创建Workbook的方式
            Workbook wb = null;
            //根据文件名判断文件是2003版本还是2007版本
            if(ExcelImportUtils.isExcel2007(fileName)){
                wb = new XSSFWorkbook(is);
            }else{
                wb = new HSSFWorkbook(is);
            }
            //根据excel里面的内容读取知识库信息
            return readExcelValue(wb,userName,tempFile);
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            if(is !=null)
            {
                try{
                    is.close();
                }catch(IOException e){
                    is = null;
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    /**
     * 解析Excel里面的数据
     * @param wb
     * @return
     */
    private static List<RcuSetparam> readExcelValue(Workbook wb,String userName,File tempFile){

        //错误信息接收器
        String errorMsg = "";
        //得到第一个shell
        Sheet sheet=wb.getSheetAt(0);
        //得到Excel的行数
        int totalRows=sheet.getPhysicalNumberOfRows();
        //总列数
        int totalCells = 0;
        //得到Excel的列数(前提是有行数)，从第二行算起
        if(totalRows>=2 && sheet.getRow(1) != null){
            totalCells=sheet.getRow(1).getPhysicalNumberOfCells();
        }
        List<RcuSetparam> userKnowledgeBaseList=new ArrayList<RcuSetparam>();
        RcuSetparam aRcuSetparam;

        String br = "<br/>";

        //循环Excel行数,从第二行开始。标题不入库
        for(int r=1;r<totalRows;r++){
            String rowMessage = "";
            Row row = sheet.getRow(r);
            if (row == null){
                errorMsg += br+"第"+(r+1)+"行数据有问题，请仔细检查！";
                continue;
            }
            aRcuSetparam = new RcuSetparam();

            String question = "";
            String answer = "";

            //循环Excel的列
            for(int c = 0; c <totalCells; c++){
                Cell cell = row.getCell(c);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                if (null != cell) {
                    if (c == 0) {//第一列不读
                    } else if (c == 1) {
                        aRcuSetparam.setRcuid(cell.getStringCellValue());//
                    } else if (c == 2) {
                        aRcuSetparam.setRoomtype(cell.getStringCellValue());//
                    } else if (c == 3) {
                        aRcuSetparam.setIpaddr(cell.getStringCellValue());//
                    } else if (c == 4) {
                        aRcuSetparam.setMacaddr(cell.getStringCellValue());//
                    } else if (c == 5) {
                        aRcuSetparam.setPort(cell.getStringCellValue());//
                    } else if (c == 6) {
                        aRcuSetparam.setUpipaddr(cell.getStringCellValue());//
                    } else if (c == 7) {
                        if (!"".equals(cell.getStringCellValue())) {
                            aRcuSetparam.setUpport(cell.getStringCellValue());//
                        }
                    } else if (c == 8) {
                        aRcuSetparam.setMaskcode(cell.getStringCellValue());//
                    } else if (c == 9) {
                        aRcuSetparam.setGateway(cell.getStringCellValue());//
                    } else if (c == 10) {
                        aRcuSetparam.setRemark(cell.getStringCellValue());//
                    }

                }else{
                    rowMessage += "第"+(c+1)+"列数据有问题，请仔细检查；";
                }
            }
            //拼接每行的错误提示
            if(!StringUtils.isEmpty(rowMessage)){
                errorMsg += br+"第"+(r+1)+"行，"+rowMessage;
            }else{
                userKnowledgeBaseList.add(aRcuSetparam);
            }
        }

        //删除上传的临时文件
        if(tempFile.exists()){
            tempFile.delete();
        }

        //全部验证通过才导入到数据库
        if(StringUtils.isEmpty(errorMsg)){
            for(RcuSetparam userKnowledgeBase : userKnowledgeBaseList){
                System.out.println(userKnowledgeBase);
                //this.saveUserKnowledge(userKnowledgeBase, userName);
            }
            errorMsg = "导入成功，共"+userKnowledgeBaseList.size()+"条数据！";
        }
        return userKnowledgeBaseList;
    }


}
