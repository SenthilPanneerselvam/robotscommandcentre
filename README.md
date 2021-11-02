# robotscommandcentre ( In Progress)
## Interview problem
This repo deals with the solution for a problem I faced in an interview.

## Problem Statement
Design a Robot board and a robot command centre. The robot command centre will give MOVE commands to robots and the robots will move in the robot board according to the instruction. we need to make sure there are no collission of robots during the movement.

## Scope
I am going to create a command line program first to visualise the path the robots are travelling and residing. 

## Design thought process
we will split the robot board into grids, each grid represent a single step that can be taken by a robot. For starter we will consider all the robots of same size. Before moving to the grid the robot has to lock the grid to avoid collission. Once locked it can move to the grid and unlock the previous grid. The other robots will wait to acquire the grid while moving. When a grid is the destination of the robot then other robots can not wait to unlock the grid, Instead they need to find an alternative route. Now finding the shortest path is a separate piece of puzzle altogether.

## classes
Robot - A POJO to represent a robot
Grid - A POJO to represent the grid in the board
Board - A POJO to represent the board
Instruction - A POJO to represent the move instruction
RobotCommandCentre - A class where we can select the robot and give move instruction
RobotBoard - A singleton instance which holds the latest information of robot's position 

## Testing

<< To list all scenarios we are going to test >>
