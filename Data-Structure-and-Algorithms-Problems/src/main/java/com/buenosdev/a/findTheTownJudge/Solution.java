package com.buenosdev.a.findTheTownJudge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/*

Example 2:

Input:n=3,trust=[[1,3],[2,3]]Output:3 Example 3:

Input:n=3,trust=[[1,3],[2,3],[3,1]]Output:-1

*/

class Solution {

    public int findJudge(int N, int[][] trust) {
        // Create an array to store the count of incoming and outgoing edges for each person.
        int[] count = new int[N + 1];

        // Traverse through the trust array and update the count array.
        // For each pair [a, b], decrement count[a] and increment count[b].
        for (int[] t : trust) {
            count[t[0]]--;  // Decrementing outgoing trust for person t[0].
            count[t[1]]++;  // Incrementing incoming trust for person t[1].
        }

        // Check each person's count of incoming edges.
        for (int i = 1; i <= N; ++i) {
            // If a person has incoming edges equal to N-1 and no outgoing edges (trusts no one),
            // then they are the judge.
            if (count[i] == N - 1)
                return i;
        }

        // If no judge is found, return -1.
        return -1;
    }

    public int findJudgeWorkingButNotPerformatic(int n, int[][] trust) {
        // Check for edge cases
        if (trust.length < 1 && n == 1) return 1;
        if (trust.length < 1 && n > 1) return -1;


        var matrixOfTrust = new int[n + 1][n + 1];
        var setOfTrustedPeople = new HashSet<Integer>();
        var setOfPeople = new HashSet<Integer>();

        // Fill the trustMatrix with -1
        for (int[] row : matrixOfTrust)
            Arrays.fill(row, -1);

        // Populate trustMatrix and hashsets
        for (int i = 0; i < trust.length; i++) {
            var personWhoTrust = trust[i][0];
            var personWhoIsTrusted = trust[i][1];
            setOfPeople.add(personWhoTrust);
            setOfPeople.add(personWhoIsTrusted);

            setOfTrustedPeople.add(personWhoIsTrusted);

            matrixOfTrust[personWhoTrust][personWhoIsTrusted] = 1;
        }

        // Check for the judge
        for (int i : setOfTrustedPeople) {
            var personITrustSome = false;

            // Check if this person trusts anyone
            // If this person trust any other person, then it is not the judge;
            for (int j = 0; j < n + 1; j++) {
                // if matrixOfTrust[i][j] == -1, indicates that a person i does not trust the person j
                if (matrixOfTrust[i][j] != -1) {
                    personITrustSome = true;
                    break;
                }
            }

            // does person 'i' trusted someone?
            if (personITrustSome) {
                // skip this person, because judge can't trust anyone.
                continue;
            }

            var trustedByAll = true;
            // Check if everybody trusts this person 'i'
            for (int personWhoTrust : setOfPeople) {
                if (personWhoTrust == i) continue;

                if (matrixOfTrust[personWhoTrust][i] != 1) {
                    trustedByAll = false;
                    break;
                }
            }

            if (trustedByAll)
                return i;
        }
        return -1;
    }


    public int findJudgeFAILED(int n, int[][] trust) {
        var mapOfTrust = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < trust.length; i++) {
            var trustListI = mapOfTrust.getOrDefault(trust[i][0], new ArrayList<Integer>());
            trustListI.add(trust[i][0]);
            mapOfTrust.put(trust[i][0], trustListI);
        }

        var possibleJudges = new HashSet<Integer>();

        for (int i = 1; i <= n; i++) {
            if (!mapOfTrust.containsKey(i))
                possibleJudges.add(i);
        }

        for (Map.Entry<Integer, List<Integer>> entry : mapOfTrust.entrySet()) {

        }

        return 0;
    }
}