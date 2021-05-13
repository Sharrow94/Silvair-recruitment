package com.recruitment.silvair.controller;

import com.recruitment.silvair.service.MathOperationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/calculator")
@AllArgsConstructor
public class OperationController {

    private final MathOperationService mathOperationService;

    @PostMapping("/addition")
    public double adding(@RequestParam("a")float a,@RequestParam("b")float b){
        return mathOperationService.addition(a,b);
    }

    @PostMapping("/division")
    public double division(@RequestParam("a")float a,@RequestParam("b")float b){
        return mathOperationService.division(a,b);
    }

    @PostMapping("/subtraction")
    public double subtraction(@RequestParam("a")float a,@RequestParam("b")float b){
        return mathOperationService.subtraction(a,b);
    }

    @PostMapping("/multiplication")
    public double multiplication(@RequestParam("a")float a,@RequestParam("b")float b){
        return mathOperationService.multiplication(a,b);
    }

    @GetMapping("/getSumOfLastTen")
    public double getSumOfLastTen(){
        return mathOperationService.getSumOfLastTenResults();
    }

}
