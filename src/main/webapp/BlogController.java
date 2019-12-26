package SpringJpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @RequestMapping(value = "/")
    public ModelAndView home() {
        List<BlogMVC> allBlogs = blogService.listAll();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("list-blog");
        mv.addObject("allBlogs", allBlogs);

        return mv;
    }

    @RequestMapping(value ="/new")
    public String newBlogForm(Map<String, Object> model) {
        BlogMVC theBlog = new BlogMVC();
        model.put("theBlog", theBlog);
        return "newBlog";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("theBlog") BlogMVC blog) {
       blogService.save(blog);
        return "redirect:/";
    }
//
    @RequestMapping(value = "/edit")
    public ModelAndView editCustomerForm(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("edit-blog");
        BlogMVC theBlog = blogService.get(id);
        mav.addObject("theBlog", theBlog);

        return mav;
    }
    @RequestMapping(value ="/delete-confirm")
    public  ModelAndView deleteConfirm(@RequestParam int id){
        ModelAndView mav= new ModelAndView("confirm-delete");
        BlogMVC theBlog= blogService.get(id);
        mav.addObject("theBlog", theBlog);
        return mav;
    }

    @RequestMapping(value = "/delete")
    public String deleteBlog(@RequestParam int id) {
        blogService.delete(id);
        return "redirect:/";
    }
}
