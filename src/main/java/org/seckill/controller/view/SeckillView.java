package org.seckill.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("/")
public class SeckillView {

    @RequestMapping(value = "seckillList", method = RequestMethod.GET)
    public String listView() {
        return "seckillList";
    }

}
