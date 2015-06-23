###Scala Tic-Tac-Toe
This is my unbeatable Tic-Tac-Toe game written in Scala.

The game provides the option to play human vs human or human vs computer.

The computer's moves are based off of the MiniMax algorithm.

Meaning it will either win the game or force a tie. Based on the state of the board.

###Dependencies
Install the SBT build tool.
`brew install sbt`

Install Scala
`brew install scala`

Install Java
`brew install java 8` [Optional]

Java 8 is recommended, but the game should run on Java 7 as well.

To check your java version, `java -version` from the console.

###Setup
`git clone this repository`

###Boot Up The SBT build tool
From the console, in the root directory of `/game-thingy`, boot up SBT from console with the command `sbt`

###Run Tic-Tac-Toe Game
Once SBT is running, enter one of these commands from within the SBT console window:

Enter the command: `run 1` [To play against the unbeatable AI]

Enter the command: `run 2` [To play a human vs human game]

###Run Unit Tests
While SBT is running, enter the command `test`, from SBT's console window.

To run specs in Intellij, right click on the `test/scala` directory and click `Run Scalatests`.
