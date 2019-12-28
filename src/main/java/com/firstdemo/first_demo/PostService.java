package com.firstdemo.first_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostService {
    @Autowired
    PostRepository repo;
    @Autowired
    CategoryRepository repo1;


    public void save(Post theBlog) {
        repo.save(theBlog);
    }

    public void saveDouble (Post firstBlog, Category category){
        repo.save(firstBlog); repo1.save(category);
    }
    public String saveMyBlog(Post myPost, Category myCategory) {



//        Category category1= repo1.findCategoryByNameContains("Sci-fic");
//        System.out.println(category1.getName());
        System.out.println(myCategory.getName());
        if(myCategory.getName()!=null) {
            String[] cat = myCategory.getName().split(",");
            for (String category : cat) {
                Category category1= repo1.findCategoryByNameContains(category);
                myPost.getCategories().add(category1);
            }
        }
        repo.save(myPost);
        return "Blog saved";
    }
    public List<Post> listAll() {
        return (List<Post>) repo.findAll();
    }

    public Post get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
