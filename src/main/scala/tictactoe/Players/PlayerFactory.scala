package tictactoe.Game.Players

import tictactoe.board.Board
import tictactoe.{Game, TicTacToeRules}

class PlayerFactory(boardStructure: Array[String], rules: TicTacToeRules, board: Board, game: Game) {

  def getPlayers(numberOfPlayers: Int): Array[GamePlayer] = numberOfPlayers match {
    case 2 => Array[GamePlayer](new User(), new User())
    case 1 => Array[GamePlayer](new User(), new HardAI(rules, board, boardStructure, game))
  }
}