package com.itheima.shop.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		// 强转成子接口
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		// 获取客户端请求的方式
		String method = request.getMethod();
		// 如果POST的话
		if ("POST".equalsIgnoreCase(method)) {
			// 解决POST乱码问题
			request.setCharacterEncoding("UTF-8");
			// 放行请求，进行UserServlet
			chain.doFilter(request, response);
			System.out.println("=========EncodingFilter--放行POST请求");
			
		} else if ("GET".equalsIgnoreCase(method)) {
			// 创建一个新的Request对象
			MyRequest myRequest = new MyRequest(request);
			// 放行请求，将新的Request对象传入到UserServlet或JSP中
			chain.doFilter(myRequest, response);
			System.out.println("=========EncodingFilter--放行GET请求");
		}
	}

	@Override
	public void destroy() {
	}
}

/**
 * 创建新的Request类
 */
class MyRequest extends HttpServletRequestWrapper {
	private HttpServletRequest request;

	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	/**
	 * 重写getParameter方法
	 */
	@Override
	public String getParameter(String name) {
		// 使用旧的Request来获取值，这个是在GET请求下是乱码
		String value = request.getParameter(name);
		// 如果value有值
		if (value != null && value.trim().length() > 0) {
			try {
				value = value.trim();
				byte[] buf = value.getBytes("ISO8859-1");
				value = new String(buf, "UTF-8");
				return value;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			// 如果value无值
		} else {
			return null;
		}
	}

	/**
	 * 重写getParameterMap()方法
	 */
	@Override
	public Map<String, String[]> getParameterMap() {
		// Map的value是乱码
		Map<String, String[]> map = request.getParameterMap();
		// 迭代
		for (Entry<String, String[]> entry : map.entrySet()) {
			// values = {"??","??","??"}
			String[] values = entry.getValue();
			// 迭代
			for (int i = 0; i < values.length; i++) {
				try {
					// 乱码
					String value = values[i];
					byte[] buf = value.getBytes("ISO8859-1");
					// 正码
					value = new String(buf, "UTF-8");
					values[i] = value;
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}// in for
		}// out for
		return map;
	}
}
