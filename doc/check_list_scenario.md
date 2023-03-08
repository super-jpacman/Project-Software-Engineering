JPacman Scenarios Check List
=================

#### Story 1: Startup
```
As a player
 I want to start the game
so that I can actually play
 
Scenario S1.1: Start.
Given the user has launched the JPacman GUI;
When  the user presses the "Start" button;
Then  the game should start.

Check S1.1 Done.
```

#### Story 2: Move the Player
```
As a player, 
 I want to move my Pacman around on the board;
So that I can earn all points and win the game.

Scenario S2.1: The player consumes
Given the game has started,
 and  my Pacman is next to a square containing a pellet;
When  I press an arrow key towards that square;
Then  my Pacman can move to that square,
 and  I earn the points for the pellet,
 and  the pellet disappears from that square.
Check S2.1 Done.

Scenario S2.2: The player moves on empty square
Given the game has started,
 and  my Pacman is next to an empty square;
When  I press an arrow key towards that square;
Then  my Pacman can move to that square
 and  my points remain the same.
Check S2.2 Done.

Scenario S2.3: The move fails
Given the game has started,
  and my Pacman is next to a cell containing a wall;
When  I press an arrow key towards that cell;
Then  the move is not conducted.
Check S2.3 Done.

Scenario S2.4: The player dies
Given the game has started,
 and  my Pacman is next to a cell containing a ghost;
When  I press an arrow key towards that square;
Then  my Pacman dies,
 and  the game is over.
Check S2.4 Done.
  
Scenario S2.5: Player wins, extends S2.1
When  I have eaten the last pellet;
Then  I win the game.
Check S2.5 Done.
```
