package tictactoe

import org.scalatest.{OneInstancePerTest, FunSpec, Matchers}

class TicTacToeRulesSpec extends FunSpec with OneInstancePerTest with Matchers {
  val tokens = Array[String]("X", "O")

  describe("TicTacToeRules") {
    it("returns first token when board count is odd") {
      val dataStructure = Array("-", "-", "-",
                                "-", "-", "-",
                                "-", "-", "-")
      
      val rules = new TicTacToeRules(dataStructure, tokens)

      assert(rules.currentTurn_?() == "X")
    }

    it("returns second token when board count is even") {
      val dataStructure = Array("X", "-", "-")
      val rules = new TicTacToeRules(dataStructure, tokens)

      assert(rules.currentTurn_?() == "O")
    }
    
    it("returns true if move is not taken") {
      val dataStructure = Array("-", "-", "-",
                                "-", "-", "-",
                                "-", "-", "-")
      val rules = new TicTacToeRules(dataStructure, tokens)

      assert(rules.validMove_?(0))
    }

    it("returns false if move is taken") {
      val dataStructure = Array("O")
      val rules = new TicTacToeRules(dataStructure, tokens)

      assert(!rules.validMove_?(0))
    }

    it("returns true if move is within the size limits of a data structure") {
      val dataStructure = Array("-")
      val rules = new TicTacToeRules(dataStructure, tokens)

      assert(rules.validMove_?(0))
    }

    it("returns false if move is not within the size limits of a data structure") {
      val dataStructure = Array("-")
      val rules = new TicTacToeRules(dataStructure, tokens)

      assert(!rules.validMove_?(10))
    }

    it("returns false if move is smaller than board's smallest index") {
      val dataStructure = Array("-", "-", "-",
                                "-", "-", "-",
                                "-", "-", "-")
      val rules = new TicTacToeRules(dataStructure, tokens)

      assert(!rules.validMove_?(-1))
    }

    it("returns true if move is not filled") {
      val dataStructure = Array("-")
      val rules = new TicTacToeRules(dataStructure, tokens)

      assert(rules.validMove_?(0))
    }

    it("returns false if move is filled") {
      val dataStructure = Array("O")
      val rules = new TicTacToeRules(dataStructure, tokens)

      assert(!rules.validMove_?(0))
    }

    it("returns true if all spaces filled with a token") {
      val dataStructure = Array("X", "X", "O")
      val rules = new TicTacToeRules(dataStructure, tokens)

      assert(rules.allSpacesFilled_?(dataStructure))
    }

    it("returns false if spaces are empty") {
      val dataStructure = Array("-", "-", "-",
                                "-", "-", "-",
                                "-", "-", "-")
      val rules = new TicTacToeRules(dataStructure, tokens)

      assert(!rules.allSpacesFilled_?(dataStructure))
    }
    
    it("returns true if 3 elements in collection are alike") {
      val dataStructure = Array("X", "X", "X")
      val rules = new TicTacToeRules(dataStructure, tokens)

      assert(rules.winningCombination_?(dataStructure))
    }
    
    it("returns false if elements are blank spaces") {
      val dataStructure = Array("-", "-", "-",
                                "-", "-", "-",
                                "-", "-", "-")
      val rules = new TicTacToeRules(dataStructure, tokens)

      assert(!rules.winningCombination_?(dataStructure))
    }
    
    it("returns true if elements are 'O'") {
      val dataStructure = Array("O", "O", "O")
      val rules = new TicTacToeRules(dataStructure, tokens)

      assert(rules.winningCombination_?(dataStructure))
    }
   
    it("returns elements on board, given list of indices") {
      val dataStructure = Array("O", "X", "X",
                                "-", "-", "-",
                                "-", "X", "-")
      val rules = new TicTacToeRules(dataStructure, tokens)

      val indices = Array(0, 1, 2)
      
      rules.getComboSet(indices, dataStructure) should be (Array("O", "X", "X"))
    }
    
    it("returns elements on board, given 3,4,5 indices") {
      val dataStructure = Array("O", "X", "X",
                                "-", "O", "-",
                                "-", "X", "-")
      val rules = new TicTacToeRules(dataStructure, tokens)

      val indices = Array(3, 4, 5)
      
      rules.getComboSet(indices, dataStructure) should be (Array("-", "O", "-"))
    }
    
    it("returns elements on a board, given multiple collections of indices ") {
      val dataStructure = Array("O", "X", "X",
                                "-", "O", "-",
                                "-", "X", "-")
      val rules = new TicTacToeRules(dataStructure, tokens)

      val indexColl = Array(Array(0, 1, 2), Array(3, 4, 5))
      
      rules.getMultipleComboSet(indexColl, dataStructure) should be (Array(Array("O", "X", "X"),
                                                                           Array("-", "O", "-")))
    }
    
    it("returns the winning moves on row win") {
      val dataStructure = Array("O", "O", "O",
                                "-", "-", "-",
                                "-", "X", "-")
      val rules = new TicTacToeRules(dataStructure, tokens)

      rules.winningSet(dataStructure) should be (Array(Array("O", "O", "O")))
    }
    
    it("returns empty Array when there is no winner") {
      val dataStructure = Array("O", "O", "X",
                                "-", "X", "-",
                                "-", "X", "O")
      val rules = new TicTacToeRules(dataStructure, tokens)

      rules.winningSet(dataStructure) should be (Array())
    }

    it("returns the winning moves for column win") {
      val dataStructure = Array("O", "X", "X",
                                "O", "-", "-",
                                "O", "X", "-")
      val rules = new TicTacToeRules(dataStructure, tokens)

      rules.winningSet(dataStructure) should be (Array(Array("O", "O", "O")))
    }
    
    it("returns the winning moves for diagonal win") {
      val dataStructure = Array("O", "X", "X",
                                "X", "O", "-",
                                "X", "X", "O")
      val rules = new TicTacToeRules(dataStructure, tokens)

      rules.winningSet(dataStructure) should be (Array(Array("O", "O", "O")))
    }
    
    it("returns true if there is a tie game") {
      val dataStructure = Array("O", "X", "O",
                                "X", "X", "O",
                                "X", "O", "X")
      val rules = new TicTacToeRules(dataStructure, tokens)

      assert(rules.tieGame_?(dataStructure))
    }
    
    it("returns false if there is not a tie game") {
      val dataStructure = Array("X", "X", "O",
                                "X", "X", "O",
                                "X", "O", "X")
      val rules = new TicTacToeRules(dataStructure, tokens)

      assert(!rules.tieGame_?(dataStructure))
    }
    
    it("returns true if the game is over - tie game") {
      val dataStructure = Array("O", "X", "O",
                                "X", "X", "O",
                                "X", "O", "X")
      val rules = new TicTacToeRules(dataStructure, tokens)

      assert(rules.gameOver_?(dataStructure))
    }
    
    it("returns true if the game is over - winner") {
      val dataStructure = Array("O", "X", "X",
                                "X", "O", "-",
                                "X", "X", "O")
      val rules = new TicTacToeRules(dataStructure, tokens)

      assert(rules.gameOver_?(dataStructure))
    }
    
    it("returns false if the game is not over") {
      val dataStructure = Array("O", "X", "O",
                                "X", "X", "O",
                                "X", "-", "X")
      val rules = new TicTacToeRules(dataStructure, tokens)

      assert(!rules.gameOver_?(dataStructure))
    }
    
    it("returns the winning game token") {
      val dataStructure = Array("X", "X", "O",
                                "X", "X", "O",
                                "X", "-", "X")
      val rules = new TicTacToeRules(dataStructure, tokens)

      assert(rules.winningToken(dataStructure) == "X")
    }
    
    it("returns the winning game token for 'O'") {
      val dataStructure = Array("O", "X", "O",
                                "X", "O", "O",
                                "X", "-", "O")
      val rules = new TicTacToeRules(dataStructure, tokens)

      assert(rules.winningToken(dataStructure) == "O")
    }
    
    it("it returns nothing when there is no game winner") {
      val dataStructure = Array("O", "X", "O",
                                "X", "O", "O",
                                "X", "-", "-")
      val rules = new TicTacToeRules(dataStructure, tokens)

      assert(rules.winningToken(dataStructure) == null)
    }
    

    
    it("returns all winning combinations for a 3x3 grid board structure") {
      val dataStructure = Array("-", "-", "-",
                                "-", "-", "-",
                                "-", "-", "-")
      val rules = new TicTacToeRules(dataStructure, tokens)

      rules.allWinningIndexCombinations() should be (Array(Array(0, 1, 2),
                                                                        Array(3, 4, 5),
                                                                        Array(6, 7, 8),
                                                                        Array(0, 3, 6),
                                                                        Array(1, 4, 7),
                                                                        Array(2, 5, 8),
                                                                        Array(0, 4, 8),
                                                                        Array(2, 4, 6)))
    }
    
    it("returns all winning combinations for a 4x4 grid board structure") {
      val dataStructure = Array("-", "-", "-", "-",
                                "-", "-", "-", "-",
                                "-", "-", "-", "-",
                                "-", "-", "-", "-")
      val rules = new TicTacToeRules(dataStructure, tokens)
      
      rules.allWinningIndexCombinations() should be (Array( Array(0, 1, 2, 3),
                                                            Array(4, 5, 6, 7),
                                                            Array(8, 9, 10, 11),
                                                            Array(12, 13, 14, 15),
                                                            Array(0, 4, 8, 12),
                                                            Array(1, 5, 9, 13),
                                                            Array(2, 6, 10, 14),
                                                            Array(3, 7, 11, 15),
                                                            Array(0, 5, 10, 15),
                                                            Array(3, 6, 9, 12)))
    }
  }
}