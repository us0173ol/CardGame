package com.miked;

import java.util.Scanner;

/**
 * Created by miked on 11/8/2016.
 */
public class UI {

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
    public int numInput(String prompt){
        numOutput(prompt);
        return numberScanner.nextInt();
    }

    public static void close(){
        numberScanner.close();
        stringScanner.close();
    }
}
