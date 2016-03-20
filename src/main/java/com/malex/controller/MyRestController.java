package com.malex.controller;

import com.malex.model.GoodsEntity;
import com.malex.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyRestController {

    @Autowired
    private GoodsService goodsService;

    // GET /phone/{id} (View) – получает полную информацию о объекте.
    @RequestMapping(path = "/phone/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GoodsEntity goodsEntity(@PathVariable Long id) {
        return goodsService.findById(id);
    }


    // GET /phone/ (Index) – получает список всех объектов.
    @RequestMapping(path = "/phone",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<GoodsEntity> listGoodsEntity() {
        return goodsService.findAll();
    }

    // PUT /phone/ (Create) – создает новый объект.
    @RequestMapping(path = "/phone",
            method = RequestMethod.PUT)
    public void createGoodsEntity(@RequestBody GoodsEntity entity) {
        goodsService.save(entity);
    }

    // POST /phone/{id} (Edit) – изменяет данные с идентификатором {id}.


    // DELETE /phone/{id} (Delete) – удаляет данные с идентификатором {id}.
    @RequestMapping(path = "/phone/{id}",
            method = RequestMethod.DELETE)
    public void deleteGoodsEntity(@PathVariable Long id) {
        goodsService.delete(id);
    }
}
