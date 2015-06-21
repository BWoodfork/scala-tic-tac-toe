package tictactoe

import tictactoe.Game

class TestGame extends Game {
  override def renderBoard(): Unit = ???

  override def validMove_?(index: Int): Boolean = ???

  override def isRunning(): Boolean = ???

  override def updateBoard(index: Int, token: String): Array[String] = ???

  override def currentToken(): String = ???

  override def winningToken(): String = ???
}