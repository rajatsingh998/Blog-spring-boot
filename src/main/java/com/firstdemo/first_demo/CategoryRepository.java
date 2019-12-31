package com.firstdemo.first_demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findCategoryByNameContains(String cateforyname);
    Category findByName(String name);
}