package com.buenosdev.stack.monotonicstack.dailyTemperatures

import java.util.*

class ProblemSolutionKt {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        // Initialize an array 'result' with the same size as 'temperatures' to store the result
        val result = IntArray(temperatures.size)

        // Initialize a stack to keep track of the indices of the temperatures
        val stack = Stack<Int>()

        // Iterate over the 'temperatures' array
        for (i in 0 until temperatures.size) {
            // While the stack is not empty and the current temperature is greater than the temperature at the top index of the stack
            while ((!stack.isEmpty()) && temperatures[stack.peek()] < temperatures[i]) {
                // Pop the top index from the stack
                val pop = stack.pop()

                // The number of days until a warmer temperature is the difference between the current day and the popped day
                result[pop] = i - pop
            }

            // Push the current index onto the stack
            stack.push(i)
        }

        // Return the result array
        return result
    }

//    The time complexity of this code is **O(n)**, where **n** is the size of the input array `temperatures`.
//
//    But why???
//
//    - The outer loop runs **n** times, where **n** is the size of the `temperatures` array.
//    - Inside the loop, each temperature is pushed onto the stack exactly once and popped off the stack exactly once when a warmer temperature is found. This means each temperature is processed a constant number of times.
//    - Therefore, the total number of operations is proportional to **n**, resulting in a linear time complexity of **O(n)**.
//
//    This is quite efficient as the code processes each temperature only a constant number of times.

}