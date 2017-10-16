package org.seckill.dao.ext;

import org.apache.ibatis.annotations.Param;
import org.seckill.dao.SeckillDao;
import org.seckill.entity.Seckill;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SeckillDaoExt extends SeckillDao {

    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * 根据偏移量查询秒杀商品列表
     * @param offet
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offet, @Param("limit") int limit);

}
