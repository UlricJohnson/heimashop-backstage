package com.itheima.shop.service;

import java.sql.SQLException;
import java.util.List;

import redis.clients.jedis.Jedis;

import com.google.gson.Gson;
import com.itheima.shop.dao.CategoryDao;
import com.itheima.shop.entity.Category;
import com.itheima.shop.util.JedisUtil;

/**
 * 
 * @author Ulric
 * 
 */

public class CategoryService {

	public CategoryService() {
	}

	/**
	 * 获取所有商品类别
	 */
	public String getAllCategoties() {
		System.out.println("========CategoryService--getAllCategoties()");

		String cateJsonStr = null;// 用于存放商品类别Json字符串

		/** 先去redis查找 **/
		System.out.println("######从redis中查询数据");
		Jedis jedis = JedisUtil.getJedis();
		cateJsonStr = jedis.get("categories");

		/** redis中没有商品类别数据，就去mysql找 **/
		if (cateJsonStr == null || cateJsonStr.isEmpty()) {
			System.out.println("######从mysql中查询数据");
			try {
				// 获取Category集合
				CategoryDao dao = new CategoryDao();
				List<Category> categoriesList = dao.getAllCategoties();

				// 转成json字符串
				Gson gson = new Gson();
				cateJsonStr = gson.toJson(categoriesList);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println("########查询结果：" + cateJsonStr);

		return cateJsonStr;
	}

}
