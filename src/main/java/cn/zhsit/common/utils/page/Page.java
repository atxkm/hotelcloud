package cn.zhsit.common.utils.page;

import java.io.Serializable;

/**
 * 分页对象
 */
public class Page implements Serializable {

    // 当前页,默认是第一页(从零开始,0页是第一页)
    private long page = 0;
    //总条数
    private Long total=0L;
    // 每页数据条数,默认10条
    private long rows = 10;
    //分页条显示的页总数
    private long showPageSize = 9;
    //分页条显示的最前面的页号，从0开始
    private long firstPageNum = 0;
    //分页条显示的最后面的页号,从0开始
    private long lastPageNum = 0;
    //升序或降序 asc 或 desc
    private String order;

    //排序字段名
    private String sort;

    
   
    /**
     * 获取总页数
     *
     * @return
     */
    public Long getTotalPageSize() {
        if (total==null||total < 1) {
            return 0L;
        }
        double totalDouble = Double.valueOf(total);
        double rowsDouble = Double.valueOf(rows);
        Double totalPageSizeDouble = Math.ceil(totalDouble / rowsDouble);
        return totalPageSizeDouble.longValue();
    }

    /**
     * 获取当前页
     *
     * @return
     */
    public Long getPage() {
        if (total==null||total < 1) {
            return page;
        }

        long totalPageSize = getTotalPageSize()-1;
        if (page >= totalPageSize) {
            page = totalPageSize;
        }
        if (page < 0) {
            page = 0;
        }
        return page;
    }

    public Page setPage(int page) {
        this.page = page;
        return this;
    }

    public long getRows() {
        return rows;
    }

    public Page setRows(int rows) {
        this.rows = rows;
        return this;
    }

    public String getOrder() {
        return order;
    }

    public Page setOrder(String order) {
        this.order = order;
        return this;
    }

    public String getSort() {
        return sort;
    }

    public Page setSort(String sort) {
        this.sort = sort;
        return this;
    }

    public Long getTotal() {
        if (null == total) {
            return 0L;
        }
        return total;
    }

    public Page setTotal(Long total) {
        this.total = total;
        return this;
    }



   

	public Page setShowPageSize(long showPageSize) {
        this.showPageSize = showPageSize;
        return this;
    }

    public long getFirstPageNum() {
        long halfShowPageSize = showPageSize / 2;
        if ((getPage() + halfShowPageSize) <= getTotalPageSize()) {
            firstPageNum = getPage() - halfShowPageSize;
        } else {
            long lastPageNum = getTotalPageSize();
            firstPageNum = lastPageNum - showPageSize;

        }
        if (firstPageNum < 0) {
            firstPageNum = 0;
        }
        return firstPageNum;
    }

    public long getLastPageNum() {
        long halfShowPageSize = showPageSize / 2;
        if ((getPage() + halfShowPageSize) <= getTotalPageSize()) {
            long firstPageNum = getPage() - halfShowPageSize;
            if (firstPageNum < 0) {
                firstPageNum = 0;
            }
            lastPageNum = firstPageNum + showPageSize;
            if (lastPageNum >= getTotalPageSize()) {
                lastPageNum = getTotalPageSize()-1;
            }
        } else {
            lastPageNum = getTotalPageSize()-1;
        }
        if(lastPageNum<0){
            lastPageNum=0;
        }
        return lastPageNum;
    }

}
