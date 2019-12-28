package com.firstdemo.first_demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class PostController {
    @Autowired
    private PostService blogService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/")
    public ModelAndView home() {
        List<Post> allBlogs = blogService.listAll();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("list-blog.jsp");
        mv.addObject("allBlogs", allBlogs);

        return mv;
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
//
//            List<Category> allCategories= categoryService.listAll();
//            ModelAndView mv= new ModelAndView();
//            mv.setViewName("newBlog.jsp");
//            mv.addObject("allCategories",allCategories);
//
//
//
//        Post theBlog = new Post();
//        model.put("theBlog", theBlog);
//
//        return mv;

    @PostMapping("/new")
    public String postSave(@ModelAttribute("blog") Post post,
    @ModelAttribute("category") Category category){
        blogService.saveMyBlog(post,category);

        return "redirect:/";
    }
    @PostMapping("/edit-save")
    public String posttSave(@ModelAttribute("blog") Post post,
                           @ModelAttribute("category") Category category){
        blogService.saveMyBlog(post,category);

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
