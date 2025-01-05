package com.buenosdev.companiesquestions.uber.removeComments;

import java.util.LinkedList;
import java.util.List;

class ProblemSolution {

    /**/
    public List<String> removeComments(String[] source) {
        var queue = new LinkedList<String>();
        var temp = new StringBuilder();
        var blockComment = false;

        for (String line : source) {
            var lengthL = line.length();

            for (int i = 0; i < lengthL; i++) {
                if (blockComment) {
                    if (isEndOfBlock(line, lengthL, i)) {
                        blockComment = false;
                        i++;
                    }
                } else {
                    if (isStartOfBlock(line, lengthL, i)) {
                        blockComment = true;
                        i++;
                    } else if (isLineCommentBlock(line, lengthL, i)) {
                        break;
                    } else {
                        temp.append(line.charAt(i));
                    }
                }
            }

            if (!blockComment && temp.length() > 0) {
                queue.add(temp.toString());
                temp.setLength(0);
            }
        }
        return queue;

    }

    private static boolean isLineCommentBlock(String line, int lengthL, int i) {
        return i + 1 < lengthL && line.charAt(i) == '/' && line.charAt(i + 1) == '/';
    }

    private static boolean isEndOfBlock(String line, int lengthL, int i) {
        return i + 1 < lengthL && line.charAt(i) == '*' && line.charAt(i + 1) == '/';
    }

    private static boolean isStartOfBlock(String line, int lengthL, int i) {
        return i + 1 < lengthL && line.charAt(i) == '/' && line.charAt(i + 1) == '*';
    }
}