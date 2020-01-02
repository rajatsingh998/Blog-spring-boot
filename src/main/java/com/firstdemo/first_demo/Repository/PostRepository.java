package com.firstdemo.first_demo.Repository;

import com.firstdemo.first_demo.Model.Category;
import com.firstdemo.first_demo.Model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Page<Post> findAll(Pageable pageable);
    //    @Query("select  s from Post s where title or content like  %?1%")
//    List<Post> findAllByTitleOrContent(String name);
    @Query(value = "SELECT c FROM Post c WHERE c.title LIKE '%' || :keyword || '%'"
            + " OR c.content LIKE '%' || :keyword || '%'")
    List<Post> search(@Param("keyword") String keyword);
    List<Post> findAllByOrderByCreatedAtAsc();
    List<Post> findAllByOrderByUpdatedAtAsc();
    List<Post> findByCategories(Category category);
}
