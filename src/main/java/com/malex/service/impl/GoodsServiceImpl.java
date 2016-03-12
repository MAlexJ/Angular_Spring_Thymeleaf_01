package com.malex.service.impl;

import com.malex.model.GoodsEntity;
import com.malex.repository.GoodsRepository;
import com.malex.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository repository;

    @Override
    public GoodsEntity save(GoodsEntity entity) {
        return this.repository.saveAndFlush(entity);
    }

    @Override
    public GoodsEntity update(GoodsEntity entity) {
        return this.repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        this.repository.delete(id);
    }

    @Override
    public GoodsEntity findById(Long id) {
        return this.repository.findOne(id);
    }

    @Override
    public List<GoodsEntity> findAll() {
        return this.repository.findAll();
    }
}
