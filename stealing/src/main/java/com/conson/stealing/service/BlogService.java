package com.conson.stealing.service;

import com.conson.stealing.entity.Blog;

import java.util.List;

/**
 * @author 康森
 * @date 2020/9/15 17 : 26 : 42
 * @description
 */
public interface BlogService {

    /**
     * 爬取博客数据
     * */
    List<Blog> StealingBlogData(Integer page) throws Exception;

    /**
     * 爬取博客数据并写入数据库
     * */
    List<Blog> StealingBlogDataAndInsertDB() throws Exception;

}
