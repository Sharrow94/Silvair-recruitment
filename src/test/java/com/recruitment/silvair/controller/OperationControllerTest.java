package com.recruitment.silvair.controller;

import com.recruitment.silvair.service.MathOperationServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OperationControllerTest {

    @Mock
    MathOperationServiceImpl service=mock(MathOperationServiceImpl.class);

    @InjectMocks
    OperationController controller=new OperationController(service);

    @Test
    void adding() {
        when(service.addition(5.0,2.0)).thenReturn(7.0);
        Assertions.assertEquals(7.0,controller.adding(5.0,2.0));
    }

    @Test
    void division() {
        when(service.division(2.0,0)).thenThrow(ArithmeticException.class);
        Assertions.assertThrows(ArithmeticException.class,()->controller.division(2.0,0));
        when(service.division(2.0,1.0)).thenReturn(1.0);
        Assertions.assertEquals(1.0,controller.division(2.0,1.0));
    }

    @Test
    void subtraction() {
        when(service.subtraction(2.0,1.0)).thenReturn(1.0);
        Assertions.assertEquals(1.0,controller.subtraction(2.0,1.0));
    }

    @Test
    void multiplication() {
        when(service.multiplication(2.0,1.0)).thenReturn(2.0);
        Assertions.assertEquals(2.0,controller.multiplication(2.0,1.0));
    }

    @Test
    void getSumOfLastTen() {
        when(service.getSumOfLastTenResults()).thenReturn(15.0);
        Assertions.assertEquals(15.0,controller.getSumOfLastTen());
    }
}