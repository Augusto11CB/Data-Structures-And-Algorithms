package com.buenosdev;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        // get input from command line
        int n = Integer.parseInt(args[0]);

        // call fizzbuzz
        List<String> result = fizzBuzz(n);

        // print result
        for (String s : result) {
            System.out.println(s);
        }
    }

    // tell the time and space complexity of the function fizzbuzz
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = n; i >= 0; i--) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}
