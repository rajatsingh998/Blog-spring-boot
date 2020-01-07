package com.firstdemo.first_demo.Controller;//package com.firstdemo.first_demo;


import com.firstdemo.first_demo.Model.Category;
import com.firstdemo.first_demo.Model.Post;
import com.firstdemo.first_demo.Service.CategoryService;

import com.firstdemo.first_demo.Service.PostService;
//import com.firstdemo.first_demo.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


import java.util.List;
//
@RestController

public class BlogRestController {

    @Autowired
    private PostService blogService;

    @Autowired
    private CategoryService categoryService;
//
//    @Autowired
//    private UserService userDetailsService;


    @GetMapping(value = "/")
    @ResponseBody
    public ResponseEntity<List<Post>> home(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "title") String sortAttribute ) {
        PageRequest pageable =  PageRequest.of(page, 3, Sort.by(sortAttribute));
        List<Post> list = blogService.findAll(pageable);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }





    @GetMapping(value = "/sort-by-create")
    @ResponseBody
    public ResponseEntity<List<Post>> sortByCreate(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "createdAt") String sortAttribute){
        PageRequest pageable =  PageRequest.of(page, 3, Sort.by(sortAttribute));
        List<Post> list = blogService.findAll(pageable);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
//
    @GetMapping(value = "/sort-by-update")
    @ResponseBody
    public ResponseEntity<List<Post>> sortByUpdate(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "updatedAt") String sortAttribute){
        PageRequest pageable =  PageRequest.of(page, 3, Sort.by(sortAttribute));
        List<Post> list = blogService.findAll(pageable);


        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public  ResponseEntity<List<Post>> deleteBlog(@RequestParam int id) {
        blogService.delete(id);
        List<Post> allBlogs=blogService.listAll();
        return new ResponseEntity<>(allBlogs, HttpStatus.OK);
    }
//
//
    @PostMapping(value ="/new")
    public  ResponseEntity<List<Post>> newBlogForm(@RequestBody Post post,@RequestBody Category category ) {



        blogService.saveMyBlogok(post,category);
        List<Post> allBlogs=blogService.listAll();
        return new ResponseEntity<>(allBlogs, HttpStatus.OK);
    }
        @PutMapping(value = "/edit/{id}")
        public  ResponseEntity<List<Post>>  editCustomerForm(@PathVariable("id") int id,@RequestBody Post post,@RequestBody Category category) {
        Post post5 = blogService.get(id);
        post5.setContent(post.getContent());
        post5.setTitle(post.getTitle());

        blogService.saveMyBlogok(post5,category);
        List<Post> allBlogs=blogService.listAll();
        return new ResponseEntity<>(allBlogs, HttpStatus.OK);


    }


}
