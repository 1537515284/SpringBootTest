package com.ls.controller;

import com.ls.common.anno.NotControllerResponseAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    @NotControllerResponseAdvice
    public String health(){
        return "success";
    }
}
