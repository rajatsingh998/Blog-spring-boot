//package com.firstdemo.first_demo.Controller;//package com.firstdemo.first_demo;
//
//
//import com.firstdemo.first_demo.Model.Category;
//import com.firstdemo.first_demo.Model.Post;
//import com.firstdemo.first_demo.Service.CategoryService;
//
//import com.firstdemo.first_demo.Service.PostService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//
//import java.util.List;
////
//@RestController
//@RequestMapping("/")
//public class BlogRestController {
//    @Autowired
//    private PostService blogService;
//
//    @Autowired
//    private CategoryService categoryService;
//
//
//
//    @GetMapping(value = "/")
//    @ResponseBody
//    public ResponseEntity<List<Post>> home(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "title") String sortAttribute ) {
//        PageRequest pageable =  PageRequest.of(page, 3, Sort.by(sortAttribute));
//        Page<Post> list = blogService.findAll(pageable);
//        List<Post> allBlogs = list.getContent();
//        return new ResponseEntity<>(allBlogs, HttpStatus.OK);
//    }
//
//
//
//
//
//    @GetMapping(value = "/sort-by-create")
//    @ResponseBody
//    public ResponseEntity<List<Post>> sortByCreate(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "createdAt") String sortAttribute){
//        PageRequest pageable =  PageRequest.of(page, 3, Sort.by(sortAttribute));
//        Page<Post> list = blogService.findAll(pageable);
//        List<Post> allBlogs = list.getContent();
//        return new ResponseEntity<>(allBlogs, HttpStatus.OK);
//    }
////
//    @GetMapping(value = "/sort-by-update")
//    @ResponseBody
//    public ResponseEntity<List<Post>> sortByUpdate(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "updatedAt") String sortAttribute){
//        PageRequest pageable =  PageRequest.of(page, 3, Sort.by(sortAttribute));
//        Page<Post> list = blogService.findAll(pageable);
//        List<Post> allBlogs = list.getContent();
//
//        return new ResponseEntity<>(allBlogs, HttpStatus.OK);
//    }
//
//    @DeleteMapping(value = "/delete")
//    public  ResponseEntity<List<Post>> deleteBlog(@RequestParam int id) {
//        blogService.delete(id);
//        List<Post> allBlogs=blogService.listAll();
//        return new ResponseEntity<>(allBlogs, HttpStatus.OK);
//    }
////
////
//    @PostMapping(value ="/new")
//    public  ResponseEntity<List<Post>> newBlogForm(@RequestParam String title,@RequestParam String content,@RequestParam String category ) {
//
//        Category category1= new Category(category);
//        Post post= new Post(title,content);
//        blogService.saveMyBlog(post,category1);
//        List<Post> allBlogs=blogService.listAll();
//        return new ResponseEntity<>(allBlogs, HttpStatus.OK);
//    }
//        @PutMapping(value = "/edit")
//        public  ResponseEntity<List<Post>>  editCustomerForm(@RequestParam int id,@RequestParam String title,@RequestParam String content,@RequestParam String category) {
//        Post post = blogService.get(id);
//        post.setContent(content);
//        post.setTitle(title);
//        Category category1= new Category(category);
//        blogService.saveMyBlog(post,category1);
//        List<Post> allBlogs=blogService.listAll();
//        return new ResponseEntity<>(allBlogs, HttpStatus.OK);
//
//
//    }
//
//
//}
