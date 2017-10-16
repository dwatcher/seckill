package org.seckill.dao.ext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class SeckillDaoExtTest {

    @Resource
    private SeckillDaoExt seckillDaoExt;

    @Test
    public void reduceNumber() throws Exception {
        long id = 1000;
        seckillDaoExt.reduceNumber(id, new Date());
    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckills = seckillDaoExt.queryAll(0, 4);
        for (Seckill seckill: seckills) {
            System.out.println(seckill);
        }
    }

}