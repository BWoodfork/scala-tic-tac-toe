package tictactoe

class GameLoop(game: Game, boardStructure: Array[String], players: Array[GamePlayer]) {

  def run() = {
    val helper = new GameLoopHelper(players)
    while (game.isRunning(boardStructure)) {
      game.renderBoard(boardStructure)
      try {
        val move = helper.currentPlayer(helper.incrementerValue).getMove(boardStructure, game.currentToken(boardStructure))
        game.updateBoard(move, game.currentToken(boardStructure), boardStructure)
        
        if(!game.validMove_?(move)) {
        } else game.updateBoard(move, game.currentToken(boardStructure), boardStructure)
        helper.takeTurn
        
      } catch {
        case ex: NumberFormatException => {
          UI.sendMessage(UIMessages.Int)
        }
      }
    }

    game.renderBoard(boardStructure)
  }
}