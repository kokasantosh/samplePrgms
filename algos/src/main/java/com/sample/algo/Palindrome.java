package com.sample.algo;

public class Palindrome {

    public static void main(String[] args) {
        int num = 123321;

        System.out.println("Is Palindrome: " + isPalindrome(num));
    }

    private static Boolean isPalindrome(int num) {
        int divisor = 1;
        while(num/divisor > 10) {
            divisor *= 10;
        }

        while(num != 0) {
            int firstDigit = num/divisor;
            int lastDigit = num%10;

            if(firstDigit != lastDigit) {
                return false;
            }

            num = (num%divisor)/10;

            divisor /= 100;
        }
        return true;
    }
}
