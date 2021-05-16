package com.recruitment.silvair.service;

import com.recruitment.silvair.repository.MathOperationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class MathOperationServiceImplTest {

    @Mock
    MathOperationRepository mathOperationRepository=mock(MathOperationRepository.class);
    @InjectMocks
    MathOperationServiceImpl service=new MathOperationServiceImpl(mathOperationRepository);

    @Test
    public void addition() {
        Assertions.assertEquals(10,service.addition(5,5));
        Assertions.assertEquals(11.5,service.addition(6.5f,5));
    }

    @Test
    void subtraction() {
        Assertions.assertEquals(3.5,service.subtraction(5, 1.5f));
        Assertions.assertEquals(-5,service.subtraction(-1.5f,3.5f));
    }

    @Test
    void division() {
        Assertions.assertThrows(ArithmeticException.class,()->service.division(2,0));
        Assertions.assertEquals(2.5f,service.division(5,2));
    }

    @Test
    void multiplication() {
        Assertions.assertEquals(2.5f,service.division(5,2));
        Assertions.assertEquals(0,service.multiplication(5,0));
    }

    @Test
    void statForLastMin() {
        Assertions.assertThrows(IllegalArgumentException.class,()->service.statForLastMin(-1));
        Assertions.assertThrows(IllegalArgumentException.class,()->service.statForLastMin(5));
        when(mathOperationRepository.getStatForLastMin(0)).thenReturn(60L);
        Assertions.assertEquals(1,service.statForLastMin(0));

    }

    @Test
    void statForLastH() {
        Assertions.assertThrows(IllegalArgumentException.class,()->service.statForLastH(-1));
        Assertions.assertThrows(IllegalArgumentException.class,()->service.statForLastH(5));
        when(mathOperationRepository.getStatForLastH(0)).thenReturn(3600L);
        Assertions.assertEquals(1,service.statForLastH(0));
    }

    @Test
    void statForLastDay() {
        Assertions.assertThrows(IllegalArgumentException.class,()->service.statForLastDay(-1));
        Assertions.assertThrows(IllegalArgumentException.class,()->service.statForLastDay(5));
        when(mathOperationRepository.getStatForLastDay(0)).thenReturn(86400L);
        Assertions.assertEquals(1,service.statForLastDay(0));

    }

    @Test
    void getSumOfLastTenResults() {
        when(mathOperationRepository.getSumOfLastTenResults()).thenReturn(10.0);
        Assertions.assertEquals(10.0,service.getSumOfLastTenResults());
    }
}