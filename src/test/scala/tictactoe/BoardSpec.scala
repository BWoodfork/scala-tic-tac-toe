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
        val boardStructure = Array("-", "-", "-",
                                   "-", "-", "-", 
                                   "-", "-", "-")
        board.fillSpace(0, "X", boardStructure) should be(Array("X", "-", "-",
                                                                "-", "-", "-",
                                                                "-", "-", "-"))
      }

      it("fills a space, given an 'O' token and a 1 index") {
        val boardStructure = Array("-", "-", "-",
                                   "-", "-", "-",
                                   "-", "-", "-")
        
        board.fillSpace(1, "O", boardStructure) should be(Array("-", "O", "-",
                                                                "-", "-", "-",
                                                                "-", "-", "-"))
      }

      it("returns true if a space is filled") {
        val boardStructure = Array("X")

        assert(board.spaceFilled_?(0, boardStructure))
      }

      it("returns false if space is not filled") {
        val boardStructure = Array("-")

        assert(!board.spaceFilled_?(0, boardStructure))
      }

      it("returns true when board count is odd") {
        val boardStructure = Array("-")
        
        assert(board.oddNumberEmptySpaces_?(boardStructure))
      }

      it("returns false when board count is even") {
        val boardStructure = Array("X")

        assert(!board.oddNumberEmptySpaces_?(boardStructure))
      }

      it("returns true if spot on board is empty") {
        val boardStructure = Array("-")
        
        assert(board.spotEmpty_?(0, "X", boardStructure))
      }

      it("returns false if spot on board is not empty") {
        val boardStructure = Array("X")

        assert(!board.spotEmpty_?(0, "X", boardStructure))
      }

      it("returns true if all spaces are filled with tokens") {
        val boardStructure = Array("O", "X", "O",
                                   "X", "X", "O",
                                   "X", "O", "X")

        assert(board.allSpacesFilled_?(boardStructure))
      }

      it("returns false if all spaces are not filled with tokens") {
        val boardStructure = Array("O", "X", "O",
                                   "X", "X", "O",
                                   "X", "O", "-")

        assert(!board.allSpacesFilled_?(boardStructure))
      }

      it("returns a collection of empty spaces") {
        val boardStructure = Array("O", "X", "O",
                                   "X", "X", "O",
                                   "-", "-", "-")

        board.emptySpaces(boardStructure) should be (Array(6, 7, 8))
      }

      it("returns a collection of empty spaces for 0 and 1") {
        val boardStructure = Array("-", "-", "O",
                                   "X", "X", "O",
                                   "O", "O", "X")

        board.emptySpaces(boardStructure) should be (Array(0, 1))
      }
    }
  }
}