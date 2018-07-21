package cn.zhsit.common.utils;

import cn.zhsit.common.constants.ZhsConstants;
import cn.zhsit.common.enums.FileType;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.StringJoiner;

/**
 * Created by zhsit on 2016/9/8.
 */
public class ZhsFileUtils {
    private static Logger log = LoggerFactory.getLogger(ZhsFileUtils.class);

    public static void writeFile(HttpServletRequest request, HttpServletResponse response, byte[] bytes, String fileName) throws Exception {
        OutputStream outputStream = null;
        try {
            response.reset();
            // 下载MIME类型
            response.setContentType("application/x-download");
            String userAgent = request.getHeader("USER-AGENT").toLowerCase();
            String fileDisplay = transCharacter(userAgent, fileName);
            response.addHeader("Content-Disposition", "attachment;filename=" + fileDisplay);
            // 输出文件流
            outputStream = new BufferedOutputStream(response.getOutputStream());
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            if (e instanceof IOException) {
                return;
            }
            log.error("writeFile时异常,{}", e);
        } finally {
            try {
                if (null != outputStream) {
                    outputStream.close();
                }
                response.getOutputStream().close();
            } catch (Exception e) {
            }
        }
    }


    private static String transCharacter(String userAgent, String fileName) throws Exception {
        // firefox
        if (userAgent != null && userAgent.indexOf("firefox") > 0) {
            // Content-Type="application/x-download; charset=utf-8"不起作用
            return new String(fileName.getBytes("UTF-8"), "ISO8859-1");
        } else {
            // msie和chrome
            return URLEncoder.encode(fileName, "UTF-8");
        }
    }

