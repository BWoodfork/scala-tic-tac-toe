package tictactoe.Game.Players

import tictactoe.Board.Board
import tictactoe.{Game, TicTacToeRules}

class HardAI(rules: TicTacToeRules, board: Board, boardStructure: Array[String], game: Game) extends GamePlayer {

  private var _moveNumber = 0

  override def getMove(): Int = {

    def miniMax(depth: Int = 0): Int = {
      val scores = scala.collection.mutable.Map[Int, Int]()

      if (rules.tieGame_?(boardStructure)) return 0
      if (rules.gameOver_?(boardStructure)) return -1

      for (space <- board.emptySpaces(boardStructure)) {
        board.fillSpace(space, game.currentToken(), boardStructure)
        scores(space) = -1 * miniMax(1 + depth)
        boardStructure(space) = "-"
      }

      val bestSpace = scores.maxBy(_._2)._1
      val bestScoredSpace = scores.maxBy(_._2)._2

      if (depth == 0) {
        _moveNumber = bestSpace
      } else {
        _moveNumber = bestScoredSpace
      }

      _moveNumber
    }

    miniMax()
    _moveNumber
  }
}