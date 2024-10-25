package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Product_Repository  extends JpaRepository<CategoryRepository, Long>  {

}
