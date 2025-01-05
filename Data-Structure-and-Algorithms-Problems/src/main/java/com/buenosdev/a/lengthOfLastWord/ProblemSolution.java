package com.buenosdev.a.lengthOfLastWord;

class ProblemSolution {
    public int lengthOfLastWord(String s) {
        var result = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) != ' '){
                result++;
            } else {
                if(result > 0) return result;
            }
        }
        return result;
    }

    public int lengthOfLastWordII(String s) {
        var result = s.split(" ");
        return result[result.length - 1].length();
    }
}