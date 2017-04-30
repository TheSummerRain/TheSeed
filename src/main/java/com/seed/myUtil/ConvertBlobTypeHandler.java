package com.seed.myUtil;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.sql.*;

/**
 * 实现数据内容 blob类型转换string的乱码解决。
 * 自定义typehandler，解决mybatis存储blob字段后，出现乱码的问题
 */
public class ConvertBlobTypeHandler extends BaseTypeHandler<String> {  
    //###指定字符集  
    private static final String DEFAULT_CHARSET = "utf-8";  
  
    @Override  
    public void setNonNullParameter(PreparedStatement ps, int i,  
            String parameter, JdbcType jdbcType) throws SQLException {  
        ByteArrayInputStream bis;  
        try {  
            //###把String转化成byte流  
        	if(parameter==null){
        		return;
        	}
            bis = new ByteArrayInputStream(parameter.getBytes(DEFAULT_CHARSET));  
        } catch (UnsupportedEncodingException e) {  
            throw new RuntimeException("Blob Encoding Error!");  
        }     
        ps.setBinaryStream(i, bis, parameter.length());  
    }  
  
    @Override  
    public String getNullableResult(ResultSet rs, String columnName)  
            throws SQLException {  
        Blob blob = rs.getBlob(columnName);  
        byte[] returnValue = null;  
        if (null != blob) {  
            returnValue = blob.getBytes(1, (int) blob.length());  
        }  
        try {  
            //###把byte转化成string  
        	if(returnValue==null){
        		return null;
        	}
            return new String(returnValue, DEFAULT_CHARSET);  
        } catch (UnsupportedEncodingException e) {  
            throw new RuntimeException("Blob Encoding Error!");  
        }  
    }  
  
    @Override  
    public String getNullableResult(CallableStatement cs, int columnIndex)  
            throws SQLException {  
        Blob blob = cs.getBlob(columnIndex);  
        byte[] returnValue = null;  
        if (null != blob) {  
            returnValue = blob.getBytes(1, (int) blob.length());  
        }  
        try {  
        	if(returnValue==null){
        		return null;
        	}
            return new String(returnValue, DEFAULT_CHARSET);  
        } catch (UnsupportedEncodingException e) {  
            throw new RuntimeException("Blob Encoding Error!");  
        }  
    }

	@Override
	public String getNullableResult(ResultSet arg0, int arg1)
			throws SQLException {
		return null;
	}  
} 

