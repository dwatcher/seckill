package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.ext.SeckillDaoExt;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class SeckillDaoTest {

    @Resource
    private SeckillDaoExt seckillDaoExt;

    @Test
    public void countByExample() throws Exception {
    }

    @Test
    public void deleteByExample() throws Exception {
    }

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByExample() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDaoExt.selectByPrimaryKey(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void updateByExampleSelective() throws Exception {
    }

    @Test
    public void updateByExample() throws Exception {
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

}