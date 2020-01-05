package com.firstdemo.first_demo.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.firstdemo.first_demo.Model.Category;
import com.firstdemo.first_demo.Model.CustomException;
import com.firstdemo.first_demo.Model.User;
import com.firstdemo.first_demo.Repository.CategoryRepository;
import com.firstdemo.first_demo.Repository.UserRepository;
import com.firstdemo.first_demo.Service.CategoryService;
import com.firstdemo.first_demo.Model.Post;
import com.firstdemo.first_demo.Service.PostService;
import com.firstdemo.first_demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

@SpringBootApplication
class Application
{
    private static final Logger LOGGER=LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        LOGGER.info("Simple log statement with inputs {}, {} and {}", 1,2,3);
    }
}

@Controller
class Controllerr implements ErrorController {

    // ...

    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();

        if(response.getStatus() == HttpStatus.NOT_FOUND.value()) {
            modelAndView.setViewName("404.jsp");
        }
        else if(response.getStatus() == HttpStatus.FORBIDDEN.value()) {
            modelAndView.setViewName("error-code.jsp");
        }
        else if(response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            modelAndView.setViewName("5xx.jsp");
        }
        else {
            modelAndView.setViewName("error-code");
        }

        return modelAndView;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}

@RestController
@Controller
public class PostController {
    @Autowired
    private PostService blogService;
    @Autowired
    UserService userService;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    CategoryRepository repo1;

    @Autowired
    UserRepository repo2;
    Logger log=LoggerFactory.getLogger(PostController.class);



    @RequestMapping(value = "/")
    public ModelAndView home(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "title") String sortAttribute ) {
        log.debug("Enetering in all blogs list");
        PageRequest pageable =  PageRequest.of(page, 3, Sort.by(sortAttribute));
        List<Post> list=new ArrayList<>();
        ModelAndView mav = new ModelAndView();
        try {
            list = blogService.findAll(pageable);
            mav.setViewName("list-blog.jsp");
            if(list.size()==0){
                log.warn("Find zero blogs");
            }
        }
        catch (Exception e){
            log.error("error happened while retriving the blogs ",e);
            String msg= "error happened while retriving the blogs";
            mav.addObject("msg",msg);
            e.printStackTrace();
            mav.setViewName("error.jsp");
        }



        mav.addObject("totalPost",blogService.listAll().size());
        mav.addObject("listPost", list);

        log.debug("Exiting Allblogs list");

        return mav;
    }



    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Post> result = new ArrayList<>();
        ModelAndView mav = new ModelAndView();
            try {
                result = blogService.search(keyword);
                mav.setViewName("search.jsp");
                if(result.size()==0){
                    log.warn("Find zero result for "+keyword);
                }
            }
            catch (Exception e){
                log.error("error happened while Searching ",e);
                String msg= "error happened while Searching:"+keyword;
                mav.addObject("msg",msg);
                e.printStackTrace();
                mav.setViewName("error.jsp");
            }
        mav.addObject("totalPost",result.size());
        mav.addObject("allPost", result);
        log.debug("Exiting Searching");
        return mav;
    }

    @RequestMapping(value = "/sortbyCreate")
    public ModelAndView sortByCreate(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "createdAt") String sortAttribute){
        PageRequest pageable =  PageRequest.of(page, 3, Sort.by(sortAttribute));
        List<Post> list=new ArrayList<>();
        ModelAndView mav = new ModelAndView();
        try {
            list = blogService.findAll(pageable);

            mav.setViewName("list-blog.jsp");
        }
        catch (Exception e){
            log.error("error happened while Sorting the blogs ",e);
            String msg= "error happened while Sorting the blogs";
            mav.addObject("msg",msg);
            e.printStackTrace();
            mav.setViewName("error.jsp");
        }
        System.out.println(blogService.listAll().size());
        mav.addObject("totalPost",blogService.listAll().size());
        mav.addObject("listPost", list);


        return mav;
    }

    @RequestMapping(value = "/sortbyUpdate")
    public ModelAndView sortByUpdate(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "updatedAt") String sortAttribute){
        PageRequest pageable =  PageRequest.of(page, 3, Sort.by(sortAttribute));
        List<Post> list=new ArrayList<>();
        ModelAndView mav = new ModelAndView();
        try {
            list = blogService.findAll(pageable);

            mav.setViewName("list-blog.jsp");
        }
        catch (Exception e){
            log.error("error happened while Sorting the blogs ",e);
            String msg= "error happened while Sorting the blogs";
            mav.addObject("msg",msg);
            e.printStackTrace();
            mav.setViewName("error.jsp");
        }
        System.out.println(blogService.listAll().size());
        mav.addObject("totalPost",blogService.listAll().size());
        mav.addObject("listPost", list);


        return mav;
    }


    @GetMapping(value ="/new")
    public ModelAndView newBlogForm() {
        log.debug("Entering into new blog process");
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
        log.debug("Entering in registering");
        User user= new User();
        ModelAndView mv= new ModelAndView("registration.jsp");
        mv.addObject("user",user);
        return  mv;
    }
    @PostMapping(value ="/register")
    public ModelAndView newregits(@ModelAttribute("user") User user){
       user.setRole("user");
        ModelAndView mv= new ModelAndView();
       try {
           userService.save(user);
           mv.setViewName("registered.jsp");
       }
       catch (Exception e){
           log.error("error happened while Registring ",e);
           String msg= "error happened while Sorting the blogs";
           mv.addObject("msg",msg);
           e.printStackTrace();
           mv.setViewName("error.jsp");

       }

        log.debug("Exiting from registering");
        return  mv;
    }

    @PostMapping("/new")
    public ModelAndView postSave(@ModelAttribute("blog") Post post,
                           @ModelAttribute("category") Category category,@RequestParam("userName") String name ){
        ModelAndView mv= new ModelAndView();
        try {
            blogService.saveMyBlog(post, category, name);
            log.debug("Exiting new blog process");
            return new ModelAndView("redirect:/");
        }
        catch (Exception e){
            log.error("error happened while Saving the Blog ",e);
            String msg= "error happened while Saving the Blog";
            e.printStackTrace();
            mv.setViewName("error.jsp");
            mv.addObject("msg",msg);
            log.debug("Exiting new blog process");
            return mv;
        }

    }
    @PostMapping("/edit-save")
    public ModelAndView posttSave(@ModelAttribute("blog") Post post,
                            @ModelAttribute("category") Category category,@RequestParam("userName") String name){
        try {
            blogService.saveMyBlog(post, category, name);
            return new ModelAndView("redirect:/");
        }
        catch (Exception e){
            log.error("error happened while Saving the Blog during editing ",e);
            String msg= "error happened while Saving the Blog during editing";
            e.printStackTrace();
            ModelAndView mv= new ModelAndView();
            mv.addObject("msg",msg);
            mv.setViewName("error.jsp");
            log.debug("Exiting new blog process");
            return mv;
        }

    }

