# Insertion Sort Algorithm

### Insertion Sort Invariant
Positions 
- [0 ,1, 2, 3, j=4, 5, 6]
Values inside array
- [a1,a2,a3,a4,a5=key,a6,a6]

array A[0 ... j-1] is already sorted, so `a1 <= a2 <= a3 <= a4 `

### Example

Start Array: 3 5 8 1 4  2

```
key = 1 //3rd index

      8 > 1     => [ 3 5 1 8 4 2 ]  

      5 > 1     => [ 3 1 5 8 4 2 ]

      3 > 1     => [ 1 3 5 8 4 2 ]

      
```
Result: [ 1 3 5 8 4 2 ]

## Algorithm time consume - Time complexity

```
insertionSort (A, n)		 
1  for j = 2 until n                = n
2      x := A[j]		            = n−1
3      i := j−1		                = n−1
4      enquanto i > 0 e A[i] > x	≤ 2 + 3 + ... + n
5          A[i+1] := A[i]		    ≤ 1 + 2 + 3 + ... + n−1
6          i := i−1		            ≤ 1 + 2 + 3 + ... + n−1
7      A[i+1] := x		            = n−1
```

T(n) ≤ (3/2)n^2 + (7/2)n − 4.
T(n) = O(n^2)

```

### Best Case 
- Complexity: O(n)
- When the array is already sorted


### Worst Case 
- Complexity: O(n^2)
- Supose: array is in ascending order, and it must be sorted in descending order.
    -  Each element has to be compared with each of the other elements so, for every nth element, (n-1) number of comparisons are made. Thus, the total number of comparisons = n*(n-1)