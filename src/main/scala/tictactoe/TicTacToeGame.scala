package tictactoe

import tictactoe.board.{Board, BoardPresenter}
import tictactoe.consoleUI.UIMessages

import scala.collection.mutable.ArrayBuffer

class TicTacToeGame(rules: TicTacToeRules, board: Board, presenter: BoardPresenter, tokens: ArrayBuffer[String]) extends Game {

  def updateBoard(index: Int, token: String) = {
    board.fillSpace(index, token, boardStructure)
  }

  override def isRunning: Boolean = {
    !rules.gameOver_?(boardStructure)
  }

  override def renderBoard(): Unit = {
    presenter.present(boardStructure)
  }

  override def currentToken(): String = {
    if (board.oddNumberEmptySpaces_?(boardStructure)) UIMessages.colorStringBlue(tokens(0)) else UIMessages.colorStringRed(tokens(1))
  }

  override def validMove_?(index: Int): Boolean = {
    rules.validMove_?(index)
  }

  override def winningToken() = {
    rules.winningToken(boardStructure)
  }

  private val boardStructure = board.spaces
}
