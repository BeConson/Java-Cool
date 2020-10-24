package com.conson.stealing.util;

import com.conson.stealing.entity.Blog;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 康森
 * @date 2020/9/14 18 : 17 : 15
 * @description
 */
@Component
public class StealingMyBlog {
    public static void main(String[] args) throws Exception {

        new StealingMyBlog().StealingMyBlogData(3).forEach(System.out::println);

    }

    private List<Blog> StealingMethod(Integer page) throws Exception {
        //爬自己博客网站的数据
//        String url = "https://conson.club";
        String url = null ;

        if ( page == null ){
            url = "https://conson.club";
        }else if( page == 1 ){
            url = "https://conson.club";
        }else {
            url = "https://conson.club"+"/page/"+page;
        }

        Document document = Jsoup.parse(new URL(url), 300000);
        Elements card = document.getElementsByClass("index-card");
        List<Blog> list = new ArrayList<>();

        for (Element element : card) {
            String img = element.getElementsByTag("img").eq(0).attr("src");
            String title = element.getElementsByClass("index-header").eq(0).text();
            String info = element.getElementsByClass("index-excerpt").eq(0).text();
            String date = element.getElementsByClass("post-meta").eq(0).text();
            String category = element.getElementsByClass("post-meta").eq(1).text();

            Blog blog = new Blog();
            blog.setImg(img);
            blog.setTitle(title);
            blog.setInfo(info);
            blog.setDate(date);
            blog.setCategory(category);
            list.add(blog);
        }
//        System.out.println(list);
        return list;
    }

    public List<Blog> StealingMyBlogData() throws Exception {

        //爬自己博客网站的数据
//        String url = "https://conson.club";
//        Document document = Jsoup.parse(new URL(url), 300000);
//        Elements card = document.getElementsByClass("index-card");
//
//        List<Blog> list = new ArrayList<>();
//
//        for (Element element : card) {
//            String img = element.getElementsByTag("img").eq(0).attr("src");
//            String title = element.getElementsByClass("index-header").eq(0).text();
//            String info = element.getElementsByClass("index-excerpt").eq(0).text();
//            String date = element.getElementsByClass("post-meta").eq(0).text();
//            String category = element.getElementsByClass("post-meta").eq(1).text();
//
//            Blog blog = new Blog();
//            blog.setImg(img);
//            blog.setTitle(title);
//            blog.setInfo(info);
//            blog.setDate(date);
//            blog.setCategory(category);
//            list.add(blog);
//        }
//        System.out.println(list);
        return StealingMethod(null);
    }

    public List<Blog> StealingMyBlogData(Integer page) throws Exception {

        //爬自己博客网站的数据
//        String url = null ;
//
//        if ( page == 1 ){
//            url = "https://conson.club";
//        }else {
//            url = "https://conson.club"+"/page/"+page;
//        }
//
//        Document document = Jsoup.parse(new URL(url), 300000);
//        Elements card = document.getElementsByClass("index-card");
//
//        List<Blog> list = new ArrayList<>();
//
//        for (Element element : card) {
//            String img = element.getElementsByTag("img").eq(0).attr("src");
//            String title = element.getElementsByClass("index-header").eq(0).text();
//            String info = element.getElementsByClass("index-excerpt").eq(0).text();
//            String date = element.getElementsByClass("post-meta").eq(0).text();
//            String category = element.getElementsByClass("post-meta").eq(1).text();
//
//            Blog blog = new Blog();
//            blog.setImg(img);
//            blog.setTitle(title);
//            blog.setInfo(info);
//            blog.setDate(date);
//            blog.setCategory(category);
//            list.add(blog);
//        }
//        System.out.println(list);
        return StealingMethod(page);
    }
}
