package com.iheartraddio.festivalApp;

import java.util.regex.Pattern;

/**
 * Created by kkim on 4/6/15.
 */
public class RomanNumeralsUtil {

    public String convertToRomanNumeral(int number) {

        String romanNumeral = "";
        int remaining;

        if (number >= 1000) {
            remaining = number % 1000;
            for (int i = 0; i < number / 1000; i++) {
                romanNumeral += "M";
            }
            number = remaining;
        }

        if (number >= 900) {
            remaining = number % 900;
            for (int i = 0; i < number / 900; i++) {
                romanNumeral += "CM";
            }
            number = remaining;
        }

        if (number >= 500) {
            remaining = number % 500;
            for (int i = 0; i < number / 500; i++) {
                romanNumeral += "D";
            }
            number = remaining;
        }

        if (number >= 400) {
            remaining = number % 400;
            for (int i = 0; i < number / 400; i++) {
                romanNumeral += "CD";
            }
            number = remaining;
        }

        if (number >= 100) {
            remaining = number % 100;
            for (int i = 0; i < number / 100; i++) {
                romanNumeral += "C";
            }
            number = remaining;
        }

        if (number >= 90) {
            remaining = number % 90;
            for (int i = 0; i < number / 90; i++) {
                romanNumeral += "XC";
            }
            number = remaining;
        }

        if (number >= 50) {
            remaining = number % 50;
            for (int i = 0; i < number / 50; i++) {
                romanNumeral += "L";
            }
            number = remaining;
        }

        if (number >= 40) {
            remaining = number % 40;
            for (int i = 0; i < number / 40; i++) {
                romanNumeral += "XL";
            }
            number = remaining;
        }

        if (number >= 10) {
            remaining = number % 10;
            for (int i = 0; i < number / 10; i++) {
                romanNumeral += "X";
            }
            number = remaining;
        }

        if (number >= 9) {
            remaining = number % 9;
            for (int i = 0; i < number / 9; i++) {
                romanNumeral += "IX";
            }
            number = remaining;
        }

        if (number >= 5) {
            remaining = number % 5;
            for (int i = 0; i < number / 5; i++) {
                romanNumeral += "V";
            }
            number = remaining;
        }

        if (number >= 4) {
            remaining = number % 4;
            for (int i = 0; i < number / 4; i++) {
                romanNumeral += "IV";
            }
            number = remaining;
        }

        if (number >= 1) {
            for (int i = 0; i < number; i++) {
                romanNumeral += "I";
            }
        }

        
//        while (number >= 1000) {
//            remaining = number % 1000;
//            for (int i = 0; i < number / 1000; i++) {
//                romanNumeral += "M";
//            }
//            number = remaining;
//        }
//
//        while (number >= 900) {
//            romanNumeral += "CM";
//            number -= 900;
//        }
//
//        while (number >= 500) {
//            romanNumeral += "D";
//            number -= 500;
//        }
//
//        while (number >= 400) {
//            romanNumeral += "CD";
//            number -= 400;
//        }
//
//        while (number >= 100) {
//            romanNumeral += "C";
//            number -= 100;
//        }
//
//        while (number >= 90) {
//            romanNumeral += "XC";
//            number -= 90;
//        }
//
//        while (number >= 50) {
//            romanNumeral += "L";
//            number -= 50;
//        }
//
//        while (number >= 40) {
//            romanNumeral += "XL";
//            number -= 40;
//        }
//
//        while (number >= 10) {
//            romanNumeral += "X";
//            number -= 10;
//        }
//
//        while (number >= 9) {
//            romanNumeral += "IX";
//            number -= 9;
//        }
//
//        while (number >= 5) {
//            romanNumeral += "V";
//            number -= 5;
//        }
//
//        while (number >= 4) {
//            romanNumeral += "IV";
//            number -= 4;
//        }
//
//        while (number >= 1) {
//            romanNumeral += "I";
//            number -= 1;
//        }

        return "" + romanNumeral;
    }

    public boolean isValidRomanNumeral(String romanNumeral) {

        if (romanNumeral.equals("")) {
            return false;
        }

        // The regular expression pattern constructed (covering the VALID range from 0,000 - 4,999) will check for the following from left to right of the 'romanNumeral' string input...
        // Match group 1) 'M' appears between 0-4 times [covers the thousands place from 0-4]
        // Match group 2) 'CM' OR 'CD' appear up to 1 time OR 'D' can appear 0 or 1 times followed by 'C' appearing between 0-3 times [covers the hundreds place from 0-9]
        // Match group 3) 'XC' OR 'XL' appear up to 1 time OR 'L' can appear 0 or 1 times followed by 'X' appearing between 0-3 times [covers the tens place from 0-9]
        // Match group 4) 'IX' OR 'IV' appear up to 1 time OR 'V' can appear 0 or 1 times followed by 'I' appearing between 0-3 times [covers the ones place from 0-9]
        Pattern romanRegex = Pattern.compile("(M{0,4})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})");
        romanNumeral = romanNumeral.toUpperCase();

        return romanRegex.matcher(romanNumeral).matches();
    }
}
