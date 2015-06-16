package tictactoe

class EasyAI(board: Board, token: String) {

  def getMoveNumber() = {
    board.spaces.indexOf("-")
  }
}