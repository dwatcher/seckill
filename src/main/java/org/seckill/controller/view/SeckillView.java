package org.seckill.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Controller("/seckill")
public class SeckillView {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listView() {
        return "seckill/list";
    }

    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
    public String detailView(@PathVariable("seckillId") Long seckillId, Model model) {
        model.addAttribute(seckillId);
        return "seckill/detail";
    }

}
