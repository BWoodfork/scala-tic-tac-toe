package tictactoe

import org.scalatest.{OneInstancePerTest, Matchers, FunSpec}

class BoardSpec extends FunSpec with Matchers with OneInstancePerTest {

  describe("Board") {
    describe("3x3 grid") {
      val board = new Board(3)
      
      it("has a 3x3 grid when given an a size of 3") {

        assert(board.spaces().size == 9)
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

      it("returns a collection of indices for all horizontal rows on 3x3 board") {
        board.rowIndices() should be (Array(Array(0, 1, 2),
                                            Array(3, 4, 5),
                                            Array(6, 7, 8)))
      }

      it("returns a collection of indices for all horizontal columns on board") {
        board.columnIndices() should be (Array(Array(0, 3, 6),
                                               Array(1, 4, 7),
                                               Array(2, 5, 8)))
      }

      it("returns collection of both diagonal indices") {
        board.getAllDiagonalIndices should be (Array(Array(0, 4, 8),
                                                     Array(2, 4, 6)))
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
    }

    describe("4x4 grid") {
      val board = new Board(4)
      
      it("has a 4x4 grid when given an a size of 4") {
        
        assert(board.spaces().size == 16)
      }

      it("returns a collection of indices for all vertical columns on 4x4 board") {
        board.rowIndices() should be (Array(Array(0, 1, 2, 3),
                                            Array(4, 5, 6, 7),
                                            Array(8, 9, 10, 11),
                                            Array(12, 13, 14, 15)))
      }

      it("returns collection of both diagonal indices on 4x4 board") {
        board.getAllDiagonalIndices should be (Array(Array(0, 5, 10, 15),
                                                     Array(3, 6, 9, 12)))
      }

      it("returns a collection of indices for all horizontal columns on 4x4 board") {
        board.columnIndices() should be (Array(Array(0, 4, 8, 12),
                                               Array(1, 5, 9, 13),
                                               Array(2, 6, 10, 14),
                                               Array(3, 7, 11, 15)))
      }
    }
  }
}