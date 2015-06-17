package tictactoe

class HardAI(ticTacToeRules: TicTacToeRules) {
  
  def minimax(dataStructure: Array[String], depth: Int = 0): Int = {
    val scores = scala.collection.mutable.Map[Int,Int]()
    
    if (ticTacToeRules.tieGame_?(dataStructure)) {
      return 0
    }
    
    if (ticTacToeRules.gameOver_?(dataStructure)) {
      return -1
    }
    
    for(space <- ticTacToeRules.emptySpaces(dataStructure)) {
      ticTacToeRules.fillSpace(space, ticTacToeRules.currentTurn_?(dataStructure), dataStructure)
      scores(space) = -1 * minimax(dataStructure, depth + 1)
      dataStructure(space) = "-"
    }

    val bestSpace = scores.maxBy(_._2)._1
    val bestScoredSpace = scores.maxBy(_._2)._1

    if (depth == 0) {
      bestSpace
    }

    bestScoredSpace
  }
}