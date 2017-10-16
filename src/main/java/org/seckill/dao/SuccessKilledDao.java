package org.seckill.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;
import org.seckill.entity.SuccessKilledExample;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface SuccessKilledDao {
    long countByExample(SuccessKilledExample example);

    int deleteByExample(SuccessKilledExample example);

    int deleteByPrimaryKey(@Param("seckillId") Long seckillId, @Param("userPhone") Long userPhone);

    int insert(SuccessKilled record);

    int insertSelective(SuccessKilled record);

    List<SuccessKilled> selectByExample(SuccessKilledExample example);

    SuccessKilled selectByPrimaryKey(@Param("seckillId") Long seckillId, @Param("userPhone") Long userPhone);

    int updateByExampleSelective(@Param("record") SuccessKilled record, @Param("example") SuccessKilledExample example);

    int updateByExample(@Param("record") SuccessKilled record, @Param("example") SuccessKilledExample example);

    int updateByPrimaryKeySelective(SuccessKilled record);

    int updateByPrimaryKey(SuccessKilled record);
}