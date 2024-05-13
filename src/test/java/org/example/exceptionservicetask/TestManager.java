package org.example.exceptionservicetask;

public class TestManager {
    public static int getTextLength(String InputString) {
        return InputString.length();
    }

    public static int getTextLengthWithTryCatchFinally(String InputString) {
        try {
            return InputString.length();
        } catch (NullPointerException e) {
            System.out.println("An exception has been captured with the following exception " + e.getMessage());
            return 0;
        } finally {
            System.out.println("This block is executed from finally");
        }
    }
        public static int getTextLengthWithIfElse(String InputString){
            if (InputString == null) {
                System.out.println("InputString variable is null.....");
                return 0;
            } else {
                return InputString.length();
            }


        }
    }




