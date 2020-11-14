package com.air.myblog.Controller;


import com.air.myblog.Dao.BlogDao;
import com.air.myblog.entity.Type;
import com.air.myblog.quervo.DetailedBlog;
import com.air.myblog.quervo.FontBlog;
import com.air.myblog.service.BlogService;
import com.air.myblog.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author air
 * @create 2020-10-25-20:50
 */
@Controller
public class IndexController {

    @Autowired
    BlogService blogService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, RedirectAttributes attributes){
        PageHelper.startPage(pageNum,8);
        List<FontBlog> allFontBlog = blogService.getFontBlog();
        PageInfo<FontBlog> blogPageInfo = new PageInfo<>(allFontBlog);
        List<Type> recommendType =typeService.getRecommendType();
        model.addAttribute("blogPageInfo",blogPageInfo);
        model.addAttribute("recommendTypes",recommendType);
        model.addAttribute("recommendBlogs",blogService.getAllRecommendBlog());
        
        return "index";
    }

    @PostMapping("/search")
    public String search(Model model,
                         @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                         @RequestParam String query){
        PageHelper.startPage(pageNum,10);
        List<FontBlog> searchBlog=blogService.getSearchBlog(query);
        PageInfo<FontBlog> pageInfo=new PageInfo<>(searchBlog);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("query",query);
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id,Model model){
        DetailedBlog detailedBlog=blogService.getDetailedBlog(id);
        model.addAttribute("blog",detailedBlog);
        return "blog";
    }

}
