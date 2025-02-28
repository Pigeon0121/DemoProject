package com.sjonline.service.impl;

import com.sjonline.mapper.CampusMapper;
import com.sjonline.model.Campus;
import com.sjonline.service.CampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
public class CampusServiceImpl implements CampusService {

    @Autowired
    private CampusMapper campusMapper;

    @Override
    @Transactional
    public Campus selectById(Long id) {
        return campusMapper.selectById(id);
    }

    @Override
    @Transactional
    public void saveCampus(Campus campus) {
        // 生成 UUID 编码
        campus.setCampusCode(UUID.randomUUID().toString().replace("-", ""));
        campus.setStatus(1); // 默认有效
        campusMapper.insert(campus);
    }

    @Override
    @Transactional
    public void disableCampus(Long id) {
        campusMapper.updateStatus(id, 2);
    }
}