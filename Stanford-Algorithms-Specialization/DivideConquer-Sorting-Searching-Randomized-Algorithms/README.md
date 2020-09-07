


## Guiding Principles for Analysis of Algorithms

### #1 Guilding Principle
Worst-Case-Analysis: our running time bound holds for every input of lenght `n`.

### #2 Guilding Principle
Won't pay much attention to constant factors, lower-order terms.

**Justifications**
- Constants depend on architectire. compiler, programmer, etc.

### #3 Guilding Principle
Asymptotic Analysis: Focus on running time for large input sizes `n`.

## Asymptotic Analysis
### Big-Oh Notation  

**Formal Definition:** T(n) = O(f(n)) if and only if there exist constants `c`,`n0` > 0 such that:
- T(n) <= `c`.f(n)
- FOR ALL `n` >= `n0`

> Here’s the definition: given functions f, g :
\- R → R, we say that
\- f(x) = O(g(x))
\- if there exist constants x0 and c > 0 such that |f(x)| ≤ c · g(x) for all x ≥ x0. Now this
definition is pretty hairy. But what it’s trying to say, with all its cryptic little constants,
is that f grows no faster than g. A bit more precisely, it says that f is at most a constant
times greater than g, except maybe for small values of x. F

#### Examples
![Big-Oh-Notation-Activity_2](https://github.com/AugustoCalado/Data-Structures-And-Algorithms/tree/master/Stanford-Algorithms-Specialization/DivideConquer-Sorting-Searching-Randomized-Algorithms/resources/Big-Oh-Notation-Activity_2.jpg)

![Big-Oh-Notation-Activity_1](https://github.com/AugustoCalado/Data-Structures-And-Algorithms/tree/master/Stanford-Algorithms-Specialization/DivideConquer-Sorting-Searching-Randomized-Algorithms/resources/Big-Oh-Notation-Activity_1.jpg)

### Omega Notation
Formal Definition: T(n) = Omega(f(n)) if and only if exist constants c,n0 such that:
- T(n) >= c.f(n)   
- For all  `n` >= `n0`

### Theta Notation
Formal Definition: `T(n) = Theta(f(n))` if and only if `T(n) = O(f(n))` **AND** `T(n) = Omega(f(n))`

Equivalent: Exist constants c1, c2, n0 such that c1 * f(n) <= T(n) <= c2 * f(n)
