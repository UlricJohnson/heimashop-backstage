package com.itheima.shop.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 项目中所有servlet类的父类
 * 
 * 子类servlet中没有doGet() 和 doPost()
 * 
 * 故子类servlet接收到请求的时候会调用父类的do方法
 * 
 * 在父类的do方法中接收参数action(要进行的操作，约定为servlet中的方法名)
 * 
 * 根据action值利用反射去调用子类servlet中的相应方法
 * 
 * @author Ulric
 * 
 */

public class BaseServlet extends HttpServlet {
	public BaseServlet() {
		System.out.println("=======BaseServlet()");
	}

	/**
	 * 加上final防止子类重写
	 */
	@Override
	public final void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("=======BaseServlet()--doGet()");

		// 获取action
		String action = req.getParameter("action");

		// 创建Class类对象
		Class cls = this.getClass();// this代表具体的servlet子类对象

		try {
			// 获取指定函数名的Method对象
			Method method = cls.getDeclaredMethod(action,
					HttpServletRequest.class, HttpServletResponse.class);// 方法参数为请求和响应
			method.setAccessible(true);// 由于是私有函数，所以需要设置暴力反射

			// 调用方法
			method.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("ERRORMSG", "系统错误");
			req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
		}
	}

	public final void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
