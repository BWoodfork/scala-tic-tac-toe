package tictactoe

import scala.collection.mutable.ArrayBuffer

class PlayerFactory(board: Board, rules: TicTacToeRules) {
  
  def getPlayers(numberOfPlayers: Int, token: ArrayBuffer[String]): Array[GamePlayer] = numberOfPlayers match {
    case 2 => Array[GamePlayer](new User(board, token(0)), new User(board, token(1)))
    case 1 => Array[GamePlayer](new User(board, token(0)), new HardAI(rules, board, token(1)))
    case _ => Array[GamePlayer](new HardAI(rules, board, token(0)), new HardAI(rules, board, token(1)))
  }
}