package com.yc.biz;

import java.util.List;
import java.util.Map;

import com.yc.beans.Person;
import com.yc.web.dto.PageSet;

/**
 * 业务逻辑层
 * @author 陈杰
 * @date 2018/12/04
 */
public interface PersonBiz {
	/**
	 * 查询所有用户的信息
	 * @return list 用户集合
	 */
	public List<Person> selectAll();
	
	/**
	 * 修改用户的信息
	 * @param person
	 * @return 是否成功  成功 :>0  不成功：<=0
	 */
	public Integer updatePersonInfo(Person person);
	
	/**
	 * 删除用户
	 * @param id
	 * @return 是否成功  成功 :>0  不成功：<=0 
	 */
	public Integer deletePersonInfo(Integer id);
	
	/**
	 * 添加用户信息
	 * @param person
	 * @return 是否成功  成功 :>0  不成功：<=0
	 */
	public Integer addPersonInfo(Person person);
	
	/**
	 * 查询用户的信息 
	 * @param map
	 * @return  返回一个分页的类
	 */
	public PageSet<Person> selectPersonInfoPage(Map<String, Object> map);
	/**
	 * 根据id查询一个人的信息
	 * @param id
	 * @return
	 */
	public Person selectOne(Integer id);

	
	
}
