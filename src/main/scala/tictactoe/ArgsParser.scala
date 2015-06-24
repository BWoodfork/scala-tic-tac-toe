package tictactoe

import tictactoe.consoleUI.UIMessages

class ArgsParser(gameArgs: Array[String]) {

  def getPlayerTokens = {
    numberOfPlayers_=(gameArgs.head.toInt)

    validateTokens(formatTokens(gameArgs))

    formatTokens(gameArgs)
  }

  def validateTokens(tokens: Array[String]) = {
    if (tokens(0) == tokens(1)) throw new InvalidTokenException(UIMessages.TokenExists)
    if (tokens(0).size > 1 || tokens(1).size > 1) throw new InvalidTokenException(UIMessages.InvalidLength)
  }

  def playerTotal = _numberOfPlayers

  private def formatTokens(args: Array[String]) = {
    val capitalizedTokens = gameArgs.mkString(" ").drop(1).toUpperCase.trim

    capitalizedTokens.split(" ")
  }

  private def numberOfPlayers_=(int:Int) = {
    _numberOfPlayers = int
  }

  private var _numberOfPlayers = 0
}
