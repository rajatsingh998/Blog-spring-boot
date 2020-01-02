package com.firstdemo.first_demo.Controller;


import com.firstdemo.first_demo.Model.Category;
import com.firstdemo.first_demo.Model.User;
import com.firstdemo.first_demo.Service.CategoryService;
import com.firstdemo.first_demo.Model.Post;
import com.firstdemo.first_demo.Service.PostService;
import com.firstdemo.first_demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@Controller
public class PostController {
    @Autowired
    private PostService blogService;
    @Autowired
    UserService userService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/")
    public ModelAndView home(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "title") String sortAttribute ) {
        PageRequest pageable =  PageRequest.of(page, 3, Sort.by(sortAttribute));
        List<Post> list = blogService.findAll(pageable);

        ModelAndView mav = new ModelAndView("list-blog.jsp");
        System.out.println(blogService.listAll().size());
        mav.addObject("totalPost",blogService.listAll().size());
        mav.addObject("listPost", list);



        return mav;
    }



    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Post> result = blogService.search(keyword);
        ModelAndView mav = new ModelAndView("search.jsp");
        mav.addObject("totalPost",blogService.listAll().size());
        mav.addObject("result", result);

        return mav;
    }

    @RequestMapping(value = "/sortbyCreate")
    public ModelAndView sortByCreate(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "createdAt") String sortAttribute){
        PageRequest pageable =  PageRequest.of(page, 3, Sort.by(sortAttribute));
        List<Post> list = blogService.findAll(pageable);

        ModelAndView mav = new ModelAndView("list-blog.jsp");
        System.out.println(blogService.listAll().size());
        mav.addObject("totalPost",blogService.listAll().size());
        mav.addObject("listPost", list);


        return mav;
    }

    @RequestMapping(value = "/sortbyUpdate")
    public ModelAndView sortByUpdate(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "updatedAt") String sortAttribute){
        PageRequest pageable =  PageRequest.of(page, 3, Sort.by(sortAttribute));
        List<Post> list = blogService.findAll(pageable);

        ModelAndView mav = new ModelAndView("list-blog.jsp");
        System.out.println(blogService.listAll().size());
        mav.addObject("totalPost",blogService.listAll().size());
        mav.addObject("listPost", list);


        return mav;
    }


    @GetMapping(value ="/new")
    public ModelAndView newBlogForm() {
        Post post=new Post();
        Category category= new Category();
//        List<Category> allCategories= categoryService.listAll();
        ModelAndView mv= new ModelAndView("newBlog.jsp");
        mv.addObject("blog",post);
        mv.addObject("category",category );
//        mv.addObject("allCategories",allCategories);

//
        return  mv;
    }

    @GetMapping(value ="/register")
    public ModelAndView newregis(){
        User user= new User();
        ModelAndView mv= new ModelAndView("registration.jsp");
        mv.addObject("user",user);
        return  mv;
    }
    @PostMapping(value ="/register")
    public ModelAndView newregits(@ModelAttribute("user") User user){
       user.setRole("user");
       userService.save(user);
        ModelAndView mv= new ModelAndView("registered.jsp");

        return  mv;
    }

    @PostMapping("/new")
    public String postSave(@ModelAttribute("blog") Post post,
                           @ModelAttribute("category") Category category,@RequestParam("userName") String name ){
        blogService.saveMyBlog(post,category,name);
        System.out.println(name);
        return "redirect:/";
    }
    @PostMapping("/edit-save")
    public String posttSave(@ModelAttribute("blog") Post post,
                            @ModelAttribute("category") Category category,@RequestParam("userName") String name){
        blogService.saveMyBlog(post,category,name);

        return "redirect:/";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("theBlog") Post blog) {

        blogService.save(blog);
        return "redirect:/";
    }
    //
    @RequestMapping(value = "/edit")
    public ModelAndView editCustomerForm(@RequestParam int id) {
        Category category= new Category();
        ModelAndView mav = new ModelAndView("edit-blog.jsp");
        Post theBlog = blogService.get(id);
        mav.addObject("category",category );
        mav.addObject("theBlog", theBlog);

        return mav;
    }
//    @RequestMapping(value = "/filter")
//    public ModelAndView filter(@RequestParam(value = "checkboxName", required = false) String[] checkboxValue){
//        List<Post> listPost=null;
//        ModelAndView modelAndView=new ModelAndView("filter");
//        for (String itr : name) {
//            Category category = categoryService.getByName(itr);
//            listPost=category.getPosts();
//        }
//        modelAndView.addObject("listPost",listPost);
//        return modelAndView;
//    }

    @RequestMapping("/filter")
    public ModelAndView searchCat(@RequestParam String keyword) {
        System.out.println(keyword);
        Category category= categoryService.findCategoryByName(keyword);
        List<Post> result = blogService.find(category);
        ModelAndView mav = new ModelAndView("filtered.jsp");
        mav.addObject("result", result);
        return mav;
    }

    @RequestMapping(value ="/delete-confirm")
    public  ModelAndView deleteConfirm(@RequestParam int id){
        ModelAndView mav= new ModelAndView("confirm-delete.jsp");
        Post theBlog= blogService.get(id);
        mav.addObject("theBlog", theBlog);
        return mav;
    }

    @RequestMapping(value = "/delete")
    public String deleteBlog(@RequestParam int id) {
        blogService.delete(id);
        return "redirect:/";
    }
}
