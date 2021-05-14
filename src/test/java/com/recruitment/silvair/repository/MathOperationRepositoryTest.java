package com.recruitment.silvair.repository;

import com.recruitment.silvair.model.MathOperation;
import com.recruitment.silvair.model.TypeOfOperation;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig
@DataJpaTest
public class MathOperationRepositoryTest {

    @Autowired
    private MathOperationRepository repository;

    @Test
    public void getSumOfLastTenResults() {

        double result=repository.getSumOfLastTenResults();
        System.out.println(result);
        Assertions.assertEquals(result,100);
    }

    @Test
    void getStatForLastMin() {

    }

    @Test
    void getStatForLastH() {
    }

    @Test
    void getStatForLastDay() {
    }

    @Before
    public void initDatabase(){
        List<MathOperation>list=new ArrayList<>();
        MathOperation op1=new MathOperation();
        op1.setScore(20);
        op1.setTypeOfOperation(TypeOfOperation.addition);
        op1.setDateOfAdding(LocalDateTime.of(2021,5,14,20,26,35));
        list.add(op1);
        MathOperation op2=new MathOperation();
        op2.setScore(10);
        op2.setTypeOfOperation(TypeOfOperation.addition);
        op2.setDateOfAdding(LocalDateTime.of(2021,5,14,20,26,45));
        list.add(op2);
        MathOperation op3=new MathOperation();
        op3.setScore(10);
        op3.setTypeOfOperation(TypeOfOperation.addition);
        op3.setDateOfAdding(LocalDateTime.of(2021,5,14,20,26,55));
        list.add(op3);
        MathOperation op4=new MathOperation();
        op4.setScore(10);
        op4.setTypeOfOperation(TypeOfOperation.addition);
        op4.setDateOfAdding(LocalDateTime.of(2021,5,14,20,27,35));
        list.add(op4);
        MathOperation op5=new MathOperation();
        op5.setScore(10);
        op5.setTypeOfOperation(TypeOfOperation.addition);
        op5.setDateOfAdding(LocalDateTime.of(2021,5,14,20,27,45));
        list.add(op5);
        MathOperation op6=new MathOperation();
        op6.setScore(10);
        op6.setTypeOfOperation(TypeOfOperation.addition);
        op6.setDateOfAdding(LocalDateTime.of(2021,5,14,20,27,55));
        list.add(op6);
        MathOperation op7=new MathOperation();
        op7.setScore(10);
        op7.setTypeOfOperation(TypeOfOperation.addition);
        op7.setDateOfAdding(LocalDateTime.of(2021,5,14,20,28,35));
        list.add(op7);
        MathOperation op8=new MathOperation();
        op8.setScore(10);
        op8.setTypeOfOperation(TypeOfOperation.addition);
        op8.setDateOfAdding(LocalDateTime.of(2021,5,14,20,28,45));
        list.add(op8);
        MathOperation op9=new MathOperation();
        op9.setScore(10);
        op9.setTypeOfOperation(TypeOfOperation.addition);
        op9.setDateOfAdding(LocalDateTime.of(2021,5,14,20,28,55));
        list.add(op9);
        MathOperation op10=new MathOperation();
        op10.setScore(10);
        op10.setTypeOfOperation(TypeOfOperation.addition);
        op10.setDateOfAdding(LocalDateTime.of(2021,5,14,20,29,35));
        list.add(op10);
        MathOperation op11=new MathOperation();
        op11.setScore(10);
        op11.setTypeOfOperation(TypeOfOperation.addition);
        op11.setDateOfAdding(LocalDateTime.of(2021,5,14,20,29,45));
        list.add(op11);

        list.forEach(e->repository.save(e));
    }
}