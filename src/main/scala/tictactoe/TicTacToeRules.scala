package tictactoe

class TicTacToeRules(board: Board, tokens: Array[String]) {

  def validMove_?(index: Int, token: String) = {
    board.spotEmpty_?(index, token)
  }

  def currentTurn_?() = {
    if (board.oddNumberEmptySpaces_?) tokens(0) else tokens(1)
  }

  def winningToken(token: String) = {
    if (gameWinner_?(token)) token else null
  }

  def gameOver_?(token: String) = {
    tieGame_?(token) || gameWinner_?(token)
  }

  def tieGame_?(token: String) = {
    board.allSpacesFilled_?() && !gameWinner_?(token)
  }

  def gameWinner_?(token: String) = {
    rowWinner_?(token) || columnWinner_?(token) || diagonalWinner_?(token)
  }

  private def rowWinner_?(token: String) = {
    board.rowIndices()
      .exists(rowIndex => rowIndex.forall(index => (board.spaces()(index) == token) ||
      (board.spaces()(index) == token)))
  }

  private def columnWinner_?(token: String) = {
    board.columnIndices()
      .exists(columnIndex => columnIndex.forall(index => board.spaces()(index) == token))
  }

  private def diagonalWinner_?(token: String) = {
    board.getAllDiagonalIndices
      .exists(diagonalIndex => diagonalIndex.forall(index => board.spaces()(index) == token))
  }
}