package com.firstdemo.first_demo.Repository;

import com.firstdemo.first_demo.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findCategoryByNameContains(String cateforyname);
    Category findByName(String name);
}