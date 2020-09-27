
## The Master Method

- Cool Feature: A "blackbox" for solving recurrences.
- Assumption: All subproblems hava equal size.

### Recurrence Format
1 - Base case: T(n) <=  a constant for all sufficiently small n

2 - For all larger n:  
```
	T(n) <= aT(n/b) + O(n^d)
 			| 			|
		   (1)         (2)
		
		- (1) The work done inside the recursion 
		- (2) the work done outside the recursion
		- a: number of recursions call (>=1)
		- b: B is the factor by which the subproblem size is smaller than the original problem size
		- d: amount of work done outside of the recursion
```

### Master Method
![master-method](https://github.com/AugustoCalado/Data-Structures-And-Algorithms/blob/master/Stanford-Algorithms-Specialization/DivideConquer-Sorting-Searching-Randomized-Algorithms/week-2/resources/master-method.png)

### Example #1 - Mergesort
```js
function mergeSort(myArray, start, end) {

	let mid = (start + end) / 2;
	if(start < end) {
		mergeSort(myArray, start, mid);
		mergeSort(myArray, mid + 1, end);
		combine(myArray,start, mid, right);
	}
}
```

- `T(n) = 2 T(n/2) + _O(n)_    [the O(n) is for Combine]`
a = 2
b = 2
d = 1

**Apply the master method:**
- `b^d = a` => 2^1 = 2 **(Case I)**
- => `T(n) <= O(n^d * logn) = O(nlogn)`

### Example #2 - BinarySearch
```js
function binarySearch(myArray, start, end, targetValue) {
    if (start === end) {
        if (myArray[start] === targetValue) {
            return start;
        }
        else return -1;
    }
    
    midIndex = Math.floor((start + end) / 2); // Operation executed non-recursively 
    if (targetValue <= myArray[midIndex]) {
        return findIndex(myArray, start, midIndex, targetValue);
    } else {
        return findIndex(myArray, midIndex + 1, end, targetValue);
    }
}
```

- `T(n) = 1 + T(n/2), when n > 1.`
a = 1
b = 2
d = 0

**Apply the master method:**
`b^d=a` => 2^0 = 1 **(Case I)**
=> `T(n) <= O(n^d * logn) = O(nlogn)`


### Proof Master Method

At each level j= 0,1,2, . . ., `log _b\(n)` there are `a^j` subproblems, each of size `n/b^j`.
-	`log _b\(n)` is the number of times you can divide `n` by b before reaching 1;
	-	level 0
	-	level 1
	-	level 2
	-	..... ... ... ...
	-	level `log _b\(n)` -> base level -> leaf

#### Work at	a single level
Total work at level `j` (ignoring work in recursive call).

`<= a^j * c * (n/b^j)d` == `c * n^d * (a/n^d)^j`
- `a^j` number of level-j subproblems
- `n/b^j` size of each level-j subproblem  (-_-)
- `c * ((-_-))^d` - work per level-k subproblem

#### Total Work
![Total work Done](https://github.com/AugustoCalado/Data-Structures-And-Algorithms/blob/master/Stanford-Algorithms-Specialization/DivideConquer-Sorting-Searching-Randomized-Algorithms/week-2/resources/total-work-master-method.png)
