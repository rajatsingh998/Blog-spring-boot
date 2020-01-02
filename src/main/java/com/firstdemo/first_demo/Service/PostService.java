package com.firstdemo.first_demo.Service;

import com.firstdemo.first_demo.Model.Category;
import com.firstdemo.first_demo.Model.Post;
import com.firstdemo.first_demo.Model.User;
import com.firstdemo.first_demo.Repository.CategoryRepository;
import com.firstdemo.first_demo.Repository.PostRepository;
import com.firstdemo.first_demo.Repository.UserRepository;
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

    @Autowired
    UserRepository repo2;

    public void save(Post theBlog) {
        repo.save(theBlog);
    }


    public  List<Post> sortByCreate(){ return repo.findAllByOrderByCreatedAtAsc();

    }
    public  List<Post> sortByUpdate(){ return repo.findAllByOrderByUpdatedAtAsc();

    }
    public String saveMyBlog(Post myPost, Category myCategory, String name) {



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
        User user=repo2.findByName(name);
        myPost.setUser(user);
        repo.save(myPost);
        return "Blog saved";
    }
    public List<Post> search(String keyword) {
        return repo.search(keyword);
    }
    public List<Post> listAll() {
//    User obj=new User("rajat","ygrygf.com","abc","admin");
//    User obj5=new User("user","ygrygf.com","user","user");
//
//    repo2.save(obj);
//    repo2.save(obj5);
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

    public List<Post> findAll(PageRequest pageable) {
        return repo.findAllBy((Pageable) pageable);
    }
    public  List<Post> find(Category category){
        return  repo.findByCategories(category);
    }
}
