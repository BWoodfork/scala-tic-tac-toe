package tictactoe

import org.scalatest.{OneInstancePerTest, FunSpec, Matchers}

class TicTacToeRulesSpec extends FunSpec with OneInstancePerTest with Matchers {
  val board = new Board(3)
  val tokens = Array[String]("X", "O")
  val rules = new TicTacToeRules(board, tokens)

  describe("TicTacToeRules") {
    it("returns first token when board count is odd") {
      
      assert(rules.currentTurn_?() == "X")
    }

    it("returns second token when board count is even") {
      board.fillSpace(0, "X")

      assert(rules.currentTurn_?() == "O")
    }
    
    it("returns true if a move on a board is valid") {

      assert(rules.validMove_?(0, "X"))
    } 
    
    it("returns false if a move on a board is not valid") {
      board.fillSpace(0, "X")
      
      assert(!rules.validMove_?(0, "X"))
    }
    
    it("returns true if first row win for 'X' token") {
      board.fillSpace(0, "X")
      board.fillSpace(1, "X")
      board.fillSpace(2, "X")
      
      assert(rules.gameWinner_?("X"))
    }
    
    it("returns true if first row win for 'O' token") {
      board.fillSpace(0, "O")
      board.fillSpace(1, "O")
      board.fillSpace(2, "O")

      assert(rules.gameWinner_?("O"))
    }

    it("returns true if second row win for 'O' token") {
      board.fillSpace(3, "O")
      board.fillSpace(4, "O")
      board.fillSpace(5, "O")

      assert(rules.gameWinner_?("O"))
    }
    
    it("returns false if no row winner") {
      board.fillSpace(0, "X")
      board.fillSpace(1, "X")

      assert(!rules.gameWinner_?("X"))
    }
    
    it("returns true if column win for 'X' token") {
      board.fillSpace(0, "O")
      board.fillSpace(3, "O")
      board.fillSpace(6, "O")
      
      assert(rules.gameWinner_?("O"))
    }
    
    it("returns false if no column win") {
      board.fillSpace(0, "O")
      board.fillSpace(3, "O")
      board.fillSpace(6, "X")

      assert(!rules.gameWinner_?("O"))
    }
    
    it("returns true if diagonal win for 'X' token") {
      board.fillSpace(0, "X")
      board.fillSpace(4, "X")
      board.fillSpace(8, "X")
      
      assert(rules.gameWinner_?("X"))
    }
    
    it("returns false if not diagonal win") {
      board.fillSpace(0, "O")
      board.fillSpace(4, "X")
      board.fillSpace(8, "X")
      
      assert(!rules.gameWinner_?("O"))
    }
    
    it("returns true if a row win for 'X'") {
      board.fillSpace(0, "X")
      board.fillSpace(1, "X")
      board.fillSpace(2, "X")

      assert(rules.gameWinner_?("X"))
    }
    
    it("returns false if not row win") {
      board.fillSpace(0, "O")
      board.fillSpace(1, "X")
      board.fillSpace(2, "X")

      assert(!rules.gameWinner_?("O"))
    }
    
    it("returns the winning token when 'X'") {
      board.fillSpace(0, "X")
      board.fillSpace(1, "X")
      board.fillSpace(2, "X")

      assert(rules.winningToken("X") == "X")
    }
    
    it("returns the winning token when 'O'") {
      board.fillSpace(0, "O")
      board.fillSpace(1, "O")
      board.fillSpace(2, "O")

      assert(rules.winningToken("O") == "O")
    }
    
    it("returns null when there is no winning token") {
      board.fillSpace(0, "O")
      board.fillSpace(1, "O")
      board.fillSpace(2, "X")

      assert(rules.winningToken("O") == null)
    }

    it("returns true if tie game") {
      board.fillSpace(0, "X")
      board.fillSpace(1, "O")
      board.fillSpace(2, "X")
      board.fillSpace(3, "X")
      board.fillSpace(4, "O")
      board.fillSpace(5, "O")
      board.fillSpace(6, "O")
      board.fillSpace(7, "X")
      board.fillSpace(8, "X")

      assert(rules.tieGame_?("X"))
    }

    it("returns false if not tie game") {
      board.fillSpace(0, "O")
      board.fillSpace(1, "X")
      board.fillSpace(2, "X")
      board.fillSpace(3, "O")
      board.fillSpace(4, "O")
      board.fillSpace(5, "O")
      board.fillSpace(6, "X")
      board.fillSpace(7, "X")

      assert(!rules.tieGame_?("O"))
    }
    
    it("returns false if there is a game winner") {
      board.fillSpace(0, "X")
      board.fillSpace(1, "X")
      board.fillSpace(2, "X")
      
      assert(!rules.tieGame_?("O"))
    }
    
    it("returns true if game is over") {
      board.fillSpace(0, "X")
      board.fillSpace(1, "O")
      board.fillSpace(2, "X")
      board.fillSpace(3, "X")
      board.fillSpace(4, "O")
      board.fillSpace(5, "O")
      board.fillSpace(6, "O")
      board.fillSpace(7, "X")
      board.fillSpace(8, "X")
      
      assert(rules.gameOver_?("X"))
    }
    
    it("returns false if game is not over") {
      board.fillSpace(0, "X")
      board.fillSpace(1, "O")
      board.fillSpace(2, "X")
      board.fillSpace(3, "X")
      board.fillSpace(4, "O")
      board.fillSpace(5, "O")
      board.fillSpace(6, "O")
      board.fillSpace(7, "X")

      assert(!rules.gameOver_?("O"))
    }
  }
}