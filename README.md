# GameOfLife
The program will implement a text based version of Conway's biological simulation "The Game of Life" (and not the board game). The starting data from the file will be read in from a text file and the simulation will run on a turn by turn basis. The starting data consists of empty spaces or stars to be read into an array of references to 'Critters'. Spaces in the input file will result in a critter whose appearance is 'EMPTY' (a class constant representing a space in the definition of class Critter) while a star will result in a critter whose appearance is the 'DEFAULT_APPEARANCE' (a class constant representing a star in the definition of class Critter). Each turn the rules of births and deaths will change the pattern.

Rules for births and deaths for the Game of life.

Deaths: Cells that contain a critter will have the critter die under the following conditions:
Loneliness: fewer than 2 neighbors. 
Over crowding: more than 3 neighbors.  
Anything else (2 or 3 neighbors) results in the critter remaining alive. 
Births: Cells that are empty will have new critter born into it if it has exactly 3 neighbors (otherwise it remains empty).
