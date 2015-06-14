package tictactoe

import scala.collection.mutable.ArrayBuffer

class Board(size: Int) {
  val boardState = ArrayBuffer.fill(size * size)("-")

  def spaces() = boardState

  def space_filled_?(spot: Int) = {
    false
  }
  
  def fill_space(index: Int, token: String) = {
    boardState.update(index, token)
    boardState
  }
}