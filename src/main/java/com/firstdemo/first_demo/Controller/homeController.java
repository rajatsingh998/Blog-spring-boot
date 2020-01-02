//package com.firstdemo.first_demo.Controller;
//
//import com.firstdemo.first_demo.Service.CategoryService;
//import com.firstdemo.first_demo.Model.Category;
//import com.firstdemo.first_demo.Model.Post;
//import com.firstdemo.first_demo.Service.PostService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//@Controller
//
//public class homeController {
//        @Autowired
//    private PostService blogService;
//
//    @Autowired
//    private CategoryService categoryService;
//    @RequestMapping("/post")
//    public ModelAndView home(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "createdAt") String sortAttribute, @RequestParam(defaultValue="") String searchText, @RequestParam( required=false) Category category){
//        PageRequest pageable =  PageRequest.of(page, 3, Sort.by(sortAttribute));
//        Page<Post> list = blogService.findAll(pageable);
//        List<Post> allBlogs = list.getContent();
//        List<Post> result = blogService.search(searchText);
//        allBlogs.retainAll(result);
//        List<Post> resultQ = blogService.find(category);
////        allBlogs.retainAll(resultQ);
//        ModelAndView mav = new ModelAndView("list-blog.jsp");
//        System.out.println(blogService.listAll().size());
//        mav.addObject("totalPost",blogService.listAll().size());
//        mav.addObject("listPost", allBlogs);
//
//
//        return mav;
//    }
//
//}