//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public ModelAndView saveCustomer(@ModelAttribute("theBlog") Post blog) {
//        try {
//            blogService.save(blog);
//        }
//        catch (Exception e){
//            log.error("error happened while Saving the Blog  ",e);
//            String msg= "error happened while Saving the Blog ";
//            e.printStackTrace();
//            ModelAndView mv= new ModelAndView();
//            mv.setViewName("error.jsp");
//            log.debug("Exiting new blog process");
//            return mv;
//        }
//        return new ModelAndView("redirect:/");
//    }
    //
    @RequestMapping(value = "/edit")
    public ModelAndView editCustomerForm(@RequestParam int id) {
        if(id!=(int)id){
            log.error("id is not of int type");
            String msg= "error happened while editing the Blog ";
            ModelAndView mv= new ModelAndView();
            mv.addObject("msg",msg);
            mv.setViewName("error.jsp");
            return mv;
        }
        Category category= new Category();
        ModelAndView mav = new ModelAndView("edit-blog.jsp");
        Post theBlog=new Post();
        try {
            theBlog = blogService.get(id);
        }
        catch (Exception e){
            log.error("error happened while editing the Blog  ",e);
            String msg= "error happened while editing the Blog ";
            e.printStackTrace();
            ModelAndView mv= new ModelAndView();
            mv.addObject("msg",msg);
            mv.setViewName("error.jsp");
            log.debug("Exiting new blog process");
            return mv;
        }
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
        List<Post> result= new ArrayList<>();
        try {
             result = blogService.find(category);

        }
        catch (Exception e){
            log.error("error happened while filtering the Blog  ",e);
            String msg= "error happened while filtering the Blog ";
            e.printStackTrace();
            ModelAndView mv= new ModelAndView();
            mv.setViewName("error.jsp");
            mv.addObject("msg",msg);
            log.debug("Exiting new blog process");
            return mv;
        }

        ModelAndView mav = new ModelAndView("filtered.jsp");
        mav.addObject("totalPost",result.size());
        mav.addObject("allPost", result);
        return mav;
    }

    @RequestMapping(value ="/delete-confirm")
    public  ModelAndView deleteConfirm(@RequestParam int id){
        ModelAndView mav= new ModelAndView("confirm-delete.jsp");
        Post theBlog= new Post();
        try {
             theBlog = blogService.get(id);
        }
        catch (Exception e){
            log.error("error happened while getting Blog by Id  ",e);
            String msg= "error happened while deleting ";
            e.printStackTrace();
            ModelAndView mv= new ModelAndView();
            mv.setViewName("error.jsp");
            mv.addObject("msg",msg);
            log.debug("Exiting new blog process");
            return mv;
        }
        mav.addObject("theBlog", theBlog);
        return mav;
    }

    @RequestMapping(value = "/delete")
    public ModelAndView deleteBlog(@RequestParam int id) {
        try {
            blogService.delete(id);
            return new ModelAndView("redirect:/");
        }
        catch (Exception e){
            log.error("error happened while deleting Blog by Id  ",e);
            String msg= "error happened while deleting blog ";
            e.printStackTrace();
            ModelAndView mv= new ModelAndView();
            mv.setViewName("error.jsp");
            mv.addObject("msg",msg);
            log.debug("Exiting new blog process");
            return mv;
        }
        }



    @GetMapping(value = "/view")
    public ModelAndView showById(@RequestParam int id){
        ModelAndView mv=new ModelAndView();
        Post theBlog= new Post();
        try {
             theBlog = blogService.get(id);
             mv.setViewName("showBlogById.jsp");
        }
        catch (Exception e){
            log.error("error happened while Viewing the Blog by Id  ",e);
            String msg= "error happened while Viewing the blog ";
            e.printStackTrace();

            mv.setViewName("error.jsp");
            mv.addObject("msg",msg);
            log.debug("Exiting new blog process");
            return mv;
        }
        mv.addObject("blog",theBlog);

        return mv;
    }

}
