package com.malex.controller;

import com.malex.model.GoodsEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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


    @RequestMapping(path = "/listGoods", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<GoodsEntity> listGoodsEntity() {
        List<GoodsEntity> list = new ArrayList<>();

        GoodsEntity entityOne = new GoodsEntity();
        entityOne.setId(2L);
        entityOne.setTitle("NoteBook");
        entityOne.setDescription("ASUS T100 TA");
        entityOne.setPrice(400.22);

        GoodsEntity entityTwo = new GoodsEntity();
        entityTwo.setId(3L);
        entityTwo.setTitle("Camera");
        entityTwo.setDescription("Sony");
        entityTwo.setPrice(135.23);

        list.add(entityOne);
        list.add(entityTwo);
        return list;
    }
}
