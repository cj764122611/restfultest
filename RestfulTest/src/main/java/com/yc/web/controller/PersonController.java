package com.yc.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.beans.Person;
import com.yc.biz.PersonBiz;
import com.yc.web.dto.JsonModel;
import com.yc.web.dto.PageSet;

/**
 * person控制层 
 * @author 陈杰
 * @date 2018/12/04
 */
@RestController
@RequestMapping("/person")
public class PersonController {

	/**
	 * 创建personBiz对象
	 */
	@Resource(name = "personBizImpl")
	private PersonBiz personBiz;

	/**
	 * 根据用户的要求进行分页，返回json数据
	 * @param jsonModel
	 * @param pageSet
	 * @return
	 */
	@GetMapping("/all")
	public JsonModel selectPersonInfoPage(JsonModel jsonModel, PageSet<Person> pageSet,Map<String, Object> map) {
		map.put("page", pageSet.getPages());
		map.put("pageSize", pageSet.getPagesize());
		pageSet = personBiz.selectPersonInfoPage(map);
		if (pageSet.getList() != null) {
			jsonModel.setCode(1);
			jsonModel.setObj(pageSet);
		} else {
			jsonModel.setCode(0);
			jsonModel.setErrorMsg("查无信息.......");
		}
		return jsonModel;
	}
	
	/**
	 * 根据id查询单个用户的数据，返回json数据
	 * @param jsonModel
	 * @param id
	 * @param session
	 * @return
	 */
	@GetMapping("/one")
	public JsonModel selectOneInfo(JsonModel jsonModel,Integer id,HttpSession session) {
		Person person = personBiz.selectOne(id);
		jsonModel.setCode(1);
		jsonModel.setObj(person);
		return jsonModel;
	}
	
	/**
	 * 更新用户数据，返回json数据
	 * @param jsonModel
	 * @param person
	 * @return
	 */
	@PatchMapping("/update/{id}")
	public JsonModel updatePersonInfo(JsonModel jsonModel, Person person) {
		Integer result = personBiz.updatePersonInfo(person);
		if (result > 0) {
			jsonModel.setCode(1);
		} else {
			jsonModel.setCode(0);
			jsonModel.setErrorMsg("更新用户信息失败！！！！");

		}
		return jsonModel;

	}
	/**
	 * 删除用户数据，返回json数据
	 * @param jsonModel
	 * @param person
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public JsonModel deleteInfo(JsonModel jsonModel, Person person) {
		Integer result = personBiz.deletePersonInfo(person.getId());
		if (result > 0) {
			jsonModel.setCode(1);
		} else {
			jsonModel.setCode(0);
			jsonModel.setErrorMsg("删除用户信息失败！！！！");
		}
		return jsonModel;
	}
	
	/**
	 * 添加新的用户数据 返回json数据
	 * @param jsonModel
	 * @param person
	 * @return
	 */
	@PostMapping("/post/one")
	public JsonModel addPersonInfo(JsonModel jsonModel, Person person) {
		Integer result = personBiz.addPersonInfo(person);
		if (result > 0) {
			jsonModel.setCode(1);
		} else {
			jsonModel.setCode(0);
			jsonModel.setErrorMsg("添加用户信息失败！！！！");
		}
		return jsonModel;
	}

}
