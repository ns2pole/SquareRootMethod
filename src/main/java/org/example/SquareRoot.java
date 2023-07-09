package org.example;

import java.util.ArrayList;

public class SquareRoot {

    public static Decimal getSquareRootFor(int target, int numberOfdecimalPart) {
        Decimal decimal = new Decimal();
        decimal.integerPart = getIntegerPart(target);
        decimal.decimalPart = getDecimalPartFor(target, numberOfdecimalPart);
        return decimal;
    }

    //ex.getDecimalPartFor(1000, 3) -> {6,2,2}
    //ex.getDecimalPartFor(2, 4) -> {4, 1, 4, 2}
    //ex.getDecimalPartFor(3, 3) -> {7, 3, 2}
    public static ArrayList<Integer> getDecimalPartFor(int target, int numberOfdecimalPart) {
        ArrayList<Integer> decimalPart = new ArrayList<>();
        // ex . target = 1000, numberOfdecimalPart = 3
        int firstSqrt = getIntegerPart(target); //31
        int givenNum = getFirstGivenNumFor(target); //620
        int substractNum = firstSqrt * firstSqrt;//961
        int nextTargetNum = getNextTargetNumFor(substractNum, target);//3900

        while (decimalPart.size() < numberOfdecimalPart) {
            int digit = getDigit(givenNum, nextTargetNum);//first 620,3900 -> 6, second:6320, 14400 -> 2
            decimalPart.add(digit);
            substractNum = getSubstractNumFor(givenNum, nextTargetNum);//first: 620, 3900 -> 3756
            givenNum = getNextGivenNumFor(givenNum, nextTargetNum);//first: 620, 3900 -> 6320
            nextTargetNum = getNextTargetNumFor(substractNum, nextTargetNum);// 3756, 3900 ->14400
        }
        return decimalPart;
    }

    public static int getIntegerPart(int number) {
        return (int) Math.sqrt(number);
    }

    public static int getDigit(int givenNum, int targetNum) {
        int x = 0;
        while ((givenNum + x + 1) * (x + 1) <= targetNum) {
            x++;
        }
        return x;
    }

    //ex.getNextTargetNumFor(96, 105) -> 900
    //ex.getNextTargetNumFor(18081, 20000) -> 191900
    //ex.getNextTargetNumFor(9, 15) -> 600
    public static int getNextTargetNumFor(int substractNum, int target) {
        int difference = target - substractNum;
        return difference * 100;
    }

    //ex.getSubstractNumFor(20, 105) -> 96
    //ex.getSubstractNumFor(2000, 20000) -> 18081
    //ex.getSubstractNumFor(0, 15) -> 3
    public static int getSubstractNumFor(int givenNum, int targetNum) {
        int digit = getDigit(givenNum, targetNum);
        return (givenNum + digit) * digit;
    }

    //ex.getFirstGivenNumFor(105) -> 200
    //ex.getFirstGivenNumFor(10004) -> 2000
    //ex.getFirstGivenNumFor(15) -> 60
    public static int getFirstGivenNumFor(int num) {
        return 2 * (int) Math.sqrt(num) * 10;
    }

    //ex.getNextGivenNumFor(620, 3900) -> 6320
    //ex.getNextGivenNumFor(100, 252) -> 1040
    public static int getNextGivenNumFor(int givenNum, int targetNum) {
        int digit = getDigit(givenNum, targetNum);
        return (givenNum + digit * 2) * 10;
    }

    //ex.getFirstGivenNumFor(105) -> 200
    //ex.getNextTargetNumFor(100, 105) -> 500

    //aaa
    //ex.getIntegerPartOf(1000) -> 31
    //ex.getFirstGivenNumFor(1000) -> 620
    //ex.getNextTargetNumFor(961, 1000) -> 3900
    //ex.getDigit(620, 3900) -> 6
    //ex.getSubstractNumFor(620, 3900) -> 3756
    //ex.getNextTargetNumFor(3756, 3900) -> 14400
    //ex.getNextGivenNumFor(620, 3900) -> 6320
    //ex.getDigit(6320, 14400) -> 2
    //ex.getSubstractNumFor(6320, 14400) -> 12644
    //ex.getNextTargetNumFor(12644, 14400) -> 175600
    //ex.getNextGivenNumFor(6320, 14400) -> 63240
    //ex.getDigit(63240, 175600) -> 2
    //ex.getSubstractNumFor(63240, 175600) -> 126484

}