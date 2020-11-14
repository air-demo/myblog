package com.air.myblog.Dao;

import com.air.myblog.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author air
 * @create 2020-10-27-17:04
 */
@Mapper
@Repository
public interface TypeDao {
    int saveType(Type type);

    Type getType(Long id);

    List<Type>getAllType();

    int updateType(Type type);

    void deleteType(Long id);

    Type getTypeByName(String name);

    List<Type> getRecommendType();

    List<Type> getAllTypeAndBlog();
}
