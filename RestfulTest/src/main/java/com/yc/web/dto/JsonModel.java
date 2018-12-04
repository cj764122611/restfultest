package com.yc.web.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;
/**
 * 存放json数据的类
 * @author 陈杰
 * @date 2018/12/04
 */
@Component
public class JsonModel implements Serializable{

	/**
	 * 实现序列化
	 */
	private static final long serialVersionUID = 9106902882602433353L;
	
	/**
	 * 返回的状态  成功：1   失败：0
	 */
	private Integer code;
	/**
	 * 用来存放要传输的数据，如：int ，String，包装好的类
	 */
	private Object obj;
	/**
	 * 存放错误信息
	 */
	private String errorMsg;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	@Override
	public String toString() {
		return "JsonModel [code=" + code + ", obj=" + obj + ", errorMsg=" + errorMsg + "]";
	}
	
}
