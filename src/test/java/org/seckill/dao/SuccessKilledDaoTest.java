package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

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
        SuccessKilled successKilled = new SuccessKilled();
        successKilled.setSeckillId(1001L);
        successKilled.setUserPhone(18405865922L);
        successKilled.setState((byte) 0);
        successKilled.setCreateTime(new Date());
        successKilledDao.insertSelective(successKilled);
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByExample() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        SuccessKilled successKilled = successKilledDao.selectByPrimaryKey(1000L, 18405865922L);
        System.out.println(successKilled);
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