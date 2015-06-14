package tictactoe

import org.scalatest.{Matchers, FunSpec}

class BoardSpec extends FunSpec with Matchers {
  describe("Board") {
    it("has a 3x3 grid when given an a size of 3") {
      val board = new Board(3)
      assert(board.spaces().size == 9)
    }
    
    it("has a 4x4 grid when given an a size of 4") {
      val board = new Board(4)
      assert(board.spaces().size == 16)
    }

    it("fills a space, given a token and an index") {
      val board = new Board(3)
      board.fill_space(0, "X") should be (Array("X", "-", "-",
                                                "-", "-", "-",
                                                "-", "-", "-"))
    }
    
    it("returns true if a space is filled") {
     val board = new Board(3) 
      board.fill_space(0, "X")
      assert(board.space_filled_?(0) == true)
    }
  }
}