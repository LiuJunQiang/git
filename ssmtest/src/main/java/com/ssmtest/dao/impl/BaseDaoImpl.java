package com.ssmtest.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssmtest.dao.BaseDao;

public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	private String ns;
	
	@Override
	public void insert(T entity) {
		this.getSqlSession().insert(this.getNs()+".insert", entity);
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		this.getSqlSession().delete(this.getNs()+".delete", entity);
	}

	@Override
	public void updata(T entity) {
		this.getSqlSession().update(this.getNs()+".update", entity);
	}

	@Override
	public T selectOne(T entity) {
		return this.getSqlSession().selectOne(this.getNs()+".selectOne", entity);
	}

	@Override
	public List<T> selectList(Map map) {
		return this.getSqlSession().selectList(this.getNs()+".selectList", map);
	}

	public String getNs() {
		return ns;
	}

	public void setNs(String ns) {
		this.ns = ns;
	}

}
