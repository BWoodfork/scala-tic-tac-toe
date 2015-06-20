import tictactoe._

object Hi extends {
  def main(args: Array[String]) = {
    val board = new Board(3)
    val boardStructure = board.spaces
    val presenter = new BoardPresenter(board.spaces)
    val UI = new UI
    val playerTokens = UI.populateTokens()
    val rules = new TicTacToeRules(board.spaces, playerTokens)
    val factory = new PlayerFactory(board, rules)
    val numOfPlayers = UI.playerTotal
    val players = factory.getPlayers(numOfPlayers, playerTokens)
    val ticTacToeGame = new TicTacToeGame(rules, presenter)
    val loop = new GameLoop(ticTacToeGame, boardStructure, players)

    loop.run()
  }
}