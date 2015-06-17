package tictactoe

import scala.collection.mutable.ArrayBuffer

class BoardPresenter(boardStructure: Array[String]) {

  def getIndicesOrTokens(board: Array[String]) = {
    val indicesAndTokens = new ArrayBuffer[String]
    
    for(spotNum <- board.indices) {
      if (board(spotNum) == "-")
        indicesAndTokens += spotNum.toString
      else indicesAndTokens += board(spotNum)
    }
    
    indicesAndTokens
  }

  def separateRows(boardState: Array[String]) = {
    val rootOfBoardSize = math.sqrt(boardState.size).toInt
    
    getIndicesOrTokens(boardState).grouped(rootOfBoardSize).toArray
  }

  def present(boardState: Array[String]) = {
    separateRows(boardState)
      .foreach(row => println(row(0) + " | " + row(1) + " | " + row(2) + "\n----------"))
  }
}