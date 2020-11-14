package com.air.myblog.Controller;

import com.air.myblog.quervo.BlogQuery;
import com.air.myblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author air
 * @create 2020-11-05-12:43
 */
@Controller
public class ArchiveShowController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archive(Model model){
        List<BlogQuery> blogs=blogService.getAllBlogQuery();
        model.addAttribute("blogs",blogs);
        return "archives";
    }

}
