package tictactoe

class HardAI(rules: TicTacToeRules, board: Board, token: String) extends GamePlayer {

  var _moveNumber = 0
 
  override def getMove(boardStructure: Array[String], token: String): Int = {
    
    def miniMax(boardStructure: Array[String], depth: Int = 0): Int = {
      val scores = scala.collection.mutable.Map[Int, Int]()

      if (rules.tieGame_?(boardStructure)) return 0
      if (rules.gameOver_?(boardStructure)) return -1

      for (space <- board.emptySpaces(boardStructure)) {
        board.fillSpace(space, rules.currentTurn_?(), boardStructure)
        scores(space) = -1 * miniMax(boardStructure, 1 + depth)
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
    
    miniMax(boardStructure)
    _moveNumber
  }
}