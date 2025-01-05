package com.buenosdev.twopointers.compareVersion

class Solution {
    /*
If version1 < version2, return -1.
If version1 > version2, return 1.
Otherwise, return 0.


Example 1:

Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
Example 2:

Input: version1 = "1.0", version2 = "1.0.0"
Output: 0
Explanation: version1 does not specify revision 2, which means it is treated as "0".
Example 3:

Input: version1 = "0.1", version2 = "1.1"
Output: -1
Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.


Constraints:

1 <= version1.length, version2.length <= 500
version1 and version2 only contain digits and '.'.
version1 and version2 are valid version numbers.
All the given revisions in version1 and version2 can be stored in a 32-bit integer.
    * */


    fun compareVersion(version1: String, version2: String): Int {
        var i = 0
        var j = 0

        var v1 = version1.split(".").filter { it.isNotBlank() }.toTypedArray()
        var v2 = version2.split(".").filter { it.isNotBlank() }.toTypedArray()

        for (i in 0 until Math.max(v1.size, v2.size)) {
            var one = if (i < v1.size) v1[i].toInt() else 0
            var two = if (i < v2.size) v2[i].toInt() else 0

            if (one < two) {
                return -1
            } else if (one > two) {
                return 1
            }

        }

        return 0
    }
}