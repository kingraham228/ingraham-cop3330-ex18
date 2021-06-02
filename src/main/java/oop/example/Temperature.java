package oop.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Temperature {
    private double startingTemp;
    private String tempChar;

    public void getTempType(){
        Scanner input = new Scanner(System.in);

        do{
            System.out.println("Press C to convert from Fahrenheit to Celsius.");
            System.out.println("Press F to convert from Celsius to Fahrenheit.");
            tempChar = input.next();

            if(tempChar.length() != 1)
            {
                System.out.println("Please enter only one letter.");
            }

            if (tempChar.equals("C")|| tempChar.equals("c") || tempChar.equals("F") || tempChar.equals("f")){
                System.out.println("Your choice: "+tempChar);
            } else{
                System.out.println("Unknown letter choice.");
                tempChar = "";
            }

        } while (tempChar.length()< 1);

    }

    public void getStartingTemp(){
        Scanner input = new Scanner(System.in);

        if(tempChar.equals("C") || tempChar.equals("c")){
            int loop;
            do {
                System.out.println("Please enter the temperature in Fahrenheit: ");
                while (!input.hasNextDouble()) {
                    String str1 = input.next();
                    System.out.println(str1 + " is not a valid temperature.");

                }
                startingTemp = input.nextDouble();
                loop = 1;

            } while (loop == 0);
        }else{
            int loop;
            do {
                System.out.println("Please enter the temperature in Celsius: ");
                while (!input.hasNextDouble()) {
                    String str1 = input.next();
                    System.out.println(str1 + " is not a valid temperature.");
                }
                startingTemp = input.nextDouble();
                loop = 1;

            } while (loop == 0);
        }
    }

    public void convertTemp(){
        BigDecimal convertedTemp;
        if(tempChar.equals("C") || tempChar.equals("c")){
            double step1 = startingTemp - 32;
            double step2 = step1 *5 / 9;
            convertedTemp = BigDecimal.valueOf(step2);
            convertedTemp = convertedTemp.setScale(2, RoundingMode.HALF_UP);
            System.out.println("The temperature in in Celsius is "+convertedTemp+".");

        }else{
            double step1 = startingTemp * 9 / 5;
            double step2 = step1 +32;
            convertedTemp = BigDecimal.valueOf(step2);
            convertedTemp = convertedTemp.setScale(2, RoundingMode.HALF_UP);
            System.out.println("The temperature in Fahrenheit is "+convertedTemp+".");

        }
    }

}
