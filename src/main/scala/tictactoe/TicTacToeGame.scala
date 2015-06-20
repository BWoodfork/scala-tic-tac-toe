package tictactoe

class TicTacToeGame(rules: TicTacToeRules, presenter: BoardPresenter) extends Game {
  
  def updateBoard(index: Int, token: String, boardStructure: Array[String]) = {
    try {
      boardStructure.update(index, token)
    } catch {
      case ex: ArrayIndexOutOfBoundsException => {
        UI.sendMessage(UIMessages.InvalidLength)
      }
    }
    boardStructure
  }

  override def isRunning(dataStructure: Array[String]): Boolean = {
    !rules.gameOver_?(dataStructure)
  }

  override def renderBoard(boardStructure: Array[String]): Unit = {
    presenter.present(boardStructure)
  }

  override def currentToken(dataStructure: Array[String]): String = {
    rules.currentTurn_?()
  }

  override def validMove_?(index: Int): Boolean = {
    rules.validMove_?(index)
  }
}