package tictactoe.Board

import tictactoe.{ConsoleUI, UIMessages}

import scala.collection.mutable.ArrayBuffer

class BoardPresenter(boardStructure: Array[String]) {

  def getIndicesOrTokens(board: Array[String]) = {
    val indicesAndTokens = new ArrayBuffer[String]

    board.indices.foreach(spotNum => if (board(spotNum) == "-") 
      indicesAndTokens += spotNum.toString else indicesAndTokens += board(spotNum))

    indicesAndTokens
  }

  def separateRows(boardState: Array[String]) = {
    val rootOfBoardSize = math.sqrt(boardState.size).toInt

    getIndicesOrTokens(boardState).grouped(rootOfBoardSize).toArray
  }

  def formatBoard(boardState: Array[String]) = {
    separateRows(boardState)
      .foreach(row => println(row(0) + " | " + row(1) + " | " + row(2) + "\n----------"))
  }

  def present(boardState: Array[String]) = {
    ConsoleUI.sendMessage(UIMessages.ShortNewLines)
    formatBoard(boardStructure)
    ConsoleUI.sendMessage(UIMessages.colorStringBlue(UIMessages.NumberedSpace))
    ConsoleUI.sendMessage(UIMessages.BigNewLines)
  }
}
