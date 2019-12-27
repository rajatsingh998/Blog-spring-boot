package com.firstdemo.first_demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value ="/new")
    public ModelAndView newBlogForm(Map<String, Object> model) {

            List<Category> allCategories= categoryService.listAll();
            ModelAndView mv= new ModelAndView();
            mv.setViewName("newBlog.jsp");
            mv.addObject("allCategories",allCategories);



        Post theBlog = new Post();
        model.put("theBlog", theBlog);

        return mv;
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("theBlog") Post blog) {
       blogService.save(blog);
        return "redirect:/";
    }
//
    @RequestMapping(value = "/edit")
    public ModelAndView editCustomerForm(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("edit-blog.jsp");
        Post theBlog = blogService.get(id);
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
