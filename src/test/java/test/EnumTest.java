package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.ext.SeckillDaoExt;
import org.seckill.entity.Seckill;
import org.seckill.param.JsonResultStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

public class EnumTest {

    @Test
    public void enumTest1() throws Exception {
        System.out.println(JsonResultStatus.SUCCESS);
    }



}