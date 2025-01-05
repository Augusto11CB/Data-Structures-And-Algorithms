package com.buenosdev.a.rotateMatrix;
class ProblemSolution {
    public void rotate(int[][] matrix) {
        // Initialize left and right pointers
        var l = 0;
        var r = matrix.length - 1;

        // Continue the process until the pointers meet
        while (l < r) {
            // Iterate over each element in the current layer
            for (int i = 0; i < r - l; i++) {
                // Define the top and bottom boundaries of the current layer
                var top = l;
                var bottom = r;

                // Save the top-left element temporarily
                var tmp = matrix[top][l + i];

                // Move the bottom-left element to the top-left position
                matrix[top][l + i] = matrix[bottom - i][l];

                // Move the bottom-right element to the bottom-left position
                matrix[bottom - i][l] = matrix[bottom][r - i];

                // Move the top-right element to the bottom-right position
                matrix[bottom][r - i] = matrix[top + i][r];

                // Move the saved top-left element to the top-right position
                matrix[top + i][r] = tmp;
            }
            // Move the left pointer inward
            l += 1;
            // Move the right pointer inward
            r -= 1;
        }
    }
}


/*
### Initial Matrix:
```
1 2 3
4 5 6
7 8 9
```

### First Layer Rotation (l = 0, r = 2):

1. **First Iteration (i = 0):**
   - Save `tmp = matrix[0][0]` (1).
   - Move `matrix[2][0]` (7) to `matrix[0][0]`.
   - Move `matrix[2][2]` (9) to `matrix[2][0]`.
   - Move `matrix[0][2]` (3) to `matrix[2][2]`.
   - Move `tmp` (1) to `matrix[0][2]`.
   - Matrix now looks like:
     ```
     7 2 1
     4 5 6
     9 8 3
     ```

2. **Second Iteration (i = 1):**
   - Save `tmp = matrix[0][1]` (2).
   - Move `matrix[1][0]` (4) to `matrix[0][1]`.
   - Move `matrix[2][1]` (8) to `matrix[1][0]`.
   - Move `matrix[1][2]` (6) to `matrix[2][1]`.
   - Move `tmp` (2) to `matrix[1][2]`.
   - Matrix now looks like:
     ```
     7 4 1
     8 5 2
     9 6 3
     ```

### Second Layer Rotation (l = 1, r = 1):
Since `l` is now equal to `r`, the while loop condition (`l < r`) is no longer satisfied, so the loop ends. There are no further layers to process.

### Final Rotated Matrix:
```
7 4 1
8 5 2
9 6 3
```

* */