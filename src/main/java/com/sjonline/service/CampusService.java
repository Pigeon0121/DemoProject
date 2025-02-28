package com.sjonline.service;

import com.sjonline.model.Campus;


public interface CampusService {

    Campus selectById(Long id);

    void saveCampus(Campus campus);

    void disableCampus(Long id);
}