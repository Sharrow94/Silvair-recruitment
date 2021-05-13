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
    public float addition(float a, float b) {
        MathOperation operation=new MathOperation();
        float score=a+b;
        operation.setScore(score);
        operation.setTypeOfOperation(TypeOfOperation.addition);
        operation.setDateOfAdding(LocalDateTime.now());
        mathOperationRepository.save(operation);
        return score;
    }

    @Override
    public float subtraction(float a, float b) {
        MathOperation operation=new MathOperation();
        float score=a-b;
        operation.setScore(score);
        operation.setTypeOfOperation(TypeOfOperation.subtraction);
        operation.setDateOfAdding(LocalDateTime.now());
        mathOperationRepository.save(operation);
        return score;
    }

    @Override
    public float division(float a, float b) {
        if (b==0){
            throw new IllegalArgumentException("Can't divide by 0.");
        }
        MathOperation operation=new MathOperation();
        float score=a/b;
        operation.setScore(score);
        operation.setTypeOfOperation(TypeOfOperation.division);
        operation.setDateOfAdding(LocalDateTime.now());
        mathOperationRepository.save(operation);
        return score;
    }

    @Override
    public float multiplication(float a, float b) {
        MathOperation operation=new MathOperation();
        float score=a*b;
        operation.setScore(score);
        operation.setTypeOfOperation(TypeOfOperation.multiplication);
        operation.setDateOfAdding(LocalDateTime.now());
        mathOperationRepository.save(operation);
        return score;
    }

    @Override
    public double getSumOfLastTenResults() {
        return mathOperationRepository.getSumOfLastTenResults();
    }

    @Override
    public double statForLastMin(int typeOfOperation) {
        if (typeOfOperation<0||typeOfOperation>4){
            throw new IllegalArgumentException("Select from: addition=0,subtraction=1,multiplication=2,division=3");
        }
        return mathOperationRepository.getStatForLastMin(typeOfOperation);
    }

    @Override
    public double statForLastH(int typeOfOperation) {
        return mathOperationRepository.getStatForLastH(typeOfOperation);
    }

    @Override
    public double statForLastDay(int typeOfOperation) {
        return mathOperationRepository.getStatForLastDay(typeOfOperation);
    }
}
