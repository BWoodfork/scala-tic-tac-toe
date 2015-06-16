package tictactoe

import org.scalatest.{Matchers, FunSpec}

import scala.collection.mutable.ArrayBuffer

class BoardPresenterSpec extends FunSpec with Matchers {
  describe("Board Presenter") {
    it("returns the index when space is blank and token when it is filled") {
      val boardStructure = ArrayBuffer("X", "O", "O", "-", "-", "-", "-", "-", "-")
      val presenter = new BoardPresenter(boardStructure)

      presenter.getIndicesOrTokens(boardStructure) should be(ArrayBuffer("X", "O", "O",
                                                                         "3", "4", "5",
                                                                         "6", "7", "8"))
    }
    
    it("separates the rows of the board") {
      val board_state = ArrayBuffer("X", "-", "O", "-", "-", "-", "-", "-", "-")
      val presenter = new BoardPresenter(board_state)

      presenter.separateRows(board_state) should be(Array(ArrayBuffer("X", "1", "O"),
                                                          ArrayBuffer("3", "4", "5"),
                                                          ArrayBuffer("6", "7", "8")))
    }
  }
}
