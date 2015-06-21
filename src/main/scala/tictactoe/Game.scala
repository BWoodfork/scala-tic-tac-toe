package tictactoe

abstract class Game {
  def renderBoard()
  def isRunning: Boolean
  def updateBoard(index: Int, token: String): Array[String]
  def currentToken(): String
  def validMove_?(index: Int): Boolean
  def winningToken(): String
}