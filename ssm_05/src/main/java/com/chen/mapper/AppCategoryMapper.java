package com.chen.mapper;

import com.chen.pojo.AppCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * app分类123
 */
public interface AppCategoryMapper {

    List<AppCategory> queryAlllevelOne();

    List<AppCategory> queryLevelByParentId(@Param("id") Long id);

}