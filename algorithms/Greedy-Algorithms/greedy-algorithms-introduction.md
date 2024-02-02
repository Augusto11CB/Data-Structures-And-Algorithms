# Greedy Algorithms Introduction

* A Greedy Algorithm is a problem-solving approach that constructs a solution step by step. It always selects the next step that provides the most immediate benefit (best "local" choice). It selects the best option at each stage.
* This kind of algorithm assumes that by choosing a local optimum solution will lead to the determination of a global optimum solution.&#x20;



### When It is Suitable to Apply Greedy Algorithms?

Two properties can indicate the use of greedy algorithms to solve a problem.

* **Greedy Choice Property**: A global optimum is led to by the local optimal choices, meaning the best overall solution is led to by the best solution in each small step.
* **Optimal Substructure**: If the optimal solutions to its sub-problems are contained in an optimal solution to the entire problem, then a problem is said to have an optimal substructure.



### **Characteristics of Greedy Method** <a href="#object-object" id="object-object"></a>

Greedy algorithms share these characteristics:

* Local optimisation: A choice that seems the best at that moment is made by the algorithm at every step, with the aim of achieving local.
* Irrevocability: Once a decision has been made, it is irrevocable and cannot be revisited.



### Greedy Algorithm Solution Steps

At each step, there will be a set of choices available in the **candidate set**. The **selection function** will then choose the most promising option. The **feasibility function** will evaluate the result to ensure that the candidate can contribute to a solution without violating any problem constraints. The **Objective Function** assesses the value or quality of the solution at each step. The **Solution Function** then determines whether a complete solution has been achieved.
