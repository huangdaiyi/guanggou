package com.hlhj.guanggou.paging;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;

import java.sql.Connection;

/**
 * 基于 MySQL 的 MyBatis 分页拦截器实现
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
@Intercepts(
    @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})
)
public class MySQLPagingInterceptor extends AbstractPagingInterceptor {

    @Override
    public String getPagingSql(String sql, Paging paging) {
        return String.format("%s LIMIT %d, %d", sql, paging.getOffset(), paging.getPageSize());
    }

    @Override
    public String getCountSql(String sql) {
        int index = sql.indexOf("LIMIT");
        if (index != -1) {
            sql = sql.substring(0, index).trim();
        }
        return "SELECT count(0) FROM (" + sql + ") temp";
    }
}
