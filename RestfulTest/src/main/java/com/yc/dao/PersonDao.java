package com.yc.dao;

import java.util.List;
import java.util.Map;

import com.yc.beans.Person;

/**
 * personDao接口类
 * @author 陈杰
 * @date 2018/12/04
 */
public interface PersonDao {
	/**
	 * 查询所有用户的信息
	 * @return
	 */
	public List<Person> selectAll();
	
	/**
	 * 修改用户的信息
	 * @param person
	 * @return
	 */
	public Integer updatePersonInfo(Person person);
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public Integer deletePersonInfo(Integer id);
	
	/**
	 * 添加用户信息
	 * @param person
	 * @return
	 */
	public Integer addPersonInfo(Person person);
	
	/**
	 * 查询用户的信息 
	 * @param map
	 * @return
	 */
	public List<Person> selectPersonInfoPage(Map<String, Object> map);
	
	/**
	 * 统计用户信息的条数
	 * @return
	 */
	public Integer findCount();
	
	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	public Person selectOne(Integer id);
	
	
}
