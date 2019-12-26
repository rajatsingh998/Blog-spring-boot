package com.firstdemo.first_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostService {
    @Autowired
    PostRepository repo;



    public void save(Post theBlog) {
        repo.save(theBlog);
    }

    public List<Post> listAll() {
        return (List<Post>) repo.findAll();
    }

    public Post get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
