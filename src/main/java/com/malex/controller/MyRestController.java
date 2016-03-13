package com.malex.controller;

import com.malex.model.GoodsEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @RequestMapping(path = "/goods", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GoodsEntity goodsEntity() {
        GoodsEntity entity = new GoodsEntity();
        entity.setId(1L);
        entity.setTitle("Phone");
        entity.setDescription("Nokia 3110");
        entity.setPrice(99.12);
        return entity;
    }
}
