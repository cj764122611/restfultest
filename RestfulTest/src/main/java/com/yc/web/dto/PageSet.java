package com.yc.web.dto;

import java.io.Serializable;
import java.util.List;
/**
 * 分页类
 * @author 陈杰
 * @date 2018/12/04
 */
public class PageSet<T> implements Serializable{
	
	/**
	 * 实现序列化
	 */
	private static final long serialVersionUID = 1262565905521592031L;
	/**
	 * 总条数
	 */
	private Integer total;
	/**
	 * 当前页数
	 */
	private Integer pages;
	/**
	 * 页面大小
	 */
	private Integer pagesize;
	/**
	 * 总页数
	 */
	private Integer pageNum;
	/**
	 * 数据集合
	 */
	private List<T> list;
	
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageSet [total=" + total + ", pages=" + pages + ", pagesize=" + pagesize + ", list=" + list + "]";
	}
	
 
}
