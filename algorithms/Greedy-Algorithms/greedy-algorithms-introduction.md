# Greedy Algorithms Introduction

* **When we are using Greedy Algorithms?**
  * A problem that requires a solution that uses the minimum amount/cost of a given resource or the maximum amount/cost of a given resource.
  * In order words, greedy algorithms is applied to solve optimisation problems.
* Greedy approach focuses on immediate decisions.
* A **greedy algorithm** makes decisions at each step based on the **current best option**, without considering future consequences.
* A Greedy Algorithm is a problem-solving approach that constructs a solution step by step. It always selects the next step that provides the most immediate benefit (best "local" choice). It selects the best option at each stage.
* This kind of algorithm assumes that by choosing a local optimum solution will lead to the determination of a global optimum solution.&#x20;



### Video Explanation about Greedy Algorithm

* [Abdul Bari - Greedy Method - Introduction](https://www.youtube.com/watch?v=ARvQcqJ\_-NY\&list=PLfFeAJ-vQopt\_S5XlayyvDFL\_mi2pGJE3)



### When It is Suitable to Apply Greedy Algorithms?

Two properties can indicate the use of greedy algorithms to solve a problem.

* **Greedy Choice Property**: A global optimum is led to by the local optimal choices, meaning the best overall solution is led to by the best solution in each small step.
* **Optimal Substructure**: If the optimal solutions to its sub-problems are contained in an optimal solution to the entire problem, then a problem is said to have an optimal substructure.



### **Characteristics of Greedy Method** <a href="#object-object" id="object-object"></a>

Greedy algorithms share these characteristics:

* Local optimisation: A choice that seems the best at that moment is made by the algorithm at every step, with the aim of achieving local.
* Irrevocability: Once a decision has been made, it is irrevocable and cannot be revisited.



### Greedy Algorithm Solution Steps

> 1. Candidate set.
> 2. Feasibility function. :star:
> 3. Objetive Function.
> 4. Solution Function.

At each step, there will be a set of choices available in the **candidate set**. The **selection function** will then choose the most promising option. The **feasibility function** will evaluate the result to ensure that the candidate can contribute to a solution without violating any problem constraints. The **objective function** assesses the value or quality of the solution at each step. The s**olution function** then determines whether a complete solution has been achieved.

```kotlin
// a = [a1, a2, a3, a4, a5]
// n = 5 // size of the list

fun greedy(a: List<*>, n: Int): Result {
    var solution: Resut? = null
    for (i: int = 0; i < n; i++) {
        var x = selectFun(a[i])
        if (feasibleFun(x)) {
            solution = solution + x
        }
    }
}
```



### NP-Complete

**Set-Covering Problem:** Given a set of elements (called the universe) and a collection of subsets whose union equals the universe, the set cover problem is to identify the smallest sub-collection of subsets whose union equals the universe. It is a known NP-complete problem and there is no polynomial time solution available for this problem.

* > Suppose you’re starting a radio show. You want to reach listeners in all 50 states. You have to decide what stations to play on to reach all those listeners. It costs money to be on each station, so you’re trying to minimize the number of stations you play on. You have a list of stations. Each station covers a region, and there’s overlap. **How do you figure out the smallest set of stations you can play on to cover all 50 states?**
  >
  >
  >
  > \\- Grokking Algorithms: An Illustrated Guide for Programmers and Other Curious People

**Traveling Salesperson Problem (TSP):** A salesperson is given a list of cities, and must determine the shortest route that allows them to visit each city once and return to their original location. It is an NP-complete problem in combinatorial optimization, important in theoretical computer science and operations research.



> (1) Problem that requires calculations to determine the shortest route from point A to point B&#x20;
>
> **VERSUS**&#x20;
>
> (2) Problem that requires the discovery of the shortest path connecting multiple points.

The problem (2) is a NP-complete problem.

Determining whether a problem is NP-complete is not a straightforward task. These include: However, there are some indicators that can help identify such problems:

* The algorithm performs efficiently with a small number of items, but its performance significantly decreases as the number of items increases.&#x20;
* The phrase 'All combinations of X' typically indicates an NP-complete problem.
* If it is not possible to break down the problem into smaller sub-problems, it may be NP-complete.
* If your problem involves a sequence, such as a sequence of cities in the case of a traveling salesperson, and is difficult to solve, it may be NP-complete.
* If a problem involves a set, such as a set of radio stations, and is difficult to solve, it may be NP-complete.&#x20;
* Restating the problem as the set-covering problem or the traveling-salesperson problem confirms that it is NP-complete.



### Reference

Design Gurus. Grokking Data Structures for Coding Interviews: Introduction to Greedy Algorithm. Design Gurus, 2023. Disponível em: <[https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/656f0374b25e10bfbdc3bb17](https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/656f0374b25e10bfbdc3bb17)>. Acesso em: 29 fev. 2024.
