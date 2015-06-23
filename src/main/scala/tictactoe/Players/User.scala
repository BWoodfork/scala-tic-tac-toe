package tictactoe.Game.Players

import tictactoe.consoleUI.ConsoleUI

class User() extends GamePlayer {
  def getMove() = {
    ConsoleUI.getInput().toInt
  }
}