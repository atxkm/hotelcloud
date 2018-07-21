package cn.zhsit.common.utils.page;
import java.util.ArrayList;
import java.util.List;


/**
 * 分页对象
 */
public class ReturnPage<T> extends ArrayList<T> implements java.io.Serializable {
     
    private static final long serialVersionUID = 1L;
    
    private int DEFAULT_PAGE_SIZE = 15;
    private int DEFAULT_CURRENTPAGE = 1;
    private int DEFAULT_START = 0;
    
    private int pageSize; // 每页默认15条数据
    private int currentPage; // 当前页
    private int totalPages; // 总页数
    private int totalCount; // 总数据数
    private int start;//mobile端用，从第几条数据开始分页
    
    public ReturnPage(int totalCount, int pageSize, List<T> objList) {
        this.addAll(objList);
        this.init(totalCount, pageSize);
    }
    
    public ReturnPage(List<T> objList) {
        this.addAll(objList);
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.currentPage = DEFAULT_CURRENTPAGE;
        this.start=DEFAULT_START;
    }

    
    public List<T> getObjList() {
        return this;
    }

    /**
     * 初始化分页参数:需要先设置totalRows
     */

    private void init(int totalCount, int pageSize) {
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        if ((totalCount % pageSize) == 0) {
            totalPages = totalCount / pageSize;
        } else {
            totalPages = totalCount / pageSize + 1;
        }

    }

    public void init(int totalCount, int pageSize, int currentPage) {
        this.currentPage = currentPage;
        this.init(totalCount, pageSize);        
    }
    
    public static<T> ReturnPage<T> getInstanceByStartAndLimit(Integer start, Integer limit, List<T> objList) {
        ReturnPage<T> page = new ReturnPage<T>(objList);
        Integer currentPage = page.DEFAULT_CURRENTPAGE;
        Integer pageSize = page.DEFAULT_PAGE_SIZE;
        if (limit!=null) {
            pageSize = limit;
        }
        if (start!=null) {
            page.setStart(start);
            currentPage = start/ pageSize + 1;
        }
        page.setPageSize(pageSize);
        page.setCurrentPage(currentPage);
        return page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 
     * @return mobile端用，从第几条数据开始分页
     */
    public int getStart() {
        return start;
    }

    /**
     * 
     * @param start mobile端用，从第几条数据开始分页
     */
    public void setStart(int start) {
        this.start = start;
    }
}
