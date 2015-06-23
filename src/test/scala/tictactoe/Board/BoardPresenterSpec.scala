package tictactoe.board

import org.scalatest.{FunSpec, Matchers}

class BoardPresenterSpec extends FunSpec with Matchers {
  describe("Board Presenter") {
    it("displays an empty string if spot is not empty") {
      val boardStructure = Array("X", "-", "O", "-", "-", "-", "-", "-", "-")
      val presenter = new BoardPresenter(boardStructure)
      
      assert(presenter.displaySpot(0, "-") == "0")
    }
    
    it("displays game tokens") {
      val boardStructure = Array("X", "-", "O", "-", "-", "-", "-", "-", "-")
      val presenter = new BoardPresenter(boardStructure)

      assert(presenter.displaySpot(0, "X") == "X")
    }
    
    it("should create a new line if board index mod is 0") {
      val boardStructure = Array("X", "-", "O", "-", "-", "-", "-", "-", "-")
      val presenter = new BoardPresenter(boardStructure)
      
      assert(presenter.makeRows(3) == "\n---------\n")
    }
    
    it("should insert a pipe when index is 1") {
      val boardStructure = Array("X", "-", "O", "-", "-", "-", "-", "-", "-")
      val presenter = new BoardPresenter(boardStructure)

      assert(presenter.makeRows(1) == " | ")
    }
    
    it("should format a board string") {
      val boardStructure = Array("X", "O", "X", "-", "-", "-", "-", "-", "-")
      val presenter = new BoardPresenter(boardStructure)

      assert(presenter.formatBoard(boardStructure) == "X | O | X\n---------\n3 | 4 | 5\n---------\n6 | 7 | 8")
    }
  }
}
