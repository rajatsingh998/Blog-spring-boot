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



//@GetMapping("/post")
//public ModelAndView sortHomePageByTitle(@RequestParam(defaultValue = "title",required = false, name = "sortBy") String title,
//@RequestParam(defaultValue = "0" ,required = false,name = "page") int page ,
//@RequestParam(defaultValue = "" ,required = false, name = "filterBy") String filter,
//@RequestParam(defaultValue = "", required = false ,name = "key")String key,
//@RequestParam(defaultValue = "4",required = false,name = "pageSize")int pageSize ) {
//        ModelAndView modelAndView = new ModelAndView("index");
//        if (!key.equals(""))
//        {
//        Pageable pageable= PageRequest.of(page,pageSize,Sort.by(title));
//        List<Post> postList=blogService.searchMyBlog(key,pageable);//    modelAndView.addObject("allPost",allPost);
//        List<Post> postList2= new ArrayList<>();
//        if(!filter.equals(""))
//        {
//        Category category= blogService.getSingleCategory(filter);
//        System.out.println(category.getName());
////            Pageable pageable1= PageRequest.of(page,4,Sort.by(title));
//        List<Post> postList1= blogService.filterPost(category,Pageable.unpaged());
//        System.out.println(postList1.size());
//        for(Post post:postList)
//        {
//        System.out.println(post.getListCategory().get(0).getName());
//        if(postList1.contains(post))
//        {
//        postList2.add(post);
//        }
//        }
//        ModelAndView modelAndView1 = new ModelAndView("searchedresult");
//        modelAndView1.addObject("allPost", postList2);
//        return modelAndView1;
//        }
//        ModelAndView modelAndView1 = new ModelAndView("searchedresult");
//        modelAndView1.addObject("allPost", postList);
//        return modelAndView1;
//        }
//        if(!filter.equals(""))
//        {
//        System.out.println("sadasd");
//        Category category= blogService.getSingleCategory(filter);
//        Pageable pageable= PageRequest.of(page,pageSize,Sort.by(title));
//        if(title.equals("updatedAt"))
//        pageable= PageRequest.of(page,pageSize,Sort.by(title).descending());
//        List<Post> postList= blogService.filterPost(category,pageable);
//        List<Post> list=blogService.filterPost(category,Pageable.unpaged());
//        modelAndView.addObject("allPost",postList);
//        int total=list.size()/4;
//        modelAndView.addObject("CurPage",page);
//        modelAndView.addObject("totalPage",total);
//        return  modelAndView;
//        }
//        Pageable paging;
//        paging = PageRequest.of(page, pageSize,Sort.by(title));
//        if(title.equals("updatedAt")) {
//        paging = PageRequest.of(page, pageSize, Sort.by(title).descending());
//        }
//        List<Post> pagenationPost= blogService.getMyPost(paging);
//        List<Post>  allPost= blogService.getMyPost(Pageable.unpaged());
//        int total=allPost.size()/4;
//        modelAndView.addObject("CurPage",page);
//        modelAndView.addObject("totalPage",total);
//        modelAndView.addObject("allPost",pagenationPost);
//        return  modelAndView;
//        }