package com.llz.dao;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author lilingzhi
 * @date 2017年5月2日 上午9:42:38
 */

public interface BaseDao {
	
	public ResultSet executeQuery(String sql, List<Object> objs);

	public int executeUpdate(String sql, List<Object> objs);

}
