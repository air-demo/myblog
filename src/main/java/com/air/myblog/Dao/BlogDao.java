package com.air.myblog.Dao;

import com.air.myblog.entity.Blog;
import com.air.myblog.quervo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author air
 * @create 2020-10-29-17:04
 */
@Mapper
@Repository
public interface BlogDao {


    ShowBlog getBlogById(Long id);

    List<BlogQuery> getAllBlogQuery();

    int saveBlog(Blog blog);

    int updateBlog(ShowBlog showBlog);

    void deleteBlog(Long id);

    List<BlogQuery> searchByTitleOrTypeOrRecommend(SearchBlog searchBlog);

    List<FontBlog> getFontBlog();

    List<RecommendBlog> getAllRecommendBlog();

    List<FontBlog> getSearchBlog(String query);

    DetailedBlog getDetailedBlog(Long id);

    void updateViews(Long id);

    List<FontBlog> getByTypeId(Long typeId);
}
