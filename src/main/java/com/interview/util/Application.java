package com.interview.util;


public class Application {

//
//    public void method(String args) {
////        if (args.length() > 0) {
////            System.out.println("Hi ...");
////        }
//        throw new IllegalArgumentException("Add operation not implemented");
//    }

    private CalculatorService calcService;

    public void setCalculatorService(CalculatorService calcService){
        this.calcService = calcService;
    }

    public double add(double input1, double input2){
        return calcService.add(input1, input2);
    }

    public double subtract(double input1, double input2){
        return calcService.subtract(input1, input2);
    }

    public double multiply(double input1, double input2){
        return calcService.multiply(input1, input2);
    }

    public double divide(double input1, double input2){
        return calcService.divide(input1, input2);
    }

    public void throwEx(){
        throw new IllegalArgumentException("Hello ..");
    }

}
