package com.miked;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by miked on 11/8/2016.
 */
public class UI {
    //scanners for scanning
    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);

    public void output(String output){
        System.out.println(output);
    }

    public String input(){
        return stringScanner.nextLine();
    }
    public String input(String prompt){
        output(prompt);
        return stringScanner.nextLine();
    }
    public void numOutput(String output){
        System.out.println(output);
    }
    public int numInput(){
        return numberScanner.nextInt();
    }
    /*numImput method that validates for entering a number
    * helps to keep the program running if the user enters a
    * letter where a number is expected*/
    public int numInput(String prompt){
        while (true) {
            numOutput(prompt);
            try {
                return numberScanner.nextInt();
            }catch (InputMismatchException ime){
                System.out.println("Enter a valid number");
                numberScanner.next();
            }
        }
    }
    //close the scanners
    public static void close(){
        numberScanner.close();
        stringScanner.close();
    }
}
