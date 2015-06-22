package tictactoe

import tictactoe.Board.BoardPresenter

import scala.collection.mutable.ArrayBuffer

class TicTacToeGame(rules: TicTacToeRules, boardStructure: Array[String], presenter: BoardPresenter, tokens: ArrayBuffer[String]) extends Game {

  def updateBoard(index: Int, token: String) = {
    try {
      boardStructure.update(index, token)
    } catch {
      case ex: ArrayIndexOutOfBoundsException => {
        ConsoleUI.sendMessage(UIMessages.InvalidLength)
      }
    }
    boardStructure
  }

  override def isRunning: Boolean = {
    !rules.gameOver_?(boardStructure)
  }

  override def renderBoard(): Unit = {
    presenter.present(boardStructure)
  }

  override def currentToken(): String = {
    if (boardStructure.count(_ == "-") % 2 != 0) UIMessages.colorStringBlue(tokens(0)) else  UIMessages.colorStringRed(tokens(1))
  }

  override def validMove_?(index: Int): Boolean = {
    rules.validMove_?(index)
  }

  override def winningToken() = {
    rules.winningToken(boardStructure)
  }
}
