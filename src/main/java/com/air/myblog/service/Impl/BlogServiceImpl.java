package com.air.myblog.service.Impl;

import com.air.myblog.Dao.BlogDao;
import com.air.myblog.Exception.NotFoundException;
import com.air.myblog.entity.Blog;
import com.air.myblog.quervo.*;
import com.air.myblog.service.BlogService;
import com.air.myblog.utils.MarkdownUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author air
 * @create 2020-10-29-16:55
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogDao blogDao;

    @Override
    public ShowBlog getBlogById(Long id) {
        return blogDao.getBlogById(id);
    }

    @Override
    public List<BlogQuery> getAllBlogQuery() {
        return blogDao.getAllBlogQuery();
    }


    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        blog.setCommentCount(0);
        return blogDao.saveBlog(blog);
    }

    @Override
    public int updateBlog(ShowBlog showBlog) {
        showBlog.setUpdateTime(new Date());
        return blogDao.updateBlog(showBlog);
    }

    @Override
    public void deleteBlog(Long id) {
        blogDao.deleteBlog(id);
    }

    @Override
    public List<BlogQuery> getBlogSearch(SearchBlog blog) {
        return blogDao.searchByTitleOrTypeOrRecommend(blog);
    }

    @Override
    public List<FontBlog> getFontBlog() {
        return blogDao.getFontBlog();
    }

    @Override
    public List<RecommendBlog> getAllRecommendBlog() {
        return blogDao.getAllRecommendBlog();
    }

    @Override
    public List<FontBlog> getSearchBlog(String query) {
        return blogDao.getSearchBlog(query);
    }

    @Override
    public DetailedBlog getDetailedBlog(Long id) {
        DetailedBlog detailedBlog = blogDao.getDetailedBlog(id);
        if (detailedBlog == null) {
            throw new NotFoundException("该博客不存在");
        }
        String content = detailedBlog.getContent();
        detailedBlog.setContent(MarkdownUtil.markdownToHtmlExtensions(content));
        //文章访问数量自增
        blogDao.updateViews(id);
        return detailedBlog;
    }


    @Override
    public List<FontBlog> getByTypeId(Long typeId) {
        return blogDao.getByTypeId(typeId);
    }
}
