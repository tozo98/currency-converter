package com.epam.training.currencyConverter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String converterHomePage(){
        return "converter";
    }
}
