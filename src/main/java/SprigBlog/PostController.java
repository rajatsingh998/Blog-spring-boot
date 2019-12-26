package SprigBlog;


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
    @RequestMapping(value = "/home")
    public ModelAndView home() {
        List<Post> allBlogs = blogService.listAll();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("list-blog.jsp");
        mv.addObject("allBlogs", allBlogs);

        return mv;
    }

    @RequestMapping(value ="/new")
    public String newBlogForm(Map<String, Object> model) {
        Post theBlog = new Post();
        model.put("theBlog", theBlog);
        return "newBlog";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("theBlog") Post blog) {
       blogService.save(blog);
        return "redirect:/";
    }
//
    @RequestMapping(value = "/edit")
    public ModelAndView editCustomerForm(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("edit-blog");
        Post theBlog = blogService.get(id);
        mav.addObject("theBlog", theBlog);

        return mav;
    }
    @RequestMapping(value ="/delete-confirm")
    public  ModelAndView deleteConfirm(@RequestParam int id){
        ModelAndView mav= new ModelAndView("confirm-delete");
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
