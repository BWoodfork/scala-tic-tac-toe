package tictactoe

import scala.collection.mutable.ArrayBuffer

class Board(size: Int) {

  val boardState = ArrayBuffer.fill(size * size)("-")

  def spaces = boardState

  def spaceFilled_?(spot: Int) = {
    boardState(spot) != "-"
  }
  
  def fillSpace(index: Int, token: String) = {
    boardState.update(index, token)
    boardState
  }
  
  def oddNumberEmptySpaces_? = {
    spaces.count(_ == "-") % 2 != 0
  }
  
  def spotEmpty_?(index: Int, token: String) = {
    spaces(index) == "-"
  }

  def allWinningIndexCombinations() = {
    rowIndices() ++ columnIndices() ++ leftAndRightDiagonalIndices
  }

  def allSpacesFilled_?() = {
    spaces.forall(_ != "-")
  }
  
  private def rowIndices() = {
    spaces.indices.toArray.grouped(size).toArray
  }
  
  private def columnIndices() = {
    val groupedIndices = indices().grouped(size)

    transpose_indices(groupedIndices.toArray)
  }

  private def leftAndRightDiagonalIndices =
    Array(leftDiagonalIndices(), rightDiagonalIndices())
  
  private def leftDiagonalIndices() = {
    indices().groupBy(_ % (size + 1) == 0)(true)
  }

  private def rightDiagonalIndices() = {
    val indicesWithoutLast = indices().init
    indicesWithoutLast.groupBy(_ % (size - 1) == 0)(true).tail
  }

  private def indices() = {
    spaces.indices.toArray
  }
  
  private def transpose_indices(collection: Array[Array[Int]]) = {
    collection.transpose
  }
}