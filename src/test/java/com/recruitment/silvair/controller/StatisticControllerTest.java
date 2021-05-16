package com.recruitment.silvair.controller;

import com.recruitment.silvair.service.MathOperationServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StatisticControllerTest {

    @Mock
    MathOperationServiceImpl service=mock(MathOperationServiceImpl.class);

    @InjectMocks
    StatisticController controller=new StatisticController(service);

    @Test
    void statForLastMin() {
        when(service.statForLastMin(1)).thenReturn(1.0);
        Assertions.assertEquals(1.0,controller.statForLastMin(1));
        when(service.statForLastMin(5)).thenThrow(IllegalArgumentException.class);
        Assertions.assertThrows(IllegalArgumentException.class,()->controller.statForLastMin(5));
    }

    @Test
    void statForLastH() {
        when(service.statForLastH(1)).thenReturn(1.0);
        Assertions.assertEquals(1.0,controller.statForLastH(1));
        when(service.statForLastH(5)).thenThrow(IllegalArgumentException.class);
        Assertions.assertThrows(IllegalArgumentException.class,()->controller.statForLastH(5));
    }

    @Test
    void statForLastDay() {
        when(service.statForLastDay(1)).thenReturn(1.0);
        Assertions.assertEquals(1.0,controller.statForLastDay(1));
        when(service.statForLastDay(5)).thenThrow(IllegalArgumentException.class);
        Assertions.assertThrows(IllegalArgumentException.class,()->controller.statForLastDay(5));
    }
}