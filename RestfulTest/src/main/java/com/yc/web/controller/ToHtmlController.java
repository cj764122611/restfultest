package com.yc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 负责跳转页面的控制层
 * @author 陈杰
 * @date 2018/12/04
 */
@Controller
public class ToHtmlController {
	
	/**
	 * 跳转到首页
	 * @return
	 */
	@RequestMapping("/")
	public String toIndex() {
		return "index";
	}
	
	/**
	 * 跳转到更新页面
	 * @param id
	 * @return
	 */
	@RequestMapping("/toUpdate.action")
	public String toUpdate(Integer id) {
		return "update";
	}
}
