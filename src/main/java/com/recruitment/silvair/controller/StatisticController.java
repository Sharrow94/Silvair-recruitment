package com.recruitment.silvair.controller;

import com.recruitment.silvair.service.MathOperationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/stat")
public class StatisticController {

    private final MathOperationService mathOperationService;

    @GetMapping("/forLastMin")
    public double statForLastMin(@RequestParam("type")int type){
        return mathOperationService.statForLastMin(type);
    }

    @GetMapping("/forLastH")
    public double statForLastH(@RequestParam("type")int type){
        return mathOperationService.statForLastH(type);
    }

    @GetMapping("/forLastDay")
    public double statForLastDay(@RequestParam("type")int type)throws IllegalArgumentException{
        return mathOperationService.statForLastDay(type);
    }
}
