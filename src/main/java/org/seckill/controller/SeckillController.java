package org.seckill.controller;

import org.seckill.dto.Exposer;
import org.seckill.dto.JsonResult;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.param.JsonResultStatus;
import org.seckill.param.SeckillStatEnum;
import org.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/app/seckill")
public class SeckillController {

    @Autowired
    private SeckillService seckillService;

    @RequestMapping(value = "/list",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String list() {
        List<Seckill> list = seckillService.getSeckillList();
        return new JsonResult<List<Seckill>>(JsonResultStatus.SUCCESS, list).toJsonString();
    }

    @RequestMapping(value = "/{seckillId}/detail",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String detail(@PathVariable("seckillId") Long seckillId) {
        if (seckillId == null) {
            return new JsonResult(JsonResultStatus.FAIL, "seckillId is none!").toJsonString();
        }
        Seckill byId = seckillService.getById(seckillId);
        if (byId == null) {
            return new JsonResult(JsonResultStatus.FAIL, "scekill is none!").toJsonString();
        }
        return new JsonResult<Seckill>(JsonResultStatus.SUCCESS, byId).toJsonString();
    }

    @RequestMapping(value = "/time/now", method = RequestMethod.GET)
    @ResponseBody
    public String nowTime() {
        return new JsonResult<Long>(JsonResultStatus.SUCCESS, new Date().getTime()).toJsonString();
    }

    @RequestMapping(value = "/{seckillId}/exposer",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String exposer(@PathVariable("seckillId") Long seckillId) {
        JsonResult<Exposer> result;
        try {
            Exposer exposer = seckillService.exportSeckillUrl(seckillId);
            result = new JsonResult<Exposer>(JsonResultStatus.SUCCESS, exposer);
        } catch (Exception e) {
            e.printStackTrace();
            result = new JsonResult<Exposer>(JsonResultStatus.FAIL, e.getMessage());
        }
        return result.toJsonString();
    }

    @RequestMapping(value = "/{seckillId}/{md5}/execution",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String execution(@PathVariable("seckillId") Long seckillId,
                            @PathVariable("md5") String md5,
                            @CookieValue(value = "userPhone", required = false) Long userPhone) {
        if (userPhone == null) {
            return new JsonResult<SeckillExecution>(JsonResultStatus.FAIL, "未注册").toJsonString();
        }
        JsonResult<SeckillException> result;
        try {
            SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId, userPhone, md5);
            return new JsonResult<SeckillExecution>(execution.getState(), execution).toJsonString();
        } catch (RepeatKillException e1) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.REPEAT_KILL);
            return new JsonResult<SeckillExecution>(JsonResultStatus.FAIL, execution).toJsonString();
        } catch (SeckillCloseException e2) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.END);
            return new JsonResult<SeckillExecution>(JsonResultStatus.FAIL, execution).toJsonString();
        } catch (Exception e) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.INNER_ERROR);
            return new JsonResult<SeckillExecution>(JsonResultStatus.FAIL, execution).toJsonString();
        }
    }

}
