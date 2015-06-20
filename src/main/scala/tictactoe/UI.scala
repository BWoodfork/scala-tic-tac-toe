package tictactoe

import scala.collection.mutable.ArrayBuffer

object UI {
  def sendMessage(message: String) = {
    println(message)
  }
}

class UI {
  
  def playerTotal = _numberOfPlayers

  def populateTokens() = {
    val playerTokens = ArrayBuffer[String]()
    
    numberOfPlayers_=(getNumberOfPlayers)

    while (playerTokens.size < 1){
      UI.sendMessage(UIMessages.Player1Token)
      val token1 = Console.readLine().toUpperCase()
      if (validTokenLength_?(token1)) playerTokens += token1
      if (_numberOfPlayers == 1) playerTokens += getComputerToken(token1)
    }
    
    UI.sendMessage(UIMessages.Player2Token)

    while (playerTokens.size < 2) {
      val token2 = Console.readLine().toUpperCase()
      if (validTokenLength_?(token2) && !tokenExists_?(playerTokens, token2)) {
        playerTokens += token2
      }
    }
    
    playerTokens
  }

  def tokenExists_?(playerTokens: ArrayBuffer[String], token: String) = {
    if (playerTokens.contains(token)) {
      UI.sendMessage(UIMessages.TokenTaken)
      true
    } else false
  }

  def validTokenLength_?(token: String) = {
    if (token.size > 1) {
      UI.sendMessage(UIMessages.InvalidLength)
      false
    } else true
  }
  
  def numberOfPlayers_=(int:Int) = {
    _numberOfPlayers = int
  }
  
  private var _numberOfPlayers = 0

  private def getNumberOfPlayers = {
    UI.sendMessage(UIMessages.HowManyPlayers)
    Console.readLine().toInt
  }
  
  private def getComputerToken(token: String) = token match {
    case "X" => "O"
    case "O" => "X"
    case _ => "O"
  }
}