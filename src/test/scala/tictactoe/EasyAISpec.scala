package tictactoe

import org.scalatest.{Matchers, FunSpec}

class EasyAISpec extends FunSpec with Matchers {
  describe("EasyAI") {
    it("makes a move at the first available space on board") {
      val board = new Board(3)
      val ai = new EasyAI(board, "X")
      board.fillSpace(0, "O")
      assert(ai.getMoveNumber() == 1)
    }
    
    it("makes a move at the last available space on board") {
      val board = new Board(3)
      val ai = new EasyAI(board, "X")

      board.fillSpace(0, "O")
      board.fillSpace(1, "O")
      board.fillSpace(2, "O")
      board.fillSpace(3, "O")
      board.fillSpace(4, "O")
      board.fillSpace(5, "O")
      board.fillSpace(6, "O")
      board.fillSpace(7, "O")
      
      assert(ai.getMoveNumber() == 8)
    }
  }
}