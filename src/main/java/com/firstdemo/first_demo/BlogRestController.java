package com.firstdemo.first_demo;

import com.firstdemo.first_demo.Category;
import com.firstdemo.first_demo.CategoryService;
import com.firstdemo.first_demo.Post;
import com.firstdemo.first_demo.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
//
@RestController
@RequestMapping("/")
public class BlogRestController {
    @Autowired
    private PostService blogService;

    @Autowired
    private CategoryService categoryService;



    @GetMapping(value = "/")
    @ResponseBody
    public ResponseEntity<List<Post>> home(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "title") String sortAttribute ) {
        PageRequest pageable =  PageRequest.of(page, 3, Sort.by(sortAttribute));
        Page<Post> list = blogService.findAll(pageable);
        List<Post> allBlogs = list.getContent();
        return new ResponseEntity<>(allBlogs, HttpStatus.OK);
    }



//    @RequestMapping("/search")
//    public ModelAndView search(@RequestParam String keyword) {
//        List<Post> result = blogService.search(keyword);
//        ModelAndView mav = new ModelAndView("search.jsp");
//        mav.addObject("totalPost",blogService.listAll().size());
//        mav.addObject("result", result);
//
//        return mav;
//    }
//

    @GetMapping(value = "/sort-by-create")
    @ResponseBody
    public ResponseEntity<List<Post>> sortByCreate(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "createdAt") String sortAttribute){
        PageRequest pageable =  PageRequest.of(page, 3, Sort.by(sortAttribute));
        Page<Post> list = blogService.findAll(pageable);
        List<Post> allBlogs = list.getContent();
        return new ResponseEntity<>(allBlogs, HttpStatus.OK);
    }
//
    @GetMapping(value = "/sort-by-update")
    @ResponseBody
    public ResponseEntity<List<Post>> sortByUpdate(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "updatedAt") String sortAttribute){
        PageRequest pageable =  PageRequest.of(page, 3, Sort.by(sortAttribute));
        Page<Post> list = blogService.findAll(pageable);
        List<Post> allBlogs = list.getContent();

        return new ResponseEntity<>(allBlogs, HttpStatus.OK);
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
    public  ResponseEntity<List<Post>> newBlogForm(@RequestParam String title,@RequestParam String content,@RequestParam String category ) {

        Category category1= new Category(category);
        Post post= new Post(title,content);
        blogService.saveMyBlog(post,category1);
        List<Post> allBlogs=blogService.listAll();
        return new ResponseEntity<>(allBlogs, HttpStatus.OK);
    }
        @PutMapping(value = "/edit")
        public  ResponseEntity<List<Post>>  editCustomerForm(@RequestParam int id,@RequestParam String title,@RequestParam String content,@RequestParam String category) {
        Post post = blogService.get(id);
        post.setContent(content);
        post.setTitle(title);
        Category category1= new Category(category);
        blogService.saveMyBlog(post,category1);
        List<Post> allBlogs=blogService.listAll();
        return new ResponseEntity<>(allBlogs, HttpStatus.OK);


    }
//
//
//    @PostMapping("/new")
//    public String postSave(@ModelAttribute("blog") Post post,
//                           @ModelAttribute("category") Category category){
//        blogService.saveMyBlog(post,category);
//
//        return "redirect:/";
//    }
//    @PostMapping("/edit-save")
//    public String posttSave(@ModelAttribute("blog") Post post,
//                            @ModelAttribute("category") Category category){
//        blogService.saveMyBlog(post,category);
//
//        return "redirect:/";
//    }
//
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public String saveCustomer(@ModelAttribute("theBlog") Post blog) {
//
//        blogService.save(blog);
//        return "redirect:/";
//    }
//    //

////    @RequestMapping(value = "/filter")
////    public ModelAndView filter(@RequestParam(value = "checkboxName", required = false) String[] checkboxValue){
////        List<Post> listPost=null;
////        ModelAndView modelAndView=new ModelAndView("filter");
////        for (String itr : name) {
////            Category category = categoryService.getByName(itr);
////            listPost=category.getPosts();
////        }
////        modelAndView.addObject("listPost",listPost);
////        return modelAndView;
////    }
//
//    @RequestMapping("/filter")
//    public ModelAndView searchCat(@RequestParam String keyword) {
//        System.out.println(keyword);
//        Category category= categoryService.findCategoryByName(keyword);
//        List<Post> result = blogService.find(category);
//        ModelAndView mav = new ModelAndView("filtered.jsp");
//        mav.addObject("result", result);
//        return mav;
//    }
//
//    @RequestMapping(value ="/delete-confirm")
//    public  ModelAndView deleteConfirm(@RequestParam int id){
//        ModelAndView mav= new ModelAndView("confirm-delete.jsp");
//        Post theBlog= blogService.get(id);
//        mav.addObject("theBlog", theBlog);
//        return mav;
//    }
//

}
