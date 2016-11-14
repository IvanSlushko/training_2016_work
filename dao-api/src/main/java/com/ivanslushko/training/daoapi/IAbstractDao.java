package com.ivanslushko.training.daoapi;

import java.util.List;

import com.ivanslushko.training.datamodel.AbstractModel;

public interface IAbstractDao<T extends AbstractModel> {

	T get(Long id);

	Long insert(T entity);

	Long update(T entity);

	void save(T entity);

	void delete(Long id);

	List<T> getAll();

}
