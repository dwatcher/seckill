package org.seckill.dao.ext;

import org.apache.ibatis.annotations.Param;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.entity.SuccessKilled;
import org.seckill.entity.SuccessKilledExample;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SuccessKilledDaoExt extends SuccessKilledDao {

    void killByProcedure(Map<String, Object> paramMap);

}