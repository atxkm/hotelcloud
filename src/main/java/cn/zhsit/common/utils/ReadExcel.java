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

public class ReadExcel {
    //总行数
    private int totalRows = 0;
    //总条数
    private int totalCells = 0;
    //错误信息接收器
    private String errorMsg;

    //构造方法
    public ReadExcel() {
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
    public static List<Rcu> batchImport(String fileName,MultipartFile mfile,String userName){

        File uploadDir = new  File("/Users/renrui-mac37/Documents/hotel/hotel/hotelcloud/fileupload");
        //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
        if (!uploadDir.exists()) uploadDir.mkdirs();
        //新建一个文件
        File tempFile = new File("/Users/renrui-mac37/Documents/hotel/hotel/hotelcloud/fileupload/" + new Date().getTime() + ".xlsx");
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
    private static List<Rcu> readExcelValue(Workbook wb,String userName,File tempFile){

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
        List<Rcu> userKnowledgeBaseList=new ArrayList<Rcu>();
        Rcu customer;

        String br = "<br/>";

        //循环Excel行数,从第二行开始。标题不入库
        for(int r=1;r<totalRows;r++){
            String rowMessage = "";
            Row row = sheet.getRow(r);
            if (row == null){
                errorMsg += br+"第"+(r+1)+"行数据有问题，请仔细检查！";
                continue;
            }
            customer = new Rcu();

            String question = "";
            String answer = "";

            //循环Excel的列
            for(int c = 0; c <totalCells; c++){
                Cell cell = row.getCell(c);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                if (null != cell) {
                    if (c == 0) {//第一列不读

                    } else if (c == 1) {
                        customer.setRcuid(cell.getStringCellValue());//
                    } else if (c == 2) {
                        customer.setRoomid(cell.getStringCellValue());//
                    } else if (c == 3) {
                        customer.setRoomtype(cell.getStringCellValue());//
                    } else if (c == 4) {
                        customer.setRoomconnect(cell.getStringCellValue());//
                    } else if (c == 5) {
                        customer.setCommonVersion(cell.getStringCellValue());//
                    } else if (c == 6) {
                        customer.setConfigVersion(cell.getStringCellValue());//
                    } else if (c == 7) {
                        customer.setEngiNum(cell.getStringCellValue());//
                    } else if (c == 8) {
                        if (!"".equals(cell.getStringCellValue())) {
                            customer.setSetnumber(Integer.parseInt(cell.getStringCellValue()));//
                        }
                    } else if (c == 9) {
                        customer.setRemark(cell.getStringCellValue());//
                    }
                    //customer.setRcuid(ZhsUnique.unique25());
                }else{
                    rowMessage += "第"+(c+1)+"列数据有问题，请仔细检查；";
                }
            }
            //拼接每行的错误提示
            if(!StringUtils.isEmpty(rowMessage)){
                errorMsg += br+"第"+(r+1)+"行，"+rowMessage;
            }else{
                userKnowledgeBaseList.add(customer);
            }
        }

        //删除上传的临时文件
        if(tempFile.exists()){
            tempFile.delete();
        }

        //全部验证通过才导入到数据库
        if(StringUtils.isEmpty(errorMsg)){
            for(Rcu userKnowledgeBase : userKnowledgeBaseList){
                System.out.println(userKnowledgeBase);
                //this.saveUserKnowledge(userKnowledgeBase, userName);
            }
            errorMsg = "导入成功，共"+userKnowledgeBaseList.size()+"条数据！";
        }
        return userKnowledgeBaseList;
    }
    /**
     * 根据excel里面的内容读取客户信息
     *
     * @param is          输入流
     * @param isExcel2003 excel是2003还是2007版本
     * @return
     * @throws IOException
     */
    public List<Rcu> getExcelInfo(InputStream is, boolean isExcel2003) {
        List<Rcu> customerList = null;
        try {
            /** 根据版本选择创建Workbook的方式 */
            Workbook wb = null;
            //当excel是2003时
            if (isExcel2003) {
                wb = new HSSFWorkbook(is);
            } else {//当excel是2007时
                wb = new XSSFWorkbook(is);
            }
            //读取Excel里面客户的信息
            customerList = readExcelValue(wb);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    /**
     * 读取Excel里面客户的信息
     *
     * @param wb
     * @return
     */
    private List<Rcu> readExcelValue(Workbook wb) {
        //得到第一个shell
        Sheet sheet = wb.getSheetAt(0);

        //得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();

        //得到Excel的列数(前提是有行数)
        if (totalRows >= 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }

        List<Rcu> customerList = new ArrayList<Rcu>();
        Rcu customer;
        //循环Excel行数,从第二行开始。标题不入库
        for (int r = 1; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null) continue;
            customer = new Rcu();

            //循环Excel的列
            for (int c = 0; c < this.totalCells; c++) {
                Cell cell = row.getCell(c);
                if (null != cell) {
                    if (c == 0) {//第一列不读
                    } else if (c == 1) {
                        customer.setRcuid(cell.getStringCellValue());//
                    } else if (c == 2) {
                        customer.setRoomtype(cell.getStringCellValue());//
                    } else if (c == 3) {
                        customer.setRoomconnect(cell.getStringCellValue());//
                    } else if (c == 4) {
                        customer.setCommonVersion(cell.getStringCellValue());//
                    } else if (c == 5) {
                        customer.setConfigVersion(cell.getStringCellValue());//
                    } else if (c == 6) {
                        customer.setEngiNum(cell.getStringCellValue());//
                    } else if (c == 7) {
                        if (!"".equals(cell.getStringCellValue())) {
                            customer.setSetnumber(Integer.parseInt(cell.getStringCellValue()));//
                        }
                    } else if (c == 8) {
                        customer.setRemark(cell.getStringCellValue());//
                    }
                    customer.setRcuid(ZhsUnique.unique25());
                }
            }
            //添加客户
            customerList.add(customer);
        }
        return customerList;
    }


    /**
     * 读EXCEL文件，获取rcu参数设置
     *
     * @param fielName
     * @return
     */
    public List<RcuSetparam> getExcelInfoSetparam(String fileName, MultipartFile Mfile) {

        //把spring文件上传的MultipartFile转换成CommonsMultipartFile类型
        CommonsMultipartFile cf = (CommonsMultipartFile) Mfile; //获取本地存储路径
        File file = new File("D:\\fileupload");
        //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
        if (!file.exists()) file.mkdirs();
        //新建一个文件
        File file1 = new File("D:\\fileupload" + new Date().getTime() + ".xlsx");
        //将上传的文件写入新建的文件中
        try {
            cf.getFileItem().write(file1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //初始化客户信息的集合
        List<RcuSetparam> customerList = new ArrayList<RcuSetparam>();
        //初始化输入流
        InputStream is = null;
        try {
            //验证文件名是否合格
            if (!validateExcel(fileName)) {
                return null;
            }
            //根据文件名判断文件是2003版本还是2007版本
            boolean isExcel2003 = true;
            if (WDWUtil.isExcel2007(fileName)) {
                isExcel2003 = false;
            }
            //根据新建的文件实例化输入流
            is = new FileInputStream(file1);
            //根据excel里面的内容读取客户信息
            customerList = getExcelRcuSetparam(is, isExcel2003);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    is = null;
                    e.printStackTrace();
                }
            }
        }
        return customerList;
    }

    /**
     * 根据excel里面的内容读取RCU参数设置信息
     *
     * @param is          输入流
     * @param isExcel2003 excel是2003还是2007版本
     * @return
     * @throws IOException
     */
    public List<RcuSetparam> getExcelRcuSetparam(InputStream is, boolean isExcel2003) {
        List<RcuSetparam> rcuSetparamList = null;
        try {
            /** 根据版本选择创建Workbook的方式 */
            Workbook wb = null;
            //当excel是2003时
            if (isExcel2003) {
                wb = new HSSFWorkbook(is);
            } else {//当excel是2007时
                wb = new XSSFWorkbook(is);
            }
            //读取Excel里面客户的信息
            rcuSetparamList = readExcelValueSetparam(wb);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rcuSetparamList;
    }

    /**
     * 根据excel里面的内容读取RCU参数设置信息
     *
     * @param is          输入流
     * @param isExcel2003 excel是2003还是2007版本
     * @return
     * @throws IOException
     */
    private List<RcuSetparam> readExcelValueSetparam(Workbook wb) {
        //得到第一个shell
        Sheet sheet = wb.getSheetAt(0);

        //得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();

        //得到Excel的列数(前提是有行数)
        if (totalRows >= 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }

        List<RcuSetparam> customerList = new ArrayList<RcuSetparam>();
        RcuSetparam aRcuSetparam = null;
        //循环Excel行数,从第二行开始。标题不入库
        for (int r = 1; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null) continue;
            aRcuSetparam = new RcuSetparam();

            //循环Excel的列
            for (int c = 0; c < this.totalCells; c++) {
                Cell cell = row.getCell(c);
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
                    aRcuSetparam.setRcuid(ZhsUnique.unique25());
                }
            }
            //添加客户
            customerList.add(aRcuSetparam);
        }
        return customerList;
    }

    /**
     * 读EXCEL文件，获取rcu参数设置
     *
     * @param fielName
     * @return
     */
    public List<RcuSettime> getExcelInfoSettime(String fileName, MultipartFile Mfile) {

        //把spring文件上传的MultipartFile转换成CommonsMultipartFile类型
        CommonsMultipartFile cf = (CommonsMultipartFile) Mfile; //获取本地存储路径
        File file = new File("D:\\fileupload");
        //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
        if (!file.exists()) file.mkdirs();
        //新建一个文件
        File file1 = new File("D:\\fileupload" + new Date().getTime() + ".xlsx");
        //将上传的文件写入新建的文件中
        try {
            cf.getFileItem().write(file1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //初始化客户信息的集合
        List<RcuSettime> customerList = new ArrayList<RcuSettime>();
        //初始化输入流
        InputStream is = null;
        try {
            //验证文件名是否合格
            if (!validateExcel(fileName)) {
                return null;
            }
            //根据文件名判断文件是2003版本还是2007版本
            boolean isExcel2003 = true;
            if (WDWUtil.isExcel2007(fileName)) {
                isExcel2003 = false;
            }
            //根据新建的文件实例化输入流
            is = new FileInputStream(file1);
            //根据excel里面的内容读取客户信息
            customerList = getExcelRcuSettime(is, isExcel2003);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    is = null;
                    e.printStackTrace();
                }
            }
        }
        return customerList;
    }

    /**
     * 根据excel里面的内容读取RCU参数设置信息
     *
     * @param is          输入流
     * @param isExcel2003 excel是2003还是2007版本
     * @return
     * @throws IOException
     */
    public List<RcuSettime> getExcelRcuSettime(InputStream is, boolean isExcel2003) {
        List<RcuSettime> rcuSetparamList = null;
        try {
            /** 根据版本选择创建Workbook的方式 */
            Workbook wb = null;
            //当excel是2003时
            if (isExcel2003) {
                wb = new HSSFWorkbook(is);
            } else {//当excel是2007时
                wb = new XSSFWorkbook(is);
            }
            //读取Excel里面客户的信息
            rcuSetparamList = readExcelValueRcuSettime(wb);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rcuSetparamList;
    }

    /**
     * 根据excel里面的内容读取RCU参数设置信息
     *
     * @param is          输入流
     * @param isExcel2003 excel是2003还是2007版本
     * @return
     * @throws IOException
     */
    private List<RcuSettime> readExcelValueRcuSettime(Workbook wb) {
        //得到第一个shell
        Sheet sheet = wb.getSheetAt(0);

        //得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();

        //得到Excel的列数(前提是有行数)
        if (totalRows >= 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }

        List<RcuSettime> customerList = new ArrayList<RcuSettime>();
        RcuSettime aRcuSetparam = null;
        //循环Excel行数,从第二行开始。标题不入库
        for (int r = 1; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null) continue;
            aRcuSetparam = new RcuSettime();

            //循环Excel的列
            for (int c = 0; c < this.totalCells; c++) {
                Cell cell = row.getCell(c);
                if (null != cell) {
                    if (c == 0) {//第一列不读
                    } else if (c == 1) {
                        aRcuSetparam.setRcuid(cell.getStringCellValue());//
                    } else if (c == 2) {
                        aRcuSetparam.setRoomid(cell.getStringCellValue());//
                    } else if (c == 3) {
                        aRcuSetparam.setRoomtype(cell.getStringCellValue());//
                    } else if (c == 4) {
                        aRcuSetparam.setLink(cell.getStringCellValue());//
                    } else if (c == 5) {
                        aRcuSetparam.setMillisecondth(cell.getStringCellValue());//
                    } else if (c == 6) {
                        aRcuSetparam.setMillisecondtw(cell.getStringCellValue());//
                    } else if (c == 7) {
                        if (!"".equals(cell.getStringCellValue())) {
                            aRcuSetparam.setSecond(cell.getStringCellValue());//
                        }
                    } else if (c == 8) {
                        aRcuSetparam.setMinutes(cell.getStringCellValue());//
                    } else if (c == 9) {
                        aRcuSetparam.setHour(cell.getStringCellValue());//
                    } else if (c == 10) {
                        aRcuSetparam.setRemark(cell.getStringCellValue());//
                    }
                    aRcuSetparam.setRcuid(ZhsUnique.unique25());
                }
            }
            //添加客户
            customerList.add(aRcuSetparam);
        }
        return customerList;
    }

}
