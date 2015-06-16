package tictactoe

import scala.collection.mutable.ArrayBuffer

class BoardPresenter(boardStructure: ArrayBuffer[String]) {

  def getIndicesOrTokens(board: ArrayBuffer[String]) = {
    val indicesAndTokens = new ArrayBuffer[String]
    
    for(spotNum <- board.indices) {
      if (board(spotNum) == "-")
        indicesAndTokens += spotNum.toString
      else indicesAndTokens += board(spotNum)
    }
    
    indicesAndTokens
  }

  def separateRows(boardState: ArrayBuffer[String]) = {
    val rootOfBoardSize = math.sqrt(boardState.size).toInt
    
    getIndicesOrTokens(boardState).grouped(rootOfBoardSize).toArray
  }

  def present(boardState: ArrayBuffer[String]) = {
    separateRows(boardState)
      .foreach(row => println(row(0) + " | " + row(1) + " | " + row(2) + "\n----------"))
  }
}