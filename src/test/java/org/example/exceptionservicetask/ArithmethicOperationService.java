package org.example.exceptionservicetask;

public class ArithmethicOperationService {
    public static int divideIntWithNoExceptionHandling (int a, int b){
        return a/b;
    }

    public static int divideIntWithExceptionHandling (int a, int b){
        try {
            int result = a/b;
            return result;
        }
        catch (ArithmeticException e) {
            System.out.println("The exception from catch " + e.getMessage());
            return 0;
        }
    }
}


