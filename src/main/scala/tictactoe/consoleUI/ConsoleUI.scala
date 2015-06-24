package tictactoe.consoleUI

import scala.io.StdIn

object ConsoleUI {
  def sendMessage(message: String) = {
    println(message)
  }

  def getInput() = StdIn.readLine()
}