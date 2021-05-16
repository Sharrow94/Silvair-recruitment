package com.recruitment.silvair.service;

import com.recruitment.silvair.model.MathOperation;
import com.recruitment.silvair.model.TypeOfOperation;
import com.recruitment.silvair.repository.MathOperationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class MathOperationServiceImpl implements MathOperationService {

    private final MathOperationRepository mathOperationRepository;

    public MathOperationServiceImpl(MathOperationRepository mathOperationRepository) {
        this.mathOperationRepository = mathOperationRepository;
    }


    @Override
    public void add(MathOperation operation) {
        mathOperationRepository.save(operation);
    }

    @Override
    public double addition(double a, double b) {
        MathOperation operation = new MathOperation();
        double score = a + b;
        operation.setScore(score);
        operation.setTypeOfOperation(TypeOfOperation.addition);
        operation.setDateOfAdding(LocalDateTime.now());
        add(operation);
        return score;
    }

    @Override
    public double subtraction(double a, double b) {
        MathOperation operation = new MathOperation();
        double score = a - b;
        operation.setScore(score);
        operation.setTypeOfOperation(TypeOfOperation.subtraction);
        operation.setDateOfAdding(LocalDateTime.now());
        add(operation);
        return score;
    }

    @Override
    public double division(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Can't divide by 0.");
        }
        MathOperation operation = new MathOperation();
        double score = a / b;
        operation.setScore(score);
        operation.setTypeOfOperation(TypeOfOperation.division);
        operation.setDateOfAdding(LocalDateTime.now());
        add(operation);
        return score;
    }

    @Override
    public double multiplication(double a, double b) {
        MathOperation operation = new MathOperation();
        double score = a * b;
        operation.setScore(score);
        operation.setTypeOfOperation(TypeOfOperation.multiplication);
        operation.setDateOfAdding(LocalDateTime.now());
        add(operation);
        return score;
    }

    @Override
    public double getSumOfLastTenResults() {
        return mathOperationRepository.getSumOfLastTenResults();
    }

    @Override
    public double statForLastMin(int typeOfOperation) {
        if (typeOfOperation < 0 || typeOfOperation > 4) {
            throw new IllegalArgumentException("Select from: addition=0,subtraction=1,multiplication=2,division=3");
        }
        return mathOperationRepository.getStatForLastMin(typeOfOperation)/60.0;
    }

    @Override
    public double statForLastH(int typeOfOperation) {
        if (typeOfOperation < 0 || typeOfOperation > 4) {
            throw new IllegalArgumentException("Select from: addition=0,subtraction=1,multiplication=2,division=3");
        }
        return mathOperationRepository.getStatForLastH(typeOfOperation)/3600.0;
    }

    @Override
    public double statForLastDay(int typeOfOperation) throws IllegalArgumentException{
        if (typeOfOperation < 0 || typeOfOperation > 4) {
            throw new IllegalArgumentException("Select from: addition=0,subtraction=1,multiplication=2,division=3");
        }
        return mathOperationRepository.getStatForLastDay(typeOfOperation)/86400.0;
    }
}
