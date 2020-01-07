//package com.firstdemo.first_demo.Controller;
//
//import com.firstdemo.first_demo.Service.CategoryService;
//import com.firstdemo.first_demo.Model.Category;
//import com.firstdemo.first_demo.Model.Post;
//import com.firstdemo.first_demo.Service.PostService;
//import com.firstdemo.first_demo.Service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//
//public class homeController {
//    @Autowired
//    private CategoryService categoryService;
//    @Autowired
//    private PostService blogService;
//    @Autowired
//    UserService userService;
//    @GetMapping("/post")
//public ModelAndView sortHomePageByTitle(@RequestParam(defaultValue = "title",required = false, name = "sortBy") String sort,
//@RequestParam(defaultValue = "0" ,required = false,name = "page") int page ,
//@RequestParam(defaultValue = "" ,required = false, name = "filterBy") String filter,
//@RequestParam(defaultValue = "", required = false ,name = "key")String key,
//@RequestParam(defaultValue = "3",required = false,name = "pageSize")int pageSize ) {
//        ModelAndView modelAndView = new ModelAndView("list-blog.jsp");
//        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(sort));
//        System.out.println(filter);
//        if (!key.equals("")) {
////        Pageable pageable= PageRequest.of(page,pageSize,Sort.by(title));
//            List<Post> postList = blogService.search(key);//    modelAndView.addObject("allPost",allPost);
//            List<Post> postList2 = new ArrayList<>();
//            if (!filter.equals("")) {
//                Category category = categoryService.findCategoryByName(filter);
//                System.out.println(category.getName());
////            Pageable pageable1= PageRequest.of(page,4,Sort.by(title));
//                List<Post> postList1 = blogService.find(category);
//                for (Post post : postList) {
//
//                    if (postList1.contains(post)) {
//                        postList2.add(post);
//                    }
//                }
//                ModelAndView modelAndView1 = new ModelAndView("search.jsp");
//                modelAndView1.addObject("allPost", postList2);
//                return modelAndView1;
//            }
//
//            ModelAndView modelAndView1 = new ModelAndView("search.jsp");
//            modelAndView1.addObject("allPost", postList);
//            return modelAndView1;
//        }
//        else
//            if (!filter.equals("")) {
//
//            Category category = categoryService.findCategoryByName(filter);
////            Pageable pageable = PageRequest.of(page, pageSize, Sort.by(title));
//            System.out.println(category.getName());
//
//            List<Post> postList = blogService.find(category);
////        List<Post> list=blogService.filterPost(category,Pageable.unpaged());
//            ModelAndView mv= new ModelAndView();
//            mv.addObject("allPost", postList);
//            mv.setViewName("filtered.jsp");
//
//            return mv;
//        }
////        }
////        Pageable paging;
////        paging = PageRequest.of(page, pageSize,Sort.by(title));
////        if(title.equals("updatedAt")) {
////        paging = PageRequest.of(page, pageSize, Sort.by(title).descending());
////        }
////        List<Post> pagenationPost= blogService.getMyPost(paging);
////        List<Post>  allPost= blogService.getMyPost(Pageable.unpaged());
////        int total=allPost.size()/4;
////        modelAndView.addObject("CurPage",page);
////        modelAndView.addObject("totalPage",total);
////        modelAndView.addObject("allPost",pagenationPost);
////        return  modelAndView;
////        }
//        else {
//
//            List<Post> list = new ArrayList<>();
//            list = blogService.findAll((PageRequest) pageable);
//            modelAndView.addObject("totalPost", blogService.listAll().size());
//            modelAndView.addObject("listPost", list);
//            return modelAndView;
//        }
//    }
//        }