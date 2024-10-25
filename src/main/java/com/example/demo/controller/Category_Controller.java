package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.CategoryRepository;
import com.nimap.model.Category;

@RestController
@RequestMapping("/API/categories")

public class Category_Controller {
	@Autowired
	
	private CategoryRepository CategoryService;
	
	public List<Category>grtAllcategories(@RequestParam(defaultValue="0")int page,@RequestParam(defaultValue="10")int size)
	{
		 return CategoryService.getAllCategories(page, size);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Category>getCategoryById(@PathVariable Long id) {
        Category category = CategoryService.getCategoryById(id);
        if (category != null) 
        {
            return ResponseEntity.ok(category);
        } 
        else
        {
            return ResponseEntity.notFound().build();
        }
	}
	
	@PostMapping
	public Category createCategory(@RequestBody Category category) {
        return CategoryService.createCategory(category);
    }
	
	@DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) 
	{
        Category existingCategory = CategoryService.getCategoryById(id);
        if (existingCategory != null)
        {
            CategoryService.deleteCategory(id);
            return ResponseEntity.noContent().build();
        }
        else 
        {
            return ResponseEntity.notFound().build();
        }
	}
}

	
	
	

	

	


