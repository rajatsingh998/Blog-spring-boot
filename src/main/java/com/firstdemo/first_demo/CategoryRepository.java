package com.firstdemo.first_demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
public  Category findCategoryByNameContains(String cateforyname);

}
