import tictactoe.Board.{BoardPresenter, Board}
import tictactoe.Game.Players.PlayerFactory
import tictactoe._

object Main extends {
  def main(args: Array[String]) = {
    val board = new Board(3)
    val boardStructure = board.spaces
    val presenter = new BoardPresenter(boardStructure)
    val UI = new ConsoleUI(args)
    val playerTokens = UI.populateTokens()
    val rules = new TicTacToeRules(boardStructure)
    val numOfPlayers = UI.playerTotal
    val ticTacToeGame = new TicTacToeGame(rules, boardStructure, presenter, playerTokens)
    val factory = new PlayerFactory(boardStructure, rules, board, ticTacToeGame)
    val players = factory.getPlayers(numOfPlayers)
    val loop = new GameLoop(ticTacToeGame, players)

    loop.run()
  }
}