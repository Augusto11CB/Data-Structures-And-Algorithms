package com.buenosdev;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        mergeV2(nums1, m, nums2, n);

    }

    public static void mergeV2(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int index = m + n - 1;

        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] >= nums2[index2]) {
                nums1[index] = nums1[index1];
                index1--;
            } else {
                nums1[index] = nums2[index2];
                index2--;
            }
            index--;
        }

        while (index1 >= 0) {
            nums1[index] = nums1[index1];
            index1--;
            index--;
        }

        while (index2 >= 0) {
            nums1[index] = nums2[index2];
            index2--;
            index--;
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int len1 = 0;
        int len2 = 0;
        int rIndex = 0;

        while (len1 < m && len2 < n) {
            if (nums1[len1] <= nums2[len2]) {
                result[rIndex] = nums1[len1];
                len1++;

            } else if (nums1[len1] > nums2[len2]) {
                result[rIndex] = nums2[len2];
                len2++;
            }
            rIndex++;
        }

        while (len1 < m) {
            result[rIndex] = nums1[len1];
            len1++;
            rIndex++;
        }

        while (len2 < n) {
            result[rIndex] = nums2[len2];
            len2++;
            rIndex++;
        }

        for (int i = 0; i < m + n; i++) {
            System.out.print(result[i] + ",");
        }
    }
}