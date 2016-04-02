package com.hlhj.guanggou.constant;
import java.sql.CallableStatement;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
  
import org.apache.ibatis.type.BaseTypeHandler;  
import org.apache.ibatis.type.JdbcType;  
  

public class EnumStatusHandler extends BaseTypeHandler<CombinationStatus> {  
      
    private Class<CombinationStatus> type;  
       
    private final CombinationStatus[] enums;  
   
    /** 
     * 设置配置文件设置的转换类以及枚举类内容，供其他方法更便捷高效的实现 
     * @param type 配置文件中设置的转换类 
     */  
    public EnumStatusHandler(Class<CombinationStatus> type) {  
        if (type == null)  
            throw new IllegalArgumentException("Type argument cannot be null");  
        this.setType(type);  
        this.enums = type.getEnumConstants();  
        if (this.enums == null)  
            throw new IllegalArgumentException(type.getSimpleName()  
                    + " does not represent an enum type.");  
    }  
  
    @Override  
    public void setNonNullParameter(PreparedStatement ps, int i,  
    		CombinationStatus parameter, JdbcType jdbcType) throws SQLException {  
        // baseTypeHandler已经帮我们做了parameter的null判断  
        ps.setString(i, parameter.getStatus());  
          
    }  
  
    @Override  
    public CombinationStatus getNullableResult(ResultSet rs, String columnName)  
            throws SQLException {  
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放INT类型  
        String status = rs.getString(columnName);  
           
        if (rs.wasNull()) {  
            return null;  
        } else {  
            // 根据数据库中的code值，定位EnumStatus子类  
            return locateEnumStatus(status);  
        }  
    }  
  
    @Override  
    public CombinationStatus getNullableResult(ResultSet rs, int columnIndex)  
            throws SQLException {  
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放INT类型  
        String status = rs.getString(columnIndex);  
        if (rs.wasNull()) {  
            return null;  
        } else {  
            // 根据数据库中的code值，定位EnumStatus子类  
            return locateEnumStatus(status);  
        }  
    }  
  
    @Override  
    public CombinationStatus getNullableResult(CallableStatement cs, int columnIndex)  
            throws SQLException {  
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放INT类型  
        String status = cs.getString(columnIndex);  
        if (cs.wasNull()) {  
            return null;  
        } else {  
            // 根据数据库中的code值，定位EnumStatus子类  
            return locateEnumStatus(status);  
        }  
    }  
      
  
    private CombinationStatus locateEnumStatus(String status) {  
    	return CombinationStatus.parse(status);
    }

	public Class<CombinationStatus> getType() {
		return type;
	}

	public void setType(Class<CombinationStatus> type) {
		this.type = type;
	}  
  
} 