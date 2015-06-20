package tictactoe

trait GamePlayer {
  def getMove(boardStructure: Array[String], token: String): Int
}
