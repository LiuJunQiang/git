package com.privilege.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.privilege.dao.BaseDao;

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
		
		try {
			deleteRelativity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	@Override
	public List<T> selectTree(T entity) {
		 List<T> list = this.getSqlSession().selectList(this.getNs()+".selectTree", entity);
		return list;
	}
	class RSHandler implements ResultHandler{
		private Integer count;
		@Override
		public void handleResult(ResultContext context) {
			setCount((Integer) context.getResultObject());
		}
		public Integer getCount() {
			return count;
		}
		public void setCount(Integer count) {
			this.count = count;
		}
		
	}
	@Override
	public Integer selectCount(Integer id) {
		 RSHandler rshandler = new RSHandler();
		 this.getSqlSession().select(this.getNs()+".selectCount",id, rshandler);
		 
		return rshandler.getCount();
	}

	@Override
	public void deleteRelativity(T entity) {
		this.getSqlSession().delete(this.getNs()+".deleteRelaytivity", entity);
		
	}
}
