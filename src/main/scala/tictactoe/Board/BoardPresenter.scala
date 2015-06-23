package tictactoe.board

import tictactoe.consoleUI.{ConsoleUI, UIMessages}

class BoardPresenter(boardStructure: Array[String]) {

  val boardSize = math.sqrt(boardStructure.size).toInt
  
  def makeRows(index: Int) = {
    val sqrtOfBoard = math.sqrt(boardStructure.size).toInt
    val builder = new StringBuilder

    if (index % sqrtOfBoard == 0 && index != 0) {
      builder.append("\n" + ("---" * sqrtOfBoard) + "\n")
    } else if (index == 0) {
      builder.append("")
    } else builder.append(" | ")

    builder.toString()
  }

  def displaySpot(index: Int, spot: String) = {
    if (spot == "-") index.toString else spot
  }

  def formatBoard(boardStructure: Array[String]): String = {
    val builder = new StringBuilder
    
    boardStructure.zipWithIndex.foreach{ case(spot, index) => builder.append(makeRows(index).concat(displaySpot(index, spot)))}
    builder.toString()
  }

  def present(boardState: Array[String], token: String) = {
    ConsoleUI.sendMessage(UIMessages.ShortNewLines)
    ConsoleUI.sendMessage(UIMessages.colorStringYellow(UIMessages.VerticalLine) + "\n")
    ConsoleUI.sendMessage(currentTurn(token))
    
    ConsoleUI.sendMessage(formatBoard(boardStructure))
    
    ConsoleUI.sendMessage(UIMessages.colorStringYellow(UIMessages.VerticalLine) + "\n")
    ConsoleUI.sendMessage(UIMessages.colorStringBlue(UIMessages.NumberedSpace))
    ConsoleUI.sendMessage(UIMessages.BigNewLines)
  }

  private def currentTurn(token: String) = {
    "PLAYER  " + token + "  IT'S YOUR TURN\n"
  }
}