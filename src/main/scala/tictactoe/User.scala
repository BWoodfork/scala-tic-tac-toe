package tictactoe

class User(board: Board, token: String) extends GamePlayer {
  override def getMove(boardStructure: Array[String], token: String) = {
    Console.readLine().toInt
  }
}