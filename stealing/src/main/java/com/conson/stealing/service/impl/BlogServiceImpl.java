package com.conson.stealing.service.impl;

import com.conson.stealing.dao.BlogDao;
import com.conson.stealing.entity.Blog;
import com.conson.stealing.service.BlogService;
import com.conson.stealing.util.StealingMyBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 康森
 * @date 2020/9/15 17 : 29 : 13
 * @description
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogDao blogDao;

    @Autowired
    private StealingMyBlog stealingMyBlog;

    /**
     * 爬取博客数据
     * */
    @Override
    public List<Blog> StealingBlogData(Integer page) throws Exception {
        return stealingMyBlog.StealingMyBlogData();
    }

    /**
     * 爬取博客数据并写入数据库
     * */
    @Override
    public List<Blog> StealingBlogDataAndInsertDB() throws Exception {
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
        return blogs;
    }

}
