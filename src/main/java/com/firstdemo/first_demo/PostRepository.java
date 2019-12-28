package com.firstdemo.first_demo;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAllByTitle()
    List<Post> findAllByOrderByCreatedAtAsc();
    List<Post> findAllByOrderByUpdatedAtAsc();
}
