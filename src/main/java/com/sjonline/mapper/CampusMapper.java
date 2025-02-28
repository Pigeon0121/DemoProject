package com.sjonline.mapper;

import com.sjonline.model.Campus;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CampusMapper {

    Campus selectById(Long id);

    void insert(Campus campus);

    void updateStatus(Long id, Integer status);
}