package com.buenosdev.dynamicProgramming.editDistance;

class ProblemSolution {
    public int minDistance(String w1, String w2) {
        var dp = new Integer[w1.length() + 1][w2.length() + 1];
        return dfs(dp, w1, w2, 0, 0);
    }

    private int dfs(Integer[][] dp, String s1, String s2, int i1, int i2) {
        if (dp[i1][i2] == null) {

            // Base cases:
            // 1. If we have reached the end of s1 (i.e., i1 == s1.length()):
            //    - We need to insert all remaining characters of s2 into s1.
            //    - The number of insertions needed is equal to the number of characters left in s2.
            if (i1 == s1.length()) {
                dp[i1][i2] = s2.length() - i2;
            }

            // 2. If we have reached the end of s2 (i.e., i2 == s2.length()):
            //    - We need to delete all remaining characters of s1.
            //    - The number of deletions needed is equal to the number of characters left in s1.
            else if (i2 == s2.length()) {
                dp[i1][i2] = s1.length() - i1;
            }

            // If the characters at the current positions in both strings match (s1.charAt(i1) == s2.charAt(i2)):
            // - No operation is needed at this step because the characters already match.
            // - Move both pointers forward to continue matching the next characters.
            else if (s1.charAt(i1) == s2.charAt(i2)) {
                dp[i1][i2] = dfs(dp, s1, s2, i1 + 1, i2 + 1);
            }

            // If the characters at the current positions in both strings do not match:
            else {
                // 1. **Delete Operation**:
                //    - We delete the current character from s1, which means advancing the i1 pointer.
                //    - The cost of this operation is 1 (the deletion itself) plus the cost of the remaining operations.
                int delete = dfs(dp, s1, s2, i1 + 1, i2);

                // 2. Insert the current character from s2 into s1 (advance i2).
                // Example:
                // s1: "abd", s2: "acd"
                // At this step:
                // - s1.charAt(i1) = 'b', s2.charAt(i2) = 'c'
                // If we "insert 'c' into s1", s1 would become "acbd".
                // Since we matched this inserted 'c' with s2's current character, we only advance i2 (i2 + 1),
                // leaving i1 unchanged to keep processing the 'b'.
                int insert = dfs(dp, s1, s2, i1, i2 + 1);

                // 3. **Replace Operation**:
                //    - We replace the current character in s1 with the current character in s2.
                //    - This operation advances both pointers (i1 and i2) because we are effectively matching
                //      the current characters and moving to the next positions in both strings.
                //    - The cost of this operation is 1 (the replacement itself) plus the cost of the remaining operations.
                int replace = dfs(dp, s1, s2, i1 + 1, i2 + 1);

                // Compute the minimum cost among the three operations and add 1 for the current operation's cost.
                dp[i1][i2] = 1 + Math.min(delete, Math.min(insert, replace));
            }
        }
        return dp[i1][i2];
    }
}

/*
md("horse", "hello")
	md("orse", "ello")
		md("orse", "llo")
			md("orse", "lo")
			md("rse", "llo") <-
			md("rse", "lo")
		md("rse", "ello")
			md("rse", "llo") <-
			md("se", "ello")
			md("se", "llo") <<-
		md("rse", "llo")
			md("rse", "llo") <-
			md("se", "llo") <<-
			md("se", "lo")
* */

/*
md("kitten", "sitting", 0, 0)
    md("itten", "sitting", 1, 0)    // Delete 'k'
        md("tten", "sitting", 2, 0)   // Delete 'i'
            md("ten", "sitting", 3, 0) // Delete 't'
                md("en", "sitting", 4, 0) // Delete 't'
                    md("n", "sitting", 5, 0) // Delete 'e'
                        md("", "sitting", 6, 0) // Delete 'n'
                            md("", "itting", 6, 1) // Insert 'i'
                            md("", "tting", 6, 2) // Insert 't'
                            md("", "ting", 6, 3) // Insert 't'
                            md("", "ing", 6, 4) // Insert 'i'
                            md("", "ng", 6, 5) // Insert 'n'
                            md("", "g", 6, 6) // Insert 'g'

                md("en", "sitting", 4, 1) // Replace 't' with 's'
                    md("n", "sitting", 5, 1)
                        md("", "sitting", 6, 1) // Similar to the paths above

        md("tten", "sitting", 2, 1) // Insert 's' in "kitten" before 't'
            md("ten", "sitting", 3, 1)
                md("en", "sitting", 4, 1)
                    md("n", "sitting", 5, 1)
                        md("", "sitting", 6, 1)

    md("itten", "sitting", 1, 1) // Replace 'k' with 's'
        md("tten", "sitting", 2, 1)
            md("ten", "sitting", 3, 1)
                md("en", "sitting", 4, 1)
                    md("n", "sitting", 5, 1)
                        md("", "sitting", 6, 1)

* */