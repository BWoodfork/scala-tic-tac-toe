package tictactoe

import org.scalatest.{OneInstancePerTest, FunSpec, Matchers}

class TicTacToeRulesSpec extends FunSpec with OneInstancePerTest with Matchers {
  val dataStructure = Array[String]("-","-","-","-","-","-","-","-","-")
  val tokens = Array[String]("X", "O")
  val winningCombos = 
   Array(Array(0, 1, 2),
     Array(3, 4, 5),
     Array(6, 7, 8),
     Array(0, 3, 6),
     Array(1, 4, 7),
     Array(2, 5, 8),
     Array(0, 4, 8),
     Array(2, 4, 6))
  
  val rules = new TicTacToeRules(dataStructure, tokens, winningCombos)

  describe("TicTacToeRules") {
    it("returns first token when board count is odd") {
      val dataStructure = Array("-", "-", "-",
                                "-", "-", "-",
                                "-", "-", "-")
      
      assert(rules.currentTurn_?(dataStructure) == "X")
    }

    it("returns second token when board count is even") {
      val dataStructure = Array("X", "-", "-",
                                "-", "-", "-",
                                "-", "-", "-")
      
      assert(rules.currentTurn_?(dataStructure) == "O")
    }
    
    it("returns true if a move on a board is valid") {
      val dataStructure = Array("-")
      assert(rules.validMove_?(0, "X", dataStructure))
    }

    it("returns false if a move on a board is not valid") {
      val dataStructure = Array("X")
      assert(!rules.validMove_?(0, "X", dataStructure))
    }
    
    it("returns true if all spaces filled with a token") {
      val dataStructure = Array("X", "X", "O")

      assert(rules.allSpacesFilled_?(dataStructure))
    }

    it("returns false if spaces are empty") {
      val dataStructure = Array("-", "-", "-")

      assert(!rules.allSpacesFilled_?(dataStructure))
    }
    
    it("returns true if 3 elements in collection are alike") {
      val dataStructure = Array("X", "X", "X")
      
      assert(rules.winningCombination_?(dataStructure))
    }
    
    it("returns false if elements are blank spaces") {
      val dataStructure = Array("-", "-", "-")
      
      assert(!rules.winningCombination_?(dataStructure))
    }
    
    it("returns true if elements are 'O'") {
      val dataStructure = Array("O", "O", "O")

      assert(rules.winningCombination_?(dataStructure))
    }
   
    it("returns elements on board, given list of indices") {
      val dataStructure = Array("O", "X", "X",
                                "-", "-", "-",
                                "-", "X", "-")
      
      val indices = Array(0, 1, 2)
      
      rules.getComboSet(indices, dataStructure) should be (Array("O", "X", "X"))
    }
    
    it("returns elements on board, given 3,4,5 indices") {
      val dataStructure = Array("O", "X", "X",
                                "-", "O", "-",
                                "-", "X", "-")

      val indices = Array(3, 4, 5)
      
      rules.getComboSet(indices, dataStructure) should be (Array("-", "O", "-"))
    }
    
    it("returns elements on a board, given multiple collections of indices ") {
      val dataStructure = Array("O", "X", "X",
                                "-", "O", "-",
                                "-", "X", "-")

      val indexColl = Array(Array(0, 1, 2), Array(3, 4, 5))
      
      rules.getMultipleComboSet(indexColl, dataStructure) should be (Array(Array("O", "X", "X"),
                                                                           Array("-", "O", "-")))
    }
    
    it("returns the winning moves on row win") {
      val dataStructure = Array("O", "O", "O",
                                "-", "-", "-",
                                "-", "X", "-")

      rules.winningSet(dataStructure) should be (Array(Array("O", "O", "O")))
    }
    
    it("returns empty Array when there is no winner") {
      val dataStructure = Array("O", "O", "X",
                                "-", "X", "-",
                                "-", "X", "O")

      rules.winningSet(dataStructure) should be (Array())
    }

    it("returns the winning moves for column win") {
      val dataStructure = Array("O", "X", "X",
                                "O", "-", "-",
                                "O", "X", "-")

      rules.winningSet(dataStructure) should be (Array(Array("O", "O", "O")))
    }
    
    it("returns the winning moves for diagonal win") {
      val dataStructure = Array("O", "X", "X",
                                "X", "O", "-",
                                "X", "X", "O")

      rules.winningSet(dataStructure) should be (Array(Array("O", "O", "O")))
    }
    
    it("returns true if there is a tie game") {
      val dataStructure = Array("O", "X", "O",
                                "X", "X", "O",
                                "X", "O", "X")
      
      assert(rules.tieGame_?(dataStructure))
    }
    
    it("returns false if there is not a tie game") {
      val dataStructure = Array("X", "X", "O",
                                "X", "X", "O",
                                "X", "O", "X")
      
      assert(!rules.tieGame_?(dataStructure))
    }
    
    it("returns true if the game is over - tie game") {
      val dataStructure = Array("O", "X", "O",
                                "X", "X", "O",
                                "X", "O", "X")
      
      assert(rules.gameOver_?(dataStructure))
    }
    
    it("returns true if the game is over - winner") {
      val dataStructure = Array("O", "X", "X",
                                "X", "O", "-",
                                "X", "X", "O")
      
      assert(rules.gameOver_?(dataStructure))
    }
    
    it("returns false if the game is not over") {
      val dataStructure = Array("O", "X", "O",
                                "X", "X", "O",
                                "X", "-", "X")
      
      assert(!rules.gameOver_?(dataStructure))
    }
    
    it("returns the winning game token") {
      val dataStructure = Array("X", "X", "O",
                                "X", "X", "O",
                                "X", "-", "X")

      assert(rules.winningToken(dataStructure) == "X")
    }
    
    it("returns the winning game token for 'O'") {
      val dataStructure = Array("O", "X", "O",
                                "X", "O", "O",
                                "X", "-", "O")

      assert(rules.winningToken(dataStructure) == "O")
    }
    
    it("it returns nothing when there is no game winner") {
      val dataStructure = Array("O", "X", "O",
                                "X", "O", "O",
                                "X", "-", "-")

      assert(rules.winningToken(dataStructure) == null)
    }
  }
}