    /**
     * @param basePath 存放文件的根目录，当为null时为zhsstore，没特殊要求请设置为null
     * @param folder   根目录下的子文件夹，可使用{@link #location 获取}
     * @param name     文件名称,可使用{@link ZhsUnique#unique25}获取不重复的25位字符串
     * @param data     文件数据
     * @return
     */
    public static boolean saveFile(String basePath, String folder, String name, byte[] data) {
        boolean success = false;
        FileOutputStream fos = null;
        try {
            if (basePath == null) {
                basePath = "zhsstore";
            }
            if (folder == null) {
                folder = "";
            } else if (folder.startsWith("/")) {
                folder = folder.substring(1);
            }
            if(folder.startsWith("zhsstore")){
                folder = folder.substring(8);
            }
            String allPath = basePath + "/" + folder;
            String fileIncludeName = allPath + "/" + name;
            File file = new File(fileIncludeName);
            if (!file.exists()) {
                File f = new File(allPath);
                if (!f.exists()) {
                    f.mkdirs();
                }
                f.createNewFile();
            }
            fos = new FileOutputStream(file);
            fos.write(data);
            fos.flush();
            success = true;
        } catch (Exception e) {
            log.error("写文件时异常,{}", e);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    log.error("文件流关闭失败");
                }
            }
        }
        return success;
    }

    /**
     * 船检文件夹
     *
     * @param basePath
     * @param path
     */
    private static void createFolder(String basePath, String path) {
        basePath = "zhsstore";
        String allPath = basePath + path;
        File f = new File(allPath);
        f.mkdirs();
        // new File("feng");1.当打包成jar后，默认在启动脚本start.sh的平级目录下生成 feng文件夹
        // new File("feng");2.当在IDE内执行MainApplication启动时，在根pom.xml平级生产feng文件夹
        // new File("/feng"),生成目录为可执行文件所在的磁盘根目录下,如D:/feng
        //new File("e:/feng"),生成目录为E:/feng


//path2:/D:/src/book/bookserver/target/classes/
//path3:/D:/src/book/bookserver/target/classes/
//path4:/D:/src/book/share/target/classes/cn/zhsit/common/utils/
    }

    /**
     * 根据文件全名获取我文件后缀
     *
     * @param fileName
     * @return 含有".",例 ".png"
     */
    public static String filePostfix(String fileName) {
        if (!fileName.contains(".")) {
            return null;
        }
        int lastIndexOfPoint = fileName.lastIndexOf(".");
        return fileName.substring(lastIndexOfPoint);
    }

    /**
     * 根据文件类型和年月划分的文件路径
     *
     * @param ft
     * @return
     */
    public static String location(FileType ft) {
        int year = Calendar.getInstance().get(Calendar.YEAR) - 2000;
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
//        int date = Calendar.getInstance().get(Calendar.DATE);
        StringJoiner joiner = new StringJoiner("/");
        return joiner.add(ft.getType())
                .add(year + "")
                .add(month + "")
//                .add(date + "")
                .toString()
                ;

    }


    /**
     * @param relativePathName 相对路径
     * @return
     */
    public static byte[] readFile(String relativePathName) {
        try {
            File file = new File(relativePathName);
            if (!file.exists()) {
                return null;
            }
            return FileUtils.readFileToByteArray(file);
        } catch (Exception ex) {
            log.error("读取文件:" + relativePathName + "失败。");
        }
        return null;
    }

    /**
     * @param basePath         根路径，若为null，则默认为
     * @param relativePathName ,basePath下的相对路径
     * @return
     */
    public static byte[] readFile(String basePath, String relativePathName) {
        if (basePath == null) {
            basePath = "zhsstore";
        }
        if (relativePathName.startsWith("/")) {
            relativePathName = relativePathName.substring(1);
        }
        try {
            File file = new File(basePath + "/" + relativePathName);
            if (!file.exists()) {
                return null;
            }
            return FileUtils.readFileToByteArray(file);
        } catch (Exception ex) {
            log.error("读取文件:" + relativePathName + "失败。");
        }
        return null;
    }

    /**
     * 读取文件名称，并把名称UTF8转字节，
     *
     * @param basePath
     * @param relativePathName
     * @return byte[名称长度（4字节）+名称字节数组]
     */
    public static byte[] readFileNameData(String basePath, String relativePathName) {
        if (basePath == null) {
            basePath = "zhsstore";
        }
        if (relativePathName.startsWith("/")) {
            relativePathName = relativePathName.substring(1);
        }
        try {
            File file = new File(basePath + "/" + relativePathName);
            if (!file.exists()) {
                return null;
            }
            String name = FilenameUtils.getName(file.getName());
            byte[] nameByteArray = name.getBytes(ZhsConstants.UTF8);
            byte[] lengthByte4 = ZhsByteUtil.intToByte4(nameByteArray.length);
            byte[] nameArray = new byte[lengthByte4.length + nameByteArray.length];
            int i = 0;
            for (byte b : lengthByte4) {
                nameArray[i++] = b;
            }
            for (byte b : nameByteArray) {
                nameArray[i++] = b;
            }
            return nameArray;
        } catch (Exception ex) {
            log.error("读取文件:" + relativePathName + "失败。");
        }
        return null;
    }

    /**
     * 读取文件名称，并把名称UTF8转字节，
     *
     * @param basePath
     * @param relativePathName
     * @return byte[名称长度（4字节）+名称字节数组]
     */
    public static byte[] readFilePathNameData(String basePath, String relativePathName) {
        if (basePath == null) {
            basePath = "zhsstore";
        }
        if (relativePathName.startsWith("/")) {
            relativePathName = relativePathName.substring(1);
        }
        try {
            String pathName = basePath + "/" + relativePathName;
            File file = new File(pathName);
            if (!file.exists()) {
                return null;
            }

            //
            byte[] pathNameByteArray = pathName.getBytes("UTF-8");
            byte[] lengthByte4 = ZhsByteUtil.intToByte4(pathNameByteArray.length);
            byte[] pathNameArray = new byte[lengthByte4.length + pathNameByteArray.length];
            int i = 0;
            for (byte b : lengthByte4) {
                pathNameArray[i++] = b;
            }
            for (byte b : pathNameByteArray) {
                pathNameArray[i++] = b;
            }
            return pathNameArray;
        } catch (Exception ex) {
            log.error("读取文件:" + relativePathName + "失败。");
        }
        return null;
    }


    /**
     * [文件名称长度(4)字节，文件名称（UTF8）字节 ，文件内容]
     * 文件相对名称长度 4字节
     *
     * @return
     */
    public static byte[] getFileIncludeName(String pathName) {
        byte[] fileNameData = ZhsFileUtils.readFileNameData(null, pathName);
        byte[] fileData = ZhsFileUtils.readFile(null, pathName);
        byte[] file = new byte[fileNameData.length + fileData.length];
        int i = 0;
        for (byte b : fileNameData) {
            file[i++] = b;
        }
        for (byte b : fileData) {
            file[i++] = b;
        }
        return file;
    }

    /**
     * [文件路径名称长度(4)字节，文件名称（UTF8）字节 ，文件内容]
     * 文件名称长度 4字节
     *
     * @return
     */
    public static byte[] getFileIncludePathName(String pathName) {
        byte[] fileNameData = ZhsFileUtils.readFilePathNameData(null, pathName);
        byte[] fileData = ZhsFileUtils.readFile(null, pathName);
        byte[] file = new byte[fileNameData.length + fileData.length];
        int i = 0;
        for (byte b : fileNameData) {
            file[i++] = b;
        }
        for (byte b : fileData) {
            file[i++] = b;
        }
        return file;
    }

    /**
     * 获取文件路径
     *
     * @param pathName 文件路径和名称
     * @return
     */
    public static String getPath(String pathName) {
        pathName = pathName.replaceAll("\\\\", "/");
        int pathIndex = pathName.lastIndexOf("/");
        if (pathIndex < 0) {
            return "";
        }
        String path = pathName.substring(0, pathIndex);
        return path;
    }

    /**
     * 获取文件名称
     *
     * @param pathName 文件路径和名称
     * @return
     */
    public static String getName(String pathName) {
        pathName = pathName.replaceAll("\\\\", "/");
        int pathIndex = pathName.lastIndexOf("/");
        if (pathIndex < 0) {
            return pathName;
        }
        String path = pathName.substring(pathIndex + 1, pathName.length());
        return path;
    }

    public static void main44444(String[] args) {
        System.out.println(getPath("\\fang\\text.txt"));
        System.out.println(getPath("fang\\text.txt"));
        System.out.println(getPath("text.txt"));
        System.out.println(getPath("\\text.txt"));
        System.out.println(getPath("/text.txt"));

        System.out.println("获取名称");

        System.out.println(getName("\\fang\\text.txt"));
        System.out.println(getName("fang\\text.txt"));
        System.out.println(getName("text.txt"));
        System.out.println(getName("\\text.txt"));
        System.out.println(getName("/text.txt"));
    }
}
