package com.recruitment.silvair.service;

import com.recruitment.silvair.model.MathOperation;

public interface MathOperationService {

    void add(MathOperation operation);

    float addition(float a,float b);
    float subtraction(float a,float b);
    float division(float a,float b);
    float multiplication(float a,float b);

    double getSumOfLastTenResults();

    //statistics
    double statForLastMin(int typeOfOperation);
    double statForLastH(int typeOfOperation);
    double statForLastDay(int typeOfOperation);


}
