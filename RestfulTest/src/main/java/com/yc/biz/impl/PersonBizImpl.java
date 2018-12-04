package com.yc.biz.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.beans.Person;
import com.yc.biz.PersonBiz;
import com.yc.dao.PersonDao;
import com.yc.web.dto.PageSet;

/**
 * 业务处理的实现层 PersonBiz的具体实现类
 * 
 * @author 陈杰
 * @date 2018/12/04
 */
@Service
public class PersonBizImpl implements PersonBiz {

	/**
	 * 创建 personDao的对象
	 */
	@Resource(name = "personDaoImpl")
	private PersonDao personDao;

	@Override
	public List<Person> selectAll() {
		return personDao.selectAll();
	}

	@Override
	public Integer updatePersonInfo(Person person) {
		// TODO Auto-generated method stub
		return personDao.updatePersonInfo(person);
	}

	@Override
	public Integer deletePersonInfo(Integer id) {
		return personDao.deletePersonInfo(id);
	}

	@Override
	public Integer addPersonInfo(Person person) {
		return personDao.addPersonInfo(person);
	}

	@Override
	public PageSet<Person> selectPersonInfoPage(Map<String, Object> map) {
		PageSet<Person> pageSet = new PageSet<Person>();
		pageSet.setPages((Integer) map.get("page"));
		List<Person> list = personDao.selectPersonInfoPage(map);
		Integer total = personDao.findCount();
		Integer pagesize = (Integer) map.get("pageSize");
		Integer pageNums = total % pagesize == 0 ? total / pagesize : total / pagesize + 1;

		pageSet.setTotal(total);
		pageSet.setList(list);
		pageSet.setPageNum(pageNums);
		pageSet.setPagesize(pagesize);
		return pageSet;
	}

	@Override
	public Person selectOne(Integer id) {
		return personDao.selectOne(id);
	}

}
