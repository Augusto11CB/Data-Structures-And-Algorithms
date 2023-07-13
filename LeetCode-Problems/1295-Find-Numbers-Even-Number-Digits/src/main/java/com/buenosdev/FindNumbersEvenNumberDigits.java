package com.buenosdev;

public class FindNumbersEvenNumberDigits {

    public static void main(String[] args) {
        int [] nums = {12,345,2,6,7896};
        System.out.println(new FindNumbersEvenNumberDigits().findNumbers(nums));

    }

    public int findNumbers(int[] nums) {
        int qtdNumberEvenDigits = 0;
        for (int i : nums) {
            if (String.valueOf(i).length() % 2 == 0) qtdNumberEvenDigits = qtdNumberEvenDigits + 1;
        }
        return qtdNumberEvenDigits;
    }
}
