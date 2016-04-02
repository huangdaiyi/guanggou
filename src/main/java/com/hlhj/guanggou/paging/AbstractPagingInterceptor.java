package com.hlhj.guanggou.paging;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * MyBatis 分页拦截器抽象类
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public abstract class AbstractPagingInterceptor implements Interceptor {

    private static final String PROP_PAGING = "paging";
    private static final String PROP_PAGING_DEFAULT = "Paging";

    private String paging;
    
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();

        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        String statementId = mappedStatement.getId();
        if (!statementId.endsWith(paging)) {
            return invocation.proceed();
        }
        
        ParameterHandler parameterHandler = statementHandler.getParameterHandler();
        Object param = parameterHandler.getParameterObject();
        if (!(param instanceof Paging)) {
			return invocation.proceed();
		}
        
        Paging paging = (Paging)parameterHandler.getParameterObject();
        
        String pagingSql = getPagingSql(sql, paging);

        metaObject.setValue("delegate.boundSql.sql", pagingSql);
        metaObject.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
        metaObject.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);

        Connection connection = (Connection) invocation.getArgs()[0];
        int totalCount = getTotalCount(connection, sql, parameterHandler);
        TotalCountHolder.set(totalCount);

        return invocation.proceed();
    }

    public abstract String getPagingSql(String oldSql, Paging paging);

    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        }
        return target;
    }

    @Override
    public void setProperties(Properties properties) {
        paging = properties.getProperty(PROP_PAGING, PROP_PAGING_DEFAULT);
    }

    private int getTotalCount(Connection connection, String sql, ParameterHandler parameterHandler) throws SQLException {
        int result = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String countSql = getCountSql(sql);
            ps = connection.prepareStatement(countSql);
            parameterHandler.setParameters(ps);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return result;
    }

    public abstract String getCountSql(String sql);
}
