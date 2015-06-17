package tictactoe

import org.scalatest.FunSpec

class HardAISpec extends FunSpec {
  describe("HardAI") {
    it("should return the move to tie the game") {
      val tokens = Array[String]("X", "O")
      val winningCombos =
        Array(Array(0, 1, 2),
          Array(3, 4, 5),
          Array(6, 7, 8),
          Array(0, 3, 6),
          Array(1, 4, 7),
          Array(2, 5, 8),
          Array(0, 4, 8),
          Array(2, 4, 6))

      val dataStructure = Array("X", "O", "X",
                                "X", "O", "-",
                                "-", "-", "-")

      val rules = new TicTacToeRules(dataStructure, tokens, winningCombos)
      val ai = new HardAI(rules)
      assert(ai.minimax(dataStructure) == 7)
    }
    
    it("should return the winning move") {
      val tokens = Array[String]("X", "O")
      val winningCombos =
        Array(Array(0, 1, 2),
          Array(3, 4, 5),
          Array(6, 7, 8),
          Array(0, 3, 6),
          Array(1, 4, 7),
          Array(2, 5, 8),
          Array(0, 4, 8),
          Array(2, 4, 6))

      val dataStructure = Array("X", "O", "X",
                                "X", "O", "O",
                                "O", "X", "-")

      val rules = new TicTacToeRules(dataStructure, tokens, winningCombos)
      val ai = new HardAI(rules)
      assert(ai.minimax(dataStructure) == 8)
    }
  }
}
