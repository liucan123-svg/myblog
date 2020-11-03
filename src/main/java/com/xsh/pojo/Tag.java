package com.xsh.pojo;

import com.xsh.dao.BlogRepository;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "t_tag")
public class Tag {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "标签名称不能为空")
    private String name;

    @ManyToMany(mappedBy = "tags")
    @Where(clause ="published=true")//过滤草稿内容
    private List<Blog> blogs=new ArrayList<>();
    public Tag() {
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {

        for(Blog blog: blogs){
            blog.isPublished();
        }
        this.blogs = blogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
