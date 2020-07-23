package com.sdgc.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Dell
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloWorldController {

    @GetMapping("/world")
    public String get() {
        BigDecimal one = BigDecimal.ONE;
        System.out.println(one);
        return "hello world";
    }
}
