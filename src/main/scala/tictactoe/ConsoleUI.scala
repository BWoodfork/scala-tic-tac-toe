package tictactoe

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object ConsoleUI {
  def sendMessage(message: String) = {
    println(message)
  }

  def getInput() = StdIn.readLine()
}

class ConsoleUI(args: Array[String]) {

  def playerTotal = _numberOfPlayers

  def populateTokens() = {
    val playerTokens = ArrayBuffer[String]()

    numberOfPlayers_=(args.head.toInt)

    ConsoleUI.sendMessage(UIMessages.BigNewLines)
    
    while (playerTokens.size < 1){
      ConsoleUI.sendMessage(UIMessages.Player1Token)
      val token1 = ConsoleUI.getInput().toUpperCase()
      if (validTokenLength_?(token1)) playerTokens += token1
      if (_numberOfPlayers == 1) playerTokens += getComputerToken(token1)
    }

    while (playerTokens.size < 2) {
      ConsoleUI.sendMessage(UIMessages.Player2Token)
      val token2 = ConsoleUI.getInput().toUpperCase()
      if (validTokenLength_?(token2) && !tokenExists_?(playerTokens, token2)) {
        playerTokens += token2
      }
    }

    playerTokens
  }

  def tokenExists_?(playerTokens: ArrayBuffer[String], token: String) = {
    if (playerTokens.contains(token)) {
      ConsoleUI.sendMessage(UIMessages.TokenTaken)
      true
    } else false
  }

  def validTokenLength_?(token: String) = {
    if (token.size > 1 || token.isEmpty) {
      ConsoleUI.sendMessage(UIMessages.InvalidLength)
      false
    } else true
  }

  private def numberOfPlayers_=(int:Int) = {
    _numberOfPlayers = int
  }

  private def getComputerToken(token: String) = token match {
    case "X" => "O"
    case "O" => "X"
    case _ => "O"
  }

  private var _numberOfPlayers = 0
}
