package tictactoe.consoleUI

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn
import scala.util.control.Breaks._

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

    if (_numberOfPlayers == 1) {
      populateSinglePlayerTokens(playerTokens)
    } else if (_numberOfPlayers == 2) {
      populateSinglePlayerTokens(playerTokens)
      populateTwoPlayerTokens(playerTokens)
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
  
  private def populateSinglePlayerTokens(playerTokens: ArrayBuffer[String]) = {
    while (playerTokens.size < 1){
      ConsoleUI.sendMessage(UIMessages.Player1Token)

      breakable(
        while (true) {
          _token1 = ConsoleUI.getInput().toUpperCase()

          if (validTokenLength_?(_token1)) {
            playerTokens += _token1
            break()
          }
        }
      )
      if (_numberOfPlayers == 1) playerTokens += getComputerToken(playerTokens(0))
    }
  }

  private def populateTwoPlayerTokens(playerTokens: ArrayBuffer[String]) = {
    while (playerTokens.size < 2) {
      ConsoleUI.sendMessage(UIMessages.Player2Token)
      _token2 = ConsoleUI.getInput().toUpperCase()
      
      if (validTokenLength_?(_token2) && !tokenExists_?(playerTokens, _token2)) {
        playerTokens += _token2
      }
    }
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
  private var _token1 = ""
  private var _token2 = ""
}
