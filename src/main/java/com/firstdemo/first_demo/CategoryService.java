package com.firstdemo.first_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    CategoryRepository repo;

    public List<Category> listAll() {
        return (List<Category>) repo.findAll();
    }
}
