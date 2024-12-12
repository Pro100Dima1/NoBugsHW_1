package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        sumOfAddition(5, 8);
        substraction(8, 5);
        division(13, 7);
        multiplication(2, 5);
    }

    public static void sumOfAddition(int firstSum, int secondSum){
        int sum = firstSum + secondSum;
        System.out.println(sum);
    }

    public static void substraction(int firstSub, int secondSub){
        int sub = firstSub-secondSub;
        System.out.println(sub);
    }

    public static void division(int firstDiv, int secondDiv){
        int div = firstDiv%secondDiv;
        System.out.println(div);
    }

    public static void multiplication(int firstMul, int secondMul){
        int mul = firstMul*secondMul;
        System.out.println(mul);
    }
}

