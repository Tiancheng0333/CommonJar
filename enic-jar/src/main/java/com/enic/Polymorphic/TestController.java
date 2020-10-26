package com.enic.Polymorphic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/java")
@RestController
public class TestController {

    @Resource
    private IBusiness Business;

    @RequestMapping(value = "/poly/test", method = RequestMethod.GET)
    public Integer tryDeal() {
        return Business.calForAvg();
    }
}
