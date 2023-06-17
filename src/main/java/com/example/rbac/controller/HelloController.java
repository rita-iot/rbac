package com.example.rbac.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: --
 * @author: Bing
 * @date: 2023/6/17 14:21
 * @version: 1.0
 */
@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "rbac";
    }

    @GetMapping("/hi")
    @PreAuthorize("hasAuthority('hi')")
    public String hi() {
        return "String";
    }


    @GetMapping("hello")
    @PreAuthorize("hasAuthority('sayhello')")
    public String hello() {
        return "hello security.ydlclass666";
    }
}
