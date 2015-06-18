package tictactoe

import scala.collection.mutable.ArrayBuffer

class Board(size: Int) {

  val boardState = Array.fill(size * size)("-")

  def spaces = boardState

  def spaceFilled_?(spot: Int) = {
    boardState(spot) != "-"
  }
  
  def fillSpace(index: Int, token: String) = {
    try {
      spaces.update(index, token)
    } catch {
      case ex: ArrayIndexOutOfBoundsException => {
        println("Move is not within board's limits")
      }
      case ex: NumberFormatException => {
        println("Move must be an integer")
      }
    }
    spaces
  }

  def oddNumberEmptySpaces_? = {
    spaces.count(_ == "-") % 2 != 0
  }
  
  def spotEmpty_?(index: Int, token: String) = {
    spaces(index) == "-"
  }

  def allSpacesFilled_?() = {
    spaces.forall(_ != "-")
  }

  def emptySpaces() = {
    val values = new ArrayBuffer[Int]()

    spaces.zipWithIndex.foreach{ case(x, i) => if (x == "-") values += i }
    values
  }
}