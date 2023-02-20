package com.epam.training.currencyConverter.controller;

import com.epam.training.currencyConverter.service.ConverterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ResultPageController {

    ConverterService converterService;

    @GetMapping("/result")
    public String resultPage(
            @RequestParam(name = "inputValue")
            String inputValue,
            @RequestParam(name = "sourceCurrency")
            String sourceCurrency,
            @RequestParam(name = "targetCurrency")
            String targetCurrency,
            Model model) {
        String result = converterService.getResult(inputValue, sourceCurrency, targetCurrency);
        model.addAttribute("inputValue", inputValue);
        model.addAttribute("sourceCurrency", sourceCurrency);
        model.addAttribute("targetCurrency", targetCurrency);
        model.addAttribute("result", result);
        return "result";
    }
}
