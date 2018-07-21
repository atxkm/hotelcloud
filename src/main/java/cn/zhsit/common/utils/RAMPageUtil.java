package cn.zhsit.common.utils;

import org.apache.poi.util.StringUtil;
import org.springframework.util.StringUtils;
import sun.tools.java.Constants;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class RAMPageUtil {
    public static final int PAGESIZE = 10;
    /**
     * 根据传入的数组和页码返回分页后的数组
     * @param original 全量数据的数组
     * @param pageNum 页码
     * @param <T>
     * @return 返回分页后的对应页码页面的数据
     */
    public static <T> T[] page(T[] original, int pageNum) {
        return page(original,pageNum, PAGESIZE);
    }
    /**
     * 根据传入的数组和页码返回分页后的数组
     * @param original 全量数据的数组
     * @param pageNum 页码
     * @param <T>
     * @return 返回分页后的对应页码页面的数据
     */
    public static <T> T[] page(T[] original, String pageNum) {
        if(StringUtils.isEmpty(pageNum) && !Pattern.compile("\\d+").matcher(pageNum).matches()) pageNum = "1";
        return page(original,Integer.parseInt(pageNum));
    }

    /**
     * 根据传入的数组和页码返回分页后的数组
     * @param original 全量数据的数组
     * @param pageNum 页码
     * @param pageSize 每页数据条数
     * @param <T>
     * @return 返回分页后的对应页码页面的数据
     */
    public static <T> T[] page(T[] original, int pageNum, int pageSize) {
        if(null==original || original.length == 0) return (T[]) Array.newInstance(original.getClass().getComponentType(), 0);
        if (pageNum <= 0) pageNum = 1;
        int from = (pageNum - 1) * pageSize;
        int to = pageNum * pageSize;
        if(to > original.length) to = original.length;
        if(from>=original.length || to <= from) return (T[]) Array.newInstance(original.getClass().getComponentType(), 0);
        return Arrays.copyOfRange(original, from, to);
    }

    /**
     * 根据传入的List和页码返回分页后的List
     * @param original 全量的List数据
     * @param pageNum 页码
     * @param <T>
     * @return 返回分页后的对应页码页面的List
     */
    public static <T> List<T> page(List<T> original,int pageNum){
        return page(original, pageNum, PAGESIZE);
    }
    /**
     * 根据传入的数组和页码返回分页后的数组
     * @param original 全量数据的数组
     * @param pageNum 页码
     * @param <T>
     * @return 返回分页后的对应页码页面的数据
     */
    public static <T> List<T> page(List<T> original, String pageNum) {
        if(StringUtils.isEmpty(pageNum) && !Pattern.compile("\\d+").matcher(pageNum).matches()) pageNum = "1";
        return page(original,Integer.parseInt(pageNum));
    }
    /**
     * 根据传入的List和页码返回分页后的List
     * @param original 全量的List数据
     * @param pageNum 页码
     * @param pageSize 每页数据条数
     * @param <T>
     * @return 返回分页后的对应页码页面的List
     */
    public static <T> List<T> page(List<T> original,int pageNum,int pageSize){
        List list = new ArrayList<T>();
        Collections.addAll(list,page(original.toArray(),pageNum,pageSize));
        return list;
    }
}
