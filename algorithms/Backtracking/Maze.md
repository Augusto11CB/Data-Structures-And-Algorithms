# Maze 

## The Problem
A robot is asked to navigate a maze. It is placed at a certain position (the starting position) in the maze and is asked to try to reach another position (the goal position). Positions in the maze will either be open or blocked with an obstacle. Positions are identified by (x,y) coordinates.

At any given moment, the robot can only move 1 step in one of 4 directions.
The robot can only move to positions without obstacles and must stay within the maze.

The robot should search for a path from the starting position to the goal position (a solution path) until it finds one or until it exhausts all possibilities. In addition, it should mark the path it finds (if any) in the maze.

## Representation
S#####
.....#
#.####
#.####
...#.G
##...#


'.'	-	where the robot can move (open positions)
'#'	-	obstacles (blocked positions)
'S'	-	start position (here, x=0, y=0)
'G'	-	goal (here, x=5, y=4)

## References
- [Boston University Arts & Sciences](https://www.cs.bu.edu/teaching/alg/maze/)
- [](https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/)
- [](https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-using-stack/?ref=rp)
- [](https://www.geeksforgeeks.org/maze-with-n-doors-and-1-key/?ref=rp)
- [](https://www.geeksforgeeks.org/rat-in-a-maze-with-multiple-steps-jump-allowed/?ref=rp)
- [](https://www.geeksforgeeks.org/rat-in-a-maze-problem-when-movement-in-all-possible-directions-is-allowed/?ref=rp)