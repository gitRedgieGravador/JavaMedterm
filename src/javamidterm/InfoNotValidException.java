/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamidterm;

import java.util.Scanner;

/**
 *
 * @author gravadorre_sd2023
 */
class InfoNotValidException extends Exception {
    public static Scanner input = new Scanner(System.in);

    public InfoNotValidException(String invalid) {
        super(invalid);
    }
    
    public static void isWithNoNumber(String str) throws InfoNotValidException {
        if (str.matches(".*\\d.*")) {
            throw new InfoNotValidException("Invalid Username!!!");
        }
    }

    public static void validatePassword(String str) throws InfoNotValidException {
        if (str.length() < 8) {
            throw new InfoNotValidException("Password is too short!!!");
        }
    }

    public static void isNumber(Object num) throws InfoNotValidException {
        String num1 = num.toString();
        for (char c : num1.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new InfoNotValidException("Invalid!!!");
            }
        }
    }
    
    public static String ask(String label) {
        System.out.print(label + ": ");
        return input.next();
    }
}
