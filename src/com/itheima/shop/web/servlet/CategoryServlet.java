package com.itheima.shop.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.itheima.shop.service.CategoryService;

/**
 * 商品分类servlet
 * 
 * do方法继承自父类BaseServlet
 * 
 * 只需要写具体的操作方法
 * 
 * @author Ulric
 * 
 */

public class CategoryServlet extends BaseServlet {

	/**
	 * 获取所有类别
	 */
	private void getAllCategories(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("========CategoryServlet--getAllCategories()");

		Gson gson = new Gson();

		// 调用service层方法获取商品分类数据
		CategoryService service = new CategoryService();
		String cateJsonStr = service.getAllCategoties();// 以json字符串的形式返回

		// 写到datagrid中
		resp.setCharacterEncoding("UTF-8");
		PrintWriter pWriter = resp.getWriter();
		pWriter.write(cateJsonStr);
		pWriter.flush();
		pWriter.close();

	}
}
