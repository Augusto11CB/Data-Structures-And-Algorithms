package com.buenosdev;

public class Workspace {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        var count = new int[26];
        var s = "abcd";
        var t = "abcde";
        for (char c: s.toCharArray()) {
            var one = c -'0';
            var two = c - 'a';

        }

        findTheDifference(s, t);
    }

    public static char findTheDifference(String s, String t) {
        var count = new int[26];

        for(char c : s.toCharArray()){
            count[c - 'a']+=1;
        }

        for(char c : t.toCharArray()){
            count[c - 'a']-=1;
        }

        for(int i = 0; i < count.length; i++){
            var num = count[i];
            if(num != 0) return (char) (i + 'a');
        }
        return 'c';
    }
}
