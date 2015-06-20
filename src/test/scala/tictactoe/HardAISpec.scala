package tictactoe

import org.scalatest.{Matchers, FunSpec}

import scala.collection.mutable.ArrayBuffer

class HardAISpec extends FunSpec with Matchers {

  val tokens = ArrayBuffer[String]("X", "O")
  
  describe("HardAI") {
    it("it returns the first move, given an empty board") {
      val boardStructure = Array("-", "-", "-",
                                 "-", "-", "-",
                                 "-", "-", "-")

      val rules = new TicTacToeRules(boardStructure, tokens)
      val board = new Board(3)
      val token = "X"
      val ai = new HardAI(rules, board, token)

      assert(ai.getMove(boardStructure, token) == 8)
    }

    it("makes a corner move after center move has been taken first") {
      val boardStructure = Array("-", "-", "-",
                                 "-", "O", "-",
                                 "-", "-", "-")

      val rules = new TicTacToeRules(boardStructure, tokens)
      val board = new Board(3)
      val token = "X"
      val ai = new HardAI(rules, board, token)

      assert(ai.getMove(boardStructure, token) == 8)
    }

    it("takes the corner when dual win option avaialable") {
      val boardStructure = Array("-", "-", "X",
                                 "O", "X", "-",
                                 "O", "-", "-")

      val rules = new TicTacToeRules(boardStructure, tokens)
      val board = new Board(3)
      val token = "X"
      val ai = new HardAI(rules, board, token)

      assert(ai.getMove(boardStructure, token) == 0)
    }

    it("should return the move to win the game") {
      val boardStructure = Array("X", "O", "X",
                                 "X", "O", "-",
                                 "-", "-", "-")

      val rules = new TicTacToeRules(boardStructure, tokens)
      val board = new Board(3)
      val token = "X"
      val ai = new HardAI(rules, board, token)

      assert(ai.getMove(boardStructure, token) == 7)
    }

    it("should return the move to tie the game") {
      val boardStructure = Array("X", "O", "X",
                                 "X", "O", "O",
                                 "O", "X", "-")
      val rules = new TicTacToeRules(boardStructure, tokens)
      val board = new Board(3)
      val token = "X"
      val ai = new HardAI(rules, board, token)

      assert(ai.getMove(boardStructure, token) == 8)
    }
  }
}
