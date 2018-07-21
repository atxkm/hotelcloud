package cn.zhsit.common.utils.page;

import cn.zhsit.common.utils.ZhsReflectUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class,Integer.class})})
@Component
public class PageInterceptor implements Interceptor {

    private String dataBaseType="mysql";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Page page = null;
        RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
        StatementHandler delegate = (StatementHandler) ZhsReflectUtil.getFieldValue(handler, "delegate");
        BoundSql boundSql = delegate.getBoundSql();
        Object obj = boundSql.getParameterObject();
        if (obj instanceof BaseExample) {
            page = ((BaseExample) obj).getPage();
        } else if (obj instanceof Map) {
            Map map = (Map)obj;
            Iterator its = map.keySet().iterator();
            while (its.hasNext()){
                Object en_key =its.next();
                Object en_val=   map.get(en_key);
                if(en_val instanceof BaseExample){
                    page=((BaseExample) en_val).getPage();
                    break;
                }
            }
        }
        if (null == page) {
            return invocation.proceed();
        }
        String sql = boundSql.getSql();
        sql = getPageSql(page, sql);
        ZhsReflectUtil.setFieldValue(boundSql, "sql", sql);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

    private String getPageSql(Page page, String sql) {
        String trimSql = StringUtils.trim(sql);
       boolean isSelectSql = StringUtils.startsWithIgnoreCase(trimSql,"select");

        if(!isSelectSql){
            return sql;
        }
        if (dataBaseType.equalsIgnoreCase("mysql")) {
            return getMySQLPageSql(page, sql);
        }
        return sql;
    }

    private String getMySQLPageSql(Page page, String sql) {
        if(StringUtils.startsWithIgnoreCase(sql,"select count(*) from")){
            return sql;
        }
        StringBuilder sb = new StringBuilder();
        long currentPage = page.getPage() < 0 ? 0 : page.getPage();
        long offset = currentPage  * page.getRows();
        sb.append(sql).append(" limit ").append(offset).append(",").append(page.getRows());
        return sb.toString();
    }

    public void setDataBaseType(String dataBaseType) {
        this.dataBaseType = dataBaseType;
    }
}