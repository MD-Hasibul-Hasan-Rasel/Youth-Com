package com.youth.main.service;

import java.util.List;

import com.youth.main.model.Category;

public interface CategoryService {
	List<Category> findAll();
	Category save(Category category);
	Category getById(Long id);
	Category update(Category category);
	void deleteById(Long id);
	void enabledById(Long id);

}
