#Mars Rover Simulation

###Overview

The Mars Rover Simulation is a Java-based application that simulates the movement of a rover on a grid-based terrain on Mars. The rover can navigate the grid, turn left, turn right, and move forward while avoiding obstacles and staying within the grid boundaries. The application is designed using Object-Oriented Programming (OOP) principles, the Command Pattern to encapsulate commands, and the Composite Pattern to manage the grid and obstacles.


##Features
Initialize the rover with a starting position and direction (N, S, E, W).
Commands to move forward ('M'), turn left ('L'), and turn right ('R').
Obstacle detection to prevent the rover from moving into obstacles.
Boundary checks to keep the rover within the grid.
Status reporting of the rover's current position and direction.


##Design Patterns
Command Pattern: Used to encapsulate the 'M', 'L', and 'R' commands as objects for flexibility.
Composite Pattern: Used to represent the grid and manage obstacles within the grid.
OOP Principles: Leveraged encapsulation, inheritance, and polymorphism to design the classes and their interactions.


##Classes and Interfaces
###Command Implementations
MoveCommand: Moves the rover forward.
TurnLeftCommand: Turns the rover left.
TurnRightCommand: Turns the rover right.

###Grid and Obstacle Management
Grid: Represents the grid and manages obstacles.
Obstacle: Represents an obstacle on the grid.
Direction Enum
Direction: Enum representing the four cardinal directions (N, E, S, W) with methods to turn left and right.

###Rover Class
Rover: Represents the rover, managing its position, direction, and interactions with the grid.
Main Simulation
MarsRoverSimulation: Main class to initialize the grid, rover, commands, and execute the simulation.


##Evaluation Criteria
Code Quality: Adherence to best practices, SOLID principles, and effective use of design patterns.
Functionality: Correct implementation of all required tasks.
Global Convention: Code is written in a way that is globally understandable.
Gold Standards: Effective handling of logging, exceptions, and validations.
Code Walkthrough: Ability to explain the architecture, design patterns used, and the decisions taken.

##Conclusion
This Mars Rover Simulation showcases the use of OOP principles and design patterns to build a robust and flexible application. The implementation ensures that the rover navigates the grid correctly while handling obstacles and boundaries effectively.
