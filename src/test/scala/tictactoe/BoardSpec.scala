package tictactoe

import org.scalatest.{OneInstancePerTest, Matchers, FunSpec}

class BoardSpec extends FunSpec with Matchers with OneInstancePerTest {

  describe("Board") {
    describe("3x3 grid") {
      val board = new Board(3)
      
      it("has a 3x3 grid when given an a size of 3") {

        assert(board.spaces.size == 9)
      }
      
      it("has a 4x4 grid when given an a size of 4") {
        val board = new Board(4)
        
        assert(board.spaces.size == 16)
      }

      it("fills a space, given an 'X' token and a 0 index") {
        board.fillSpace(0, "X") should be(Array("X", "-", "-",
                                                "-", "-", "-",
                                                "-", "-", "-"))
      }

      it("fills a space, given an 'O' token and a 1 index") {
        board.fillSpace(1, "O") should be(Array("-", "O", "-",
                                                "-", "-", "-",
                                                "-", "-", "-"))
      }

      it("returns true if a space is filled") {
        board.fillSpace(0, "X")

        assert(board.spaceFilled_?(0))
      }

      it("returns false if space is not filled") {
        board.fillSpace(1, "O")

        assert(!board.spaceFilled_?(0))
      }

      it("returns true when board count is odd") {

        assert(board.oddNumberEmptySpaces_?)
      }

      it("returns false when board count is even") {
        board.fillSpace(0, "X")

        assert(!board.oddNumberEmptySpaces_?)
      }

      it("returns true if spot on board is empty") {
        assert(board.spotEmpty_?(0, "X"))
      }

      it("returns false if spot on board is not empty") {
        board.fillSpace(0, "X")

        assert(!board.spotEmpty_?(0, "X"))
      }

      it("returns true if all spaces are filled with tokens") {
        board.fillSpace(0, "X")
        board.fillSpace(1, "X")
        board.fillSpace(2, "X")
        board.fillSpace(3, "X")
        board.fillSpace(4, "X")
        board.fillSpace(5, "X")
        board.fillSpace(6, "X")
        board.fillSpace(7, "X")
        board.fillSpace(8, "X")
        
        assert(board.allSpacesFilled_?())
      }
      
      it("returns false if all spaces are not filled with tokens") {
        board.fillSpace(1, "X")
        board.fillSpace(2, "X")
        board.fillSpace(3, "X")
        board.fillSpace(4, "X")
        board.fillSpace(5, "X")
        board.fillSpace(6, "X")
        board.fillSpace(7, "X")
        board.fillSpace(8, "X")

        assert(!board.allSpacesFilled_?())
      }

      it("returns a collection of empty spaces") {
        board.fillSpace(0, "O")
        board.fillSpace(1, "O")
        board.fillSpace(2, "O")
        board.fillSpace(3, "X")
        board.fillSpace(4, "X")
        board.fillSpace(5, "X")

        board.emptySpaces() should be (Array(6, 7, 8))
      }

      it("returns a collection of empty spaces for 5 and 6") {
        board.fillSpace(4, "X")
        board.fillSpace(5, "X")
        board.fillSpace(6, "X")
        board.fillSpace(7, "X")
        board.fillSpace(8, "X")

        board.emptySpaces() should be (Array(0, 1, 2, 3))
      }
    }
  }
}