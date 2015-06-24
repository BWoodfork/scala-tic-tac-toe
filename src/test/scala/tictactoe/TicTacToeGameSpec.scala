package tictactoe

import org.scalatest.FunSpec
import tictactoe.board.{BoardPresenter, Board}

import scala.collection.mutable.ArrayBuffer

class TicTacToeGameSpec extends FunSpec {
  describe("Tic-Tac-Toe-Game") {
    it("returns first token when board count is odd") {
      val boardStructure = Array("-", "-", "-",
                                 "-", "-", "-",
                                 "-", "-", "-")
      val tokens = Array[String]("X", "O")
      val presenter = new BoardPresenter(boardStructure)
      val board = new Board(3)
      val rules = new TicTacToeRules(boardStructure)
      val game = new TicTacToeGame(rules, board, presenter, tokens)

      assert(game.currentToken().contains("X"))
    }

    it("returns second token when board count is even") {
      val boardStructure = Array("X", "O", "-")

      val tokens = Array[String]("O", "X")
      val presenter = new BoardPresenter(boardStructure)
      val rules = new TicTacToeRules(boardStructure)
      val board = new Board(3)
      val game = new TicTacToeGame(rules, board, presenter, tokens)

      assert(game.currentToken().contains("O"))
    }
  }
}