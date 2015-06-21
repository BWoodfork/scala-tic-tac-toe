package tictactoe.Game.Players

import tictactoe.ConsoleUI

class User() extends GamePlayer {
  def getMove() = {
    ConsoleUI.getInput().toInt
  }
}