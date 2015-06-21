package tictactoe

import tictactoe.Game.Players.GamePlayer

class GameLoopHelper(players: Array[GamePlayer]) {

  def takeTurn() = {
    _playerIncrementer += 1
  }
  
  def incrementerValue = {
    _playerIncrementer
  }
  
  def currentPlayer(int: Int) = {
    if (int % 2 == 0) players(0) else players(1)
  }

  private var _playerIncrementer = 0
}