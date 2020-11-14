package com.air.myblog.Controller;

import com.air.myblog.entity.Type;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author air
 * @create 2020-11-04-22:49
 */
@Controller
public class TypeShowController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    //分页查询列表
    @GetMapping("/types/{id}")
    public String types(@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum, @PathVariable Long id, Model model){
        List<Type> types=typeService.getAllTypeAndBlog();
        if(id==-1){
            id=types.get(0).getId();
        }
        model.addAttribute("types",types);
        List<FontBlog> blogs=blogService.getByTypeId(id);

        PageHelper.startPage(pageNum,10000);
        PageInfo<FontBlog> pageInfo=new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("activeTypeId",id);
        return "types";
    }
}
