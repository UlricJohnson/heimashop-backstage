package com.itheima.shop.entity;

import java.util.List;

/**
 * 分页实体类
 * 
 * 设计为泛型类，可以用于呈现任何类型的数据
 * 
 * @author Ulric
 * 
 */

public class Page <T> {
	private List<T> contentList; // 要展示的内容
	private int currPage; // 当前页数
	private int totPage; // 总页数
	private int recordPerPage;// 每页要显示的记录数
	private int totRecords;// 总记录数

	public Page() {
	}

	/***** get set *****/
	public List<T> getContentList() {
		return contentList;
	}

	public void setContentList(List<T> contentList) {
		this.contentList = contentList;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getTotPage() {
		return totPage;
	}

	public void setTotPage(int totPage) {
		this.totPage = totPage;
	}

	public int getRecordPerPage() {
		return recordPerPage;
	}

	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}

	public int getTotRecords() {
		return totRecords;
	}

	public void setTotRecords(int totRecords) {
		this.totRecords = totRecords;
	}

}
