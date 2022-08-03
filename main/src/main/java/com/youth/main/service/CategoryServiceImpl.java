package com.youth.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youth.main.model.Category;
import com.youth.main.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository repository;
	
	
	@Override
	public List<Category> findAll() {
		return repository.findAll();
	}

	@Override
	public Category save(Category category) {
		Category categorySave = new Category(category.getName());
		return repository.save(categorySave);
	}

	@Override
	public Category getById(Long id) {
		return repository.getById(id);
	}

	@Override
	public Category update(Category category) {
		Category categoryUpdate = new Category();
		categoryUpdate.setName(category.getName());
		categoryUpdate.setIs_activated(category.isIs_activated());
		categoryUpdate.setIs_deleted(category.isIs_deleted());
		
		return repository.save(categoryUpdate);
	}

	@Override
	public void deleteById(Long id) {
		Category category = repository.getById(id);
		category.setIs_activated(false);
		category.setIs_deleted(true);
		repository.save(category);
	}

	@Override
	public void enabledById(Long id) {
		Category category = repository.getById(id);
		category.setIs_activated(true);
		category.setIs_deleted(false);
		repository.save(category);
	}

}























