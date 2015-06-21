package tictactoe

object UIMessages {
  val InvalidMove = "The requested move is invalid, please choose another."
  val Int = "Your move must be an integer, please choose another."
  val Player1Token = "Player 1, please enter a letter as your chosen token.\n"
  val Player2Token = "Player 2, please enter a letter as your chosen token.\n"
  val InvalidLength = "Invalid token length. Please enter 1 character"
  val InvalidToken = "Invalid token type. Please enter a letter from the alphabet."
  val TokenTaken = "The requested token has already been chosen. Please choose another token."
  val HowManyPlayers = "How many players are playing this game?"
  val NoWinningToken = "There wasn't a winner this time =("
  val BigNewLines = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
  val ShortNewLines = "\n\n\n\n\n\n\n"
  val WinningToken = "GAME OVER. Congratulations to player => "
  val NumberedSpace = "ENTER A NUMBERED SPACE TO FILL IT WITH YOUR TOKEN"

  def colorStringBlue(token: String) = {
    Console.GREEN + token + Console.RESET
  }
  
  def colorStringRed(token: String) = {
    Console.RED + token + Console.RESET
  }
}