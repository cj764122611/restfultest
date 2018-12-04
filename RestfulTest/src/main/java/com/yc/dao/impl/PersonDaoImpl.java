package com.yc.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yc.beans.Person;
import com.yc.dao.PersonDao;

/**
 * personDao接口的实现类
 * 
 * @author 陈杰
 * @date 2018/12/04
 */
@Repository
public class PersonDaoImpl implements PersonDao {
	/**
	 * 常量 ：sql语句的路径
	 */
	private final String MAPPERPATH = "com.yc.mapper.personMapper.";
	/**
	 * 创建sqlsession对象
	 */
	@Autowired
	private SqlSession session;

	@Override
	public List<Person> selectAll() {
		return session.selectList(MAPPERPATH + "selectAll");
	}

	@Override
	public List<Person> selectPersonInfoPage(Map<String, Object> map) {
		Integer page = (Integer) map.get("page");
		Integer start = (page - 1) * (Integer) map.get("pageSize");
		map.put("page", start);
		return session.selectList(MAPPERPATH + "selectPersonInfoPage", map);
	}

	@Override
	public Integer updatePersonInfo(Person person) {
		return session.update(MAPPERPATH + "updatePersonInfo", person);
	}

	@Override
	public Integer deletePersonInfo(Integer id) {
		return session.delete(MAPPERPATH + "deletePersonInfo", id);
	}

	@Override
	public Integer addPersonInfo(Person person) {
		return session.insert(MAPPERPATH + "addPersonInfo", person);
	}

	@Override
	public Integer findCount() {
		return session.selectOne(MAPPERPATH + "findCount");
	}

	@Override
	public Person selectOne(Integer id) {
		return session.selectOne(MAPPERPATH + "selectOne", id);
	}

}
