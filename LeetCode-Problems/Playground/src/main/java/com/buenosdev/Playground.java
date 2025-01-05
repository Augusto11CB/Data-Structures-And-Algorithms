package com.buenosdev;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Playground {

    public static void main(String[] args) {
//        var input = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        var input = new int[]{9,8,7,6,5,4,3,2,1,0};
        System.out.println(validMountainArray(input));

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

    // 1346. Check If N and Its Double Exist - TODO
    public static boolean checkIfExist(int[] arr) {
        Set<Integer> setOfNumbersInArr = new HashSet<>();
        for (int i : arr) {

            if (setOfNumbersInArr.contains(i * 2) || (i % 2 == 0 && setOfNumbersInArr.contains(i / 2))) {
                return true;
            }
            setOfNumbersInArr.add(i);
        }
        return false;
    }

    public static boolean checkIfExisteV2(int[] arr) {
        var numbersInArr = new HashSet<Integer>();

        for (int num : arr) {
            if (numbersInArr.contains(num * 2) || (num % 2 == 0 && numbersInArr.contains(num / 2))) {
                return true;
            } else {
                numbersInArr.add(num);
            }
        }
        return false;
    }

    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;

        var index = 1;
        var isPeakFound = false;
        while (index < arr.length) {
            // [0,3,2,1]
            if (arr[index - 1] == arr[index]) {
                return false;
            }
            if (arr[index - 1] > arr[index]) {
                if(index - 1 == 0){
                    return false;
                }
                isPeakFound = true;
                break;
            }
            index++;
        }

        while (index < arr.length - 1) {
            // [0,3,2,1]
            if (index + 1 < arr.length && arr[index] == arr[index + 1]) {
                return false;
            }
            if (index + 1 < arr.length && arr[index] > arr[index + 1]) {
                index++;
                continue;
            }
            if (arr[index - 1] > arr[index]) {
                return false;
            }

        }
        if (!isPeakFound) return false;
        else return true;
    }
}

