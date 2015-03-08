package com.ssmtest.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
	/**
	 * 
	 * @param entity
	 */
	public void insert(T entity);
	public void delete(T entity);
	public void updata(T entity);
	public T selectOne(T entity);
	public List<T> selectList(Map map);
}
