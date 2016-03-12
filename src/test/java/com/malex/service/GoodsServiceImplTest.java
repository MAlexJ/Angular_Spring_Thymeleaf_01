package com.malex.service;

import com.malex.config.AppConfigTest;
import com.malex.model.GoodsEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfigTest.class})
public class GoodsServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private GoodsService goodsService;

    @Test
    @Rollback
    public void testMethodSave() {
        // given
        GoodsEntity expectEntity = new GoodsEntity();
        expectEntity.setTitle("New");
        expectEntity.setDescription("Desc");
        expectEntity.setPrice(100.12);

        // when
        GoodsEntity actualEntity = goodsService.save(expectEntity);

        //then
        assertNotNull(actualEntity);
        assertEquals(expectEntity, actualEntity);
    }

    @Test
    @Rollback
    public void testMethodUpdate() {
        // given
        GoodsEntity expectEntity = new GoodsEntity();
        expectEntity.setTitle("New");
        expectEntity.setDescription("Desc");
        expectEntity.setPrice(100.12);
        GoodsEntity entity = goodsService.save(expectEntity);

        // when
        entity.setTitle("Old");
        entity.setPrice(99.22);
        GoodsEntity actualEntity = goodsService.update(entity);

        //then
        assertNotNull(actualEntity);
        assertEquals(expectEntity, actualEntity);
    }

    @Test
    @Rollback
    public void testMethodFindById() {
        // given
        GoodsEntity expectEntity = new GoodsEntity();
        expectEntity.setTitle("New");
        expectEntity.setDescription("Desc");
        expectEntity.setPrice(100.12);
        GoodsEntity entity = goodsService.save(expectEntity);

        // when
        GoodsEntity actualEntity = goodsService.findById(entity.getId());

        //then
        assertNotNull(actualEntity);
        assertEquals(expectEntity, actualEntity);
    }


    @Test
    @Rollback
    public void testMethodFindAll() {
        // given
        List<GoodsEntity> expectList = listGoodsEntities();
        for (GoodsEntity entity:expectList) {
            goodsService.save(entity);
        }

        // when
        List<GoodsEntity> actualList = goodsService.findAll();

        //then
        assertNotNull(actualList);
        assertEquals(expectList, actualList);
    }

    private List<GoodsEntity> listGoodsEntities() {
        List<GoodsEntity> list = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            GoodsEntity entity = new GoodsEntity();
            entity.setTitle("New_" + i);
            entity.setDescription("Desc_" + i);
            entity.setPrice(100.12 + i);
            list.add(entity);
        }
        return list;
    }

}
