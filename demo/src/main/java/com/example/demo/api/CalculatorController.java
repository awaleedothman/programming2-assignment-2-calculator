package com.example.demo.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CalculatorController {

    @CrossOrigin(origins = {"http://localhost:8081", "http://192.168.1.5:8081"})
    @RequestMapping("/calculator/{expression}")
    public Result index(@PathVariable String expression) {
        return CalculatorService.getAnswer(expression);
    }
}


