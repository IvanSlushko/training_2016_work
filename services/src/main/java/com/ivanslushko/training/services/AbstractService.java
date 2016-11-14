package com.ivanslushko.training.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface AbstractService<T> {

	@Transactional
	void saveAll(List<T> entiti);

	Long save(T entiti);

	Long update(T entiti);

	T get(Long id);

//	T delete(Long id);
	
	void delete(Long id);

	List<T> getAll();

}