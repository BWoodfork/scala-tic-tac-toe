package tictactoe

class GameLoop(ticTacToeRules: TicTacToeRules, board: Board, boardPresenter: BoardPresenter) {

  def run() = {
    val boardSpaces = board.spaces
    
    while (!ticTacToeRules.gameOver_?(boardSpaces)) {
      boardPresenter.present(boardSpaces)
      try {
        board.fillSpace(Console.readInt(), ticTacToeRules.currentTurn_?(boardSpaces))
      } catch {
        case ex: NumberFormatException => {
          println("Move must be an integer")
        }
      }
    }
  }
}