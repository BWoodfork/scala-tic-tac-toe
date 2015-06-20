package tictactoe

abstract class Game {
  def renderBoard(boardStructure: Array[String])
  def isRunning(dataStructure: Array[String]): Boolean
  def updateBoard(index: Int, token: String, boardStructure: Array[String]): Array[String]
  def currentToken(dataStructure: Array[String]): String
  def validMove_?(index: Int): Boolean
}