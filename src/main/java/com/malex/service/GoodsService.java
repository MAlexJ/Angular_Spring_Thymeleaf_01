package com.malex.service;

import com.malex.model.GoodsEntity;

import java.util.List;

public interface GoodsService {

    GoodsEntity save(GoodsEntity entity);

    GoodsEntity update(GoodsEntity entity);

    void delete(Long id);

    GoodsEntity findById(Long id);

    List<GoodsEntity> findAll();
}
