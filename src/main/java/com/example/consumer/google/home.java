package com.example.consumer.google;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("oauth2callback")
@RestController
public class home {

    @GetMapping("")
    public String callBack()
    {
        return "okay";
    }
}
