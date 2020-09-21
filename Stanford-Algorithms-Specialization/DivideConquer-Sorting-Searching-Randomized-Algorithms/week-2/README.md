
## The Master Method

- Cool Feature: A "blackbox" for solving recurrences.
- Assumption: All subproblems hava equal size.

### Recurrence Format
1 - Base case: T(n) < =  a constant for all sufficiently small n

2 - For all larger n:  
```
	T(n) <= aT(n/b) + O(n^d)
 			| 			|
		   (1)         (2)
		
		- (1) The work done inside the recursion 
		- (2) the work done outside the recursion
		- a: number of recursions call (>=1)
		- b: input size strictly greader than 1
		- d: amount of work done outside of the recursion

```

