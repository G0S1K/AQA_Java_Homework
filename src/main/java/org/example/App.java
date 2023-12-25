package org.example;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println(factorial(0));
    }

    public static int factorial(int number) {
        if (number < 0 ) throw new IllegalArgumentException("Number must be positive");
        return number == 0 ? 1 : number * factorial(number - 1);
    }
}
