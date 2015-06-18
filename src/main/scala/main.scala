import tictactoe.{BoardPresenter, Board, TicTacToeRules, GameLoop}

object Hi extends {
  def main(args: Array[String]) = {
    println("Hello World!")

    val tokens = Array[String]("X", "O")
    val board = new Board(3)
    val presenter = new BoardPresenter(board.spaces)
    val rules = new TicTacToeRules(board.spaces, tokens)
    val loop = new GameLoop(rules, board, presenter)
    loop.run()
  }
}