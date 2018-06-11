package com.llz.dao.impl;

import java.sql.*;
import java.util.List;

import com.llz.dao.BaseDao;
import com.llz.utils.SqlTools;

/**
 * @author lilingzhi
 * @date 2017年5月2日 上午10:43:59
 */

public class BaseDaoImpl implements BaseDao {

	public Connection con = null;
	public PreparedStatement pstm = null;
	public ResultSet rs = null;
	public int num = -1;

	// 查询
	@Override
	public ResultSet executeQuery(String sql, List<Object> objs) {
		// 1.获取连接
		con = SqlTools.getConn();
		// 2.设置参数
		try {
			pstm = con.prepareStatement(sql);
			if (objs != null) {
				for (int i = 0; i < objs.size(); i++) {
					pstm.setObject(i + 1, objs.get(i));
				}
			}
			// 3.执行语句
			rs = pstm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	// 更新
	@Override
	public int executeUpdate(String sql, List<Object> objs) {
		con = SqlTools.getConn();
		try {
			pstm = con.prepareStatement(sql);
			if (objs != null) {
				for (int i = 0; i < objs.size(); i++) {
					pstm.setObject(i + 1, objs.get(i));
				}
			}
			num = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}/* finally {
			SqlTools.closeConn();
		}*/
		return num;
	}

}
