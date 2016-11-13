package com.ivanslushko.training.daodb;

import java.util.List;

import com.ivanslushko.training.datamodel.AbstractModel;

public interface AbstractDao<T extends AbstractModel> {

	T get(Long id);

	Long insert(T entity);

	Long update(T entity);

	void save(T entity);

	T delete(Long id);

	List<T> getAll();

}
