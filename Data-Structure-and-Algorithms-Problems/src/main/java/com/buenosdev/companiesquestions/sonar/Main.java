package com.buenosdev.companiesquestions.sonar;

public class Main {
    public static void main(String[] args) {
        var circularSum = new Main();

//        int[] code1 = {5, 7, 1, 4};
//        int k1 = -2;
//        int[] decrypted1 = circularSum.decrypt(code1, k1);
//        System.out.println("Decrypted code with k = " + k1 + ": " + java.util.Arrays.toString(decrypted1));

        int[] code2 = {2,2,2,1,2,2,1,2,2,2};
        int k2 = 2;
        int decrypted2 = circularSum.numberOfSubarrays(code2, k2);
        System.out.println("Decrypted code with k = " + k2 + ": " + decrypted2);

    }
    public int[] decrypt(int[] code, int k) {
        var result = new int[code.length];

        for (int we = 0; we < code.length; we++) {
            if (k == 0) {
                result[we] = 0;
                continue;
            }

            if (k > 0) {
                result[we] = sumNext(code, k, we + 1);
            } else {
                result[we] = sumPrevious(code, k, we - 1);
            }
        }

        return result;

    }

    private int sumNext(int[] code, int k, int we) {
        var aux = 0;
        var toSum = 0;

        while (aux < k) {
            var idx = (we + aux) % code.length;
            toSum += code[idx];
            aux++;
        }
        return toSum;
    }

    private int sumPrevious(int[] code, int k, int we) {
        var aux = 0;
        var toSum = 0;
        var n = code.length;

        while (aux >= k) {
            var idx = (we - aux + n) % n;
            toSum += code[idx];
            aux++;
        }

        return toSum;
    }

    public int numberOfSubarrays(int[] nums, int k) {

        var ws = 0;
        var maxOdd = 0;
        var curOdd = 0;

        for(int we = 0; we < nums.length; we++){
            var isOdd = nums[we] % 2 != 0;

            if(isOdd) curOdd +=1;

            if(isOdd && curOdd == k){
                maxOdd +=1;
            } else if(curOdd >= k) {

                while (nums[ws] % 2 == 0){
                    ws++;
                    maxOdd++;
                }
                ws++;
                curOdd-=1;
            }
        }

        return maxOdd;

    }
}
