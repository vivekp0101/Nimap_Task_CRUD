package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CategoryRepository;

@Service
public class Category_Services {
	 @Autowired
	    private CategoryRepository categoryRepository;

	    public List<Category_Servises> getAllCategories() {
	        return categoryRepository.findAll();
	    }

	    public Category_Servises getCategoryById(Long id) {
	        return categoryRepository.findById(id).orElse(null);
	    }

	    public Category_Servises createCategory(Category category) {
	        return categoryRepository.save(category);
	    }

	    public Category_Servises updateCategory(Category category) {
	        return categoryRepository.save(category);
	    }

	    public void deleteCategory(Long id) {
	        categoryRepository.deleteById(id);
	    }
	    public List<Category> getAllCategories(int page, int size)
	    {
	        Pageable pageable = PageRequest.of(page, size);
	        Page<Category_Servises> categoryPage = categoryRepository.findAll(pageable);
	        return categoryPage.getContent();
	    }
	}


