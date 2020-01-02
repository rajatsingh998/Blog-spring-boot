package com.firstdemo.first_demo.Service;

import com.firstdemo.first_demo.Model.Category;
import com.firstdemo.first_demo.Model.Post;
import com.firstdemo.first_demo.Repository.CategoryRepository;
import com.firstdemo.first_demo.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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


    public  List<Post> sortByCreate(){ return repo.findAllByOrderByCreatedAtAsc();

    }
    public  List<Post> sortByUpdate(){ return repo.findAllByOrderByUpdatedAtAsc();

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
    public List<Post> search(String keyword) {
        return repo.search(keyword);
    }
    public List<Post> listAll() {
        return repo.findAll();
    }
    public  Page<Post> findPage(Pageable pageable){
        return repo.findAll(pageable);
    }
//    List <Post> search( String name){
//        return repo.findAllByTitleOrContent(name);
//    }

    public Post get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public Page<Post> findAll(PageRequest pageable) {
        return repo.findAll((Pageable) pageable);
    }
    public  List<Post> find(Category category){
        return  repo.findByCategories(category);
    }
}
