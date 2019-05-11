package com.chen.mapper;

import com.chen.pojo.DataDictionary;

import java.util.List;

public interface DataDictionaryMapper {


    List<DataDictionary> queryAllAppstatus();

    List<DataDictionary> queryAllFlatforms();
}