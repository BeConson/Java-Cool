package com.conson.stealing.dao;

import com.conson.stealing.entity.Blog;
import com.conson.stealing.util.StealingMyBlog;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class BlogDaoTest {

    @Resource
    private BlogDao blogDao;

    @Autowired
    private StealingMyBlog stealingMyBlog;

    @Test
    public void select(){
        List<Blog> blogs = blogDao.selectList(null);
        blogs.forEach(System.out::println);
    }

    @Test
    public void insert(){
        Blog blog = new Blog();
        blog.setImg("con son");
        blog.setTitle("con son");
        blog.setInfo("con son");
        blog.setDate("con son");
        blog.setCategory("con son");
        blogDao.insert(blog);
    }


    @Test
    public void stealing() throws Exception {
        List<Blog> blogs = stealingMyBlog.StealingMyBlogData();
        for ( int i = 0 ; i < blogs.size() ; i++ ){
            Blog blog = new Blog();
            blog.setImg(blogs.get(i).getImg());
            blog.setTitle(blogs.get(i).getTitle());
            blog.setInfo(blogs.get(i).getInfo());
            blog.setDate(blogs.get(i).getDate());
            blog.setCategory(blogs.get(i).getCategory());
            blogDao.insert(blog);
        }
        System.out.println("========= 爬取数据中完成 + 成功写入数据库 ==========");

    }
}