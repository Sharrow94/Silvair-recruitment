package com.recruitment.silvair.service;

import com.recruitment.silvair.model.MathOperation;

public interface MathOperationService {

    void add(MathOperation operation);

    double addition(double a,double b);
    double subtraction(double a,double b);
    double division(double a,double b);
    double multiplication(double a,double b);

    double getSumOfLastTenResults();

    //statistics
    double statForLastMin(int typeOfOperation);
    double statForLastH(int typeOfOperation);
    double statForLastDay(int typeOfOperation);


}
