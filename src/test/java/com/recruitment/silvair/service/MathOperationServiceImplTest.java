package com.recruitment.silvair.service;

import com.recruitment.silvair.repository.MathOperationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;


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


}