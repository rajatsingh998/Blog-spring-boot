package com.firstdemo.first_demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.internal.dynalink.linker.LinkerServices;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    private String title;
    private String content;
    @Column(name = "createdat", updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    public Post() {
    }

    @Column(name="updatedat")
    @UpdateTimestamp
    private Timestamp updatedAt;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "authorid",insertable = false, updatable = false)
    private User user;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "post_category", joinColumns = {@JoinColumn(name = "id")}, inverseJoinColumns = {@JoinColumn(name = "tagId")})
    private List<Category> categories=new ArrayList<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
