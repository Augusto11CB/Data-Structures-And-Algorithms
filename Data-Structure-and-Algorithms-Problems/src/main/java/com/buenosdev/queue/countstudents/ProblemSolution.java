package com.buenosdev.queue.countstudents;

import java.util.LinkedList;

public class ProblemSolution {
    /*
    * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
    * */
    public int countStudents(int[] students, int[] sandwiches) {

        var queueOfStudents = new LinkedList<Integer>();

        var currentSandwiche = 0;
        var queueZeros = 0;
        var queueOnes = 0;

        for (int i : students) {
            if (i != sandwiches[currentSandwiche]) {
                queueOfStudents.add(i);
                if (i == 1) queueOnes = queueOnes + 1;
                else queueZeros = queueZeros + 1;
            } else {
                currentSandwiche = currentSandwiche + 1;
            }
        }


        while (!queueOfStudents.isEmpty()) {
            var nextStudent = queueOfStudents.pop();

            if (nextStudent == sandwiches[currentSandwiche]) {
                currentSandwiche = currentSandwiche + 1;
                if (nextStudent == 1) queueOnes = queueOnes - 1;
                else queueZeros = queueZeros - 1;
            } else {

                if ((sandwiches[currentSandwiche] == 0 && queueZeros == 0) ||
                        (sandwiches[currentSandwiche] == 1 && queueOnes == 0)
                ) {
                    queueOfStudents.add(nextStudent);
                    break;
                }
                queueOfStudents.add(nextStudent);
            }
        }

        return queueOfStudents.size();
    }

    public static void main(String[] args) {
        var ps = new ProblemSolution();

        var result1 = ps.countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1});
        System.out.println("Resultado: " + result1);
    }
}
