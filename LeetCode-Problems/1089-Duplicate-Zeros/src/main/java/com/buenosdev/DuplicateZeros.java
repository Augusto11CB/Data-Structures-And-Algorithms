package com.buenosdev;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DuplicateZeros {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 4, 1, 0, 0, 8, 0, 0, 3};
        duplicateZerosArrayList(arr.clone());
        System.out.println();
        duplicateZeros(arr.clone());
    }

    public static void duplicateZeros(int[] arr) {
        int numberOfZerosInArr = 0;
        int arrlength = arr.length - 1;

        // Count the zeros in the array arr
        for (int i = 0; i <= (arrlength - numberOfZerosInArr); i++) {
            if (arr[i] == 0) {
                // Edge case
                if (i == arrlength - numberOfZerosInArr) {
                    arr[arrlength] = 0;
                    arrlength = arrlength - 1;
                    break;
                }
                numberOfZerosInArr = numberOfZerosInArr + 1;
            }
        }

        int endAvailablePosition = arrlength - numberOfZerosInArr;
        for (int i = endAvailablePosition; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[numberOfZerosInArr + i] = 0;
                numberOfZerosInArr = numberOfZerosInArr - 1;
                arr[numberOfZerosInArr + i] = 0;
            } else {
                arr[numberOfZerosInArr + i] = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void duplicateZerosExtraArray(int[] arr) {
        int[] result = new int[arr.length];
        for (int resultArrIndex = 0, arrIndex = 0; resultArrIndex < result.length; resultArrIndex++, arrIndex++) {
            result[resultArrIndex] = arr[arrIndex];
            if (arr[arrIndex] == 0 && (resultArrIndex + 1 < result.length)) {
                result[resultArrIndex + 1] = 0;
                resultArrIndex++;
            }
        }
        for (int i = 0; i < result.length; i++)
            arr[i] = result[i];

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void duplicateZerosQueue(int[] arr) {
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                que.add(0);
                que.add(0);
            } else {
                que.add(arr[i]);
            }
            arr[i] = que.poll();
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void duplicateZerosArrayList(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int index = 0;

        while (index < arr.length) {
            if (arr[index] == 0) {
                result.addAll(List.of(0, 0));
            } else {
                result.add(arr[index]);
            }
            index++;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = result.get(i);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}


