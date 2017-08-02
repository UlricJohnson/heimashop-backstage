package com.itheima.shop.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.shop.entity.Category;
import com.itheima.shop.util.JdbcUtil;

public class CategoryDao {
	static QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());

	public CategoryDao() {
	}

	/**
	 * 获取所有商品类别
	 * 
	 * @throws SQLException
	 */
	public List<Category> getAllCategoties() throws SQLException {
		System.out.println("========CategoryDao--getAllCategoties()");

		String sql = "select * from category order by cid;";

		Object[] params = null;
		return runner.query(sql, new BeanListHandler<Category>(Category.class),
				params);
	}

}
