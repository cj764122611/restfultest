package com.yc.beans;

import java.io.Serializable;
/**
 * table person
 * id 编号
 * name 姓名
 * @author 陈杰
 *
 */
public class Person implements Serializable{
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 5569660200828012696L;
	
	/**
	 *  id  编号
	 */
	private Integer id;
	/**
	 * name 姓名
	 */
	private String name;
	/**
	 * 获取编号
	 * @return 编号
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置编号id
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取姓名
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 设置姓名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	

}
