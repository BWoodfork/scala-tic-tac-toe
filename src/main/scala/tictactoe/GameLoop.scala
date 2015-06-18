package tictactoe

class GameLoop(rules: TicTacToeRules, board: Board, boardPresenter: BoardPresenter) {

  def run() = {
    val boardSpaces = board.spaces
    
    while (!rules.gameOver_?(boardSpaces)) {
      boardPresenter.present(boardSpaces)
      
      try {
        val move = Console.readLine().toInt
        
        if (!rules.validMove_?(move)) {
          println("Move is invalid")
        } else
        
        board.fillSpace(move, rules.currentTurn_?())
      } catch {
        case ex: NumberFormatException => {
          println("Move must be an integer")
        }
      }
    }
  }
}