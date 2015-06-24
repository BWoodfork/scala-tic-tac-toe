import tictactoe.board.{BoardPresenter, Board}
import tictactoe.Game.Players.PlayerFactory
import tictactoe._
import tictactoe.consoleUI.ConsoleUI

object Main extends {
  def main(args: Array[String]) = {
    val parser = new ArgsParser(args)
    val board = new Board(3)
    val boardStructure = board.spaces
    val presenter = new BoardPresenter(boardStructure)
    val playerTokens = parser.getPlayerTokens
    val rules = new TicTacToeRules(boardStructure)
    val numOfPlayers = parser.playerTotal
    val ticTacToeGame = new TicTacToeGame(rules, board, presenter, playerTokens)
    val factory = new PlayerFactory(boardStructure, rules, board, ticTacToeGame)
    val players = factory.getPlayers(numOfPlayers)
    val loop = new GameLoop(ticTacToeGame, players)

    loop.run()
  }
}