package tictactoe.board

import tictactoe.consoleUI.{ConsoleUI, UIMessages}

import scala.collection.mutable.ArrayBuffer

class Board(size: Int) {

  private val boardState = Array.fill(size * size)("-")

  def spaces = boardState

  def spaceFilled_?(spot: Int, boardStructure: Array[String]) = {
    boardStructure(spot) != "-"
  }

  def fillSpace(index: Int, token: String, boardStructure: Array[String]) = {
    try {
      boardStructure.update(index, token)
    } catch {
      case ex: ArrayIndexOutOfBoundsException => {
        ConsoleUI.sendMessage(UIMessages.InvalidLength)
      }
    }
    boardStructure
  }

  def oddNumberEmptySpaces_?(boardStructure: Array[String]) = {
    boardStructure.count(_ == "-") % 2 != 0
  }

  def spotEmpty_?(index: Int, boardStructure: Array[String]) = {
    boardStructure(index) == "-"
  }

  def allSpacesFilled_?(boardStructure: Array[String]) = {
    boardStructure.forall(_ != "-")
  }

  def emptySpaces(boardStructure: Array[String]) = {
    val values = new ArrayBuffer[Int]()

    boardStructure.zipWithIndex.foreach{ case(x, i) => if (x == "-") values += i }
    values
  }
}
