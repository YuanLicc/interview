package com.yl.learn.spring;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class FBean {
    
    @Resource(name="bean")
    private Bean bean;
}
