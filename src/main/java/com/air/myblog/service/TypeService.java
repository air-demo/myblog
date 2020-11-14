package com.air.myblog.service;

import com.air.myblog.entity.Type;

import java.util.List;

/**
 * @author air
 * @create 2020-10-27-16:58
 */
public interface TypeService {

    int saveType(Type type);

    Type getType(Long id);

    List<Type> getAllType();

    int updateType(Type type);

    void deleteType(Long id);

    Type getTypeByName(String name);

    List<Type> getRecommendType();

    List<Type>getAllTypeAndBlog();
}
