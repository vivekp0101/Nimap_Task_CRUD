package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.model.Product;
@RestController
@RequestMapping("/API/product")
public class Product_Controller {
	@Autowired
	private product_service productservice;
	
	@GetMapping
	public List<Product> getAllProducts(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size)
	{
      return productservice.getAllProducts(page, size);
    }
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
        return productservice.createProduct(product);
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = product_Service.getProductById(id);
        if (product != null)
        {
            return ResponseEntity.ok(product);
        } 
        else 
        {
            return ResponseEntity.notFound().build();
        }
	}
	 @PutMapping("/{id}")
	    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
	        Product existingProduct = productservics.getProductById(id);
	        if (existingProduct != null) {
	            product.setId(id);
	            return ResponseEntity.ok(productService.updateProduct(product));
	        } 
	        else 
	        {
	            return ResponseEntity.notFound().build();
	        }
	 }
}
	
	
	


