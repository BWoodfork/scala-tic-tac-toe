package tictactoe

import scala.collection.mutable.ArrayBuffer

class Board(size: Int) {
  val boardState = ArrayBuffer.fill(size * size)("-")

  def spaces() = boardState

  def spaceFilled_?(spot: Int) = {
    boardState(spot) != "-"
  }
  
  def fillSpace(index: Int, token: String) = {
    boardState.update(index, token)
    boardState
  }
  
  def oddNumberEmptySpaces_? = {
    boardState.count(_ == "-") % 2 != 0
  }
  
  def spotEmpty_?(index: Int, token: String) = {
    boardState(index) == "-"
  }

  def rowIndices() = {
    boardState.indices.grouped(size).toArray
  }
  
  def columnIndices() = {
    val groupedIndices = indices().grouped(size)

    transpose_indices(groupedIndices.toArray)
  }

  def getAllDiagonalIndices = 
    Array(leftDiagonalIndices(), rightDiagonalIndices())

  private def leftDiagonalIndices() = {
    indices().groupBy(_ % (size + 1) == 0)(true)
  }

  private def rightDiagonalIndices() = {
    val indicesWithoutLast = indices().init
    indicesWithoutLast.groupBy(_ % (size - 1) == 0)(true).tail
  }

  private def indices() = {
    boardState.indices.toArray
  }
  
  private def transpose_indices(collection: Array[Array[Int]]) = {
    collection.transpose
  }
}