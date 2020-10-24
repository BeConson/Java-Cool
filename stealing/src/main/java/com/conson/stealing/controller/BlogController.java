package com.conson.stealing.controller;

import com.conson.stealing.service.impl.BlogServiceImpl;
import com.conson.stealing.util.StealingMyBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author 康森
 * @date 2020/9/15 16 : 15 : 30
 * @description
 */
@Controller
@RequestMapping("/stealing")
public class BlogController {

    @Autowired
    private BlogServiceImpl blogService;

    @Autowired
    private StealingMyBlog stealingMyBlog;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/index/{page}")
    public String indexPage(@PathVariable Integer page,Model model) throws Exception {
        model.addAttribute("Data",stealingMyBlog.StealingMyBlogData(page));
        System.out.println(page);
        return "index";
    }

    @RequestMapping("/myBlog")
    public String stealingData(Model model) throws Exception {
        model.addAttribute("Data",blogService.StealingBlogData(null));
        return "index";
    }

    @RequestMapping("/myBlog/InsertDB")
    public String stealingDataInsertDB(Model model) throws Exception {
        blogService.StealingBlogDataAndInsertDB();
        model.addAttribute("msg","成功爬取数据，并写入数据库啦 ~");
        return "index";
    }

}
