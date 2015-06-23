package tictactoe

import tictactoe.Game.Players.GamePlayer
import tictactoe.consoleUI.{ConsoleUI, UIMessages}

import scala.util.control.Breaks._

class GameLoop(game: Game, players: Array[GamePlayer]) {

  def run() = {
    val helper = new GameLoopHelper(players)

    while (game.isRunning) {
      game.renderBoard()

      try {
        breakable(
          while (true) {
            _move = helper.currentPlayer(helper.incrementerValue).getMove()

            if(game.validMove_?(_move)) {
              break()
            } else
              game.renderBoard()
            ConsoleUI.sendMessage(UIMessages.InvalidMove)
          }
        )
        game.updateBoard(_move, game.currentToken())
        helper.takeTurn()

      } catch {
        case ex: NumberFormatException => {
          ConsoleUI.sendMessage(UIMessages.Int)
        }
      }
    }

    game.renderBoard()
    ConsoleUI.sendMessage(UIMessages.WinningToken + game.winningToken)
  }

  private var _move = 0
}
