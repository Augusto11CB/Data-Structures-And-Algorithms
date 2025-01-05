package com.buenosdev.twopointers.reverseWordsInStringIII;
import java.util.*;
class ProblemSolution {

    // https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
    public String reverseWords(String s) {
        var lastSpaceIndex = -1;
        var chArray = s.toCharArray();
        var len = s.length();
        
        for (int strIndex = 0; strIndex <= len; strIndex++) {
            // AUG AWESOME TWO POINTER
            if (strIndex == len || chArray[strIndex] == ' ') {
                int startIndex = lastSpaceIndex + 1;
                int endIndex = strIndex - 1;

                while (startIndex < endIndex) {
                    char temp = chArray[startIndex];
                    chArray[startIndex] = chArray[endIndex];
                    chArray[endIndex] = temp;
                    startIndex++;
                    endIndex--;
                }
                
                lastSpaceIndex = strIndex;
            }
        }
        return new String(chArray);
    }
    
    public String reverseWordsII(String s) {
        var ar = Arrays.stream(s.split(" "))
                .filter(word -> !word.isEmpty() && !word.isBlank())
                .toList();

        var sb = new StringBuilder();

        for(String word : ar){
            sb.append(reverse(word));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String reverse(String word){
        var i = 0;
        var j = word.length() - 1;
        var wordAr = word.toCharArray();
        
        while(i < j){
            var tmp = wordAr[i];
            wordAr[i] = wordAr[j];
            wordAr[j] = tmp;
            i++;
            j--;
        }
        return String.valueOf(wordAr);
    }
}