package tictactoe.Players

import org.scalatest.{FunSpec, Matchers}
import tictactoe.Board.{BoardPresenter, Board}
import tictactoe.Game.Players.HardAI
import tictactoe.{TicTacToeGame, TicTacToeRules}

import scala.collection.mutable.ArrayBuffer

class HardAISpec extends FunSpec with Matchers {

  val tokens = ArrayBuffer[String]("X", "O")
  val board = new Board(3)

  describe("HardAI") {
    it("it returns the first move, given an empty board") {
      val boardStructure = Array("-", "-", "-",
                                 "-", "-", "-",
                                 "-", "-", "-")

      val rules = new TicTacToeRules(boardStructure)
      val presenter = new BoardPresenter(boardStructure)
      val game = new TicTacToeGame(rules, boardStructure, presenter, tokens)
      val ai = new HardAI(rules, board, boardStructure, game)


      assert(ai.getMove() == 8)
    }

    it("makes a corner move after center move has been taken first") {
      val boardStructure = Array("-", "-", "-",
                                 "-", "O", "-",
                                 "-", "-", "-")

      val rules = new TicTacToeRules(boardStructure)
      val presenter = new BoardPresenter(boardStructure)
      val game = new TicTacToeGame(rules, boardStructure, presenter, tokens)
      val ai = new HardAI(rules, board, boardStructure, game)


      assert(ai.getMove() == 8)
    }

    it("takes the corner when dual win option available") {
      val boardStructure = Array("-", "-", "X",
                                 "O", "X", "-",
                                 "O", "-", "-")

      val rules = new TicTacToeRules(boardStructure)
      val presenter = new BoardPresenter(boardStructure)
      val game = new TicTacToeGame(rules, boardStructure, presenter, tokens)
      val ai = new HardAI(rules, board, boardStructure, game)


      assert(ai.getMove() == 8)
    }

    it("should return the move to win the game") {
      val boardStructure = Array("X", "O", "X",
                                 "X", "O", "-",
                                 "-", "-", "-")

      val rules = new TicTacToeRules(boardStructure)
      val presenter = new BoardPresenter(boardStructure)
      val game = new TicTacToeGame(rules, boardStructure, presenter, tokens)
      val ai = new HardAI(rules, board, boardStructure, game)


      assert(ai.getMove() == 8)
    }

    it("should return the move to tie the game") {
      val boardStructure = Array("X", "O", "X",
                                 "X", "O", "O",
                                 "O", "X", "-")

      val rules = new TicTacToeRules(boardStructure)
      val presenter = new BoardPresenter(boardStructure)
      val game = new TicTacToeGame(rules, boardStructure, presenter, tokens)
      val ai = new HardAI(rules, board, boardStructure, game)

      assert(ai.getMove() == 8)
    }
  }
}
