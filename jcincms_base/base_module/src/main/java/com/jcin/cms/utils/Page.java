package com.jcin.cms.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页查询时的辅助工具类
 * 
 * @author linzongxue
 * 
 */
public class Page {
	private int limit = 20; // 每页显示条数
	private int start = 0; // 起始行号
	private int pageSize = 10; // 每页显示条数
	private int total = 0; // 总数
	private List rows = new ArrayList(); // 结果集
	private int page = 1; // 第几页
	
	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage(){
		return total/pageSize;
	}
}
