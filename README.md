# robotscommandcentre ( In Progress)
## Interview problem
This repo deals with the solution for a problem I faced in an interview.

## Problem Statement
Design a Robot board and a robot command centre. The robot command centre will give MOVE commands to robots and the robots will move in the robot board according to the instruction. we need to make sure there are no collission of robots during the movement.

## Scope
I am going to create a command line program first to visualise the path the robots are travelling and residing. 

## Design thought process
we will split the robot board into grids, each grid represent a single step that can be taken by a robot. For starter we will consider all the robots of same size. Before moving to the grid the robot has to lock the grid to avoid collission. Once locked it can move to the grid and unlock the previous grid. The other robots will wait to acquire the grid while moving. When a grid is the destination of the robot then other robots can not wait to unlock the grid, Instead they need to find an alternative route. Now finding the shortest path is a separate piece of this puzzle altogether.

## classes
- Robot - A POJO to represent a robot
- Grid - A POJO to represent the grid in the board
- Board - A POJO to represent the board
- Instruction - A POJO to represent the move instruction
- RobotCommandCentre - A class where we can select the robot and give instruction(Need to sync between choosing of robots as well)
- RobotBoard - A singleton instance which holds the latest information of robot's position 
- Initializer - A temporary Instance which initialises the position and params of the program
- InstructionProcessorEngine - Processor engine which identifies the instruction and invokes the corresponding instruction processor with the instruction
- InstructionProcessor(MoveInstructionProcessor) - An Instruction Processor which process the move instruction.
- PathIdentifier - Class which identifies the path for a robot given the source and destination. This should also consider the existing robots while identifying the path(Need to revisit the logic as the robots in the path may move and reside in a different grid/location while the path is being formed)

## Testing

- Create Multiple Instances of command centre and give instructions to Robot(can be either same robot / different robots)
- Track the instructions against the movement of robots and use the tracking to identify the collision if any.
- Cover boundary conditions like move instruction out of the board, move instruction with invalid values etc.
-  Create an automation robot to give multiple instructions to multiple robots in parallel.

# Phase II:
- Create a UI dashboard to view the instructions and movement of robots.
- Create a UI to give move instructions for robot
