package com.air.myblog.service;

import com.air.myblog.entity.Blog;
import com.air.myblog.quervo.*;

import java.util.List;

/**
 * @author air
 * @create 2020-10-29-16:55
 */
public interface BlogService {

    //编辑博客并展示内容
    ShowBlog getBlogById(Long id);



    //后端展示博客，时间轴展示,
    List<BlogQuery> getAllBlogQuery();

    //添加博客
    int saveBlog(Blog blog);

    //更新博客
    int updateBlog(ShowBlog showBlog);

    //删除博客
    void deleteBlog(Long id);

    //模糊查询
    List<BlogQuery> getBlogSearch(SearchBlog blog);

    //查询前端页面
    List<FontBlog> getFontBlog();

    //前端推荐文章
    List<RecommendBlog> getAllRecommendBlog();

    //前端搜索结果
    List<FontBlog> getSearchBlog(String query);

    //前端展示详细博客页面
    DetailedBlog getDetailedBlog(Long id);

    //根据TypeId获取博客列表，在分类页进行的操作
    List<FontBlog> getByTypeId(Long typeId);
}
