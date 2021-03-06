### Scala Tic-Tac-Toe
This is an unbeatable Tic-Tac-Toe game written in Scala.

The game provides the option to play human vs human or human vs computer.

The computer's moves are based off of the MiniMax algorithm.

Meaning it will either win the game or force a tie. Based on the state of the board.

### Dependencies
Install the SBT build tool.
`brew install sbt`

Install Scala
`brew install scala`

Install Java
`brew install java 8` [Optional]

Java 8 is recommended, but the game should run on Java 7 as well.

To check your java version, `java -version` from the console.

### Setup

While in the terminal window

`git clone` the `game-thingy` repo

`cd/` into the root directory `game-thingy`

Boot up SBT:

`sbt`

### Run Tic-Tac-Toe Game
After SBT has booted up. To play a game (while in the SBT console window), enter `run` followed by the number of players and the player tokens.

Example Commands:

`run 1 o x`  [To play against the unbeatable AI]

`run 2 o x`  [To play a human vs human game]

The number indicates the number of players playing the game. The first token has the first move. You can substitute the `x` or `o` tokens with any other letters you wish as well.

### Run Unit Tests

Boot up SBT [If it is not currently running]:

`sbt`

Run Specs:

`test`

To run specs in Intellij, right click on the `test/scala` directory and click `Run Scalatests`.
