package tictactoe

import org.scalatest.FunSpec

import scala.collection.mutable.ArrayBuffer

class GameLoopHelperSpec extends FunSpec {
  describe("GameLoopHelper") {
    it("increments _playerIncrementer when takeTurn is called") {
      val token = "X"
      val board = new Board(3)
      val players = Array[GamePlayer](new User(board, token))
      val helper = new GameLoopHelper(players)
      
      assert(helper.incrementerValue == 0)
      
      helper.takeTurn
      
      assert(helper.incrementerValue == 1)
    }
    
    it("returns current player as 'User' before turn is taken") {
      val tokens = ArrayBuffer[String]("X", "O")
      val board = new Board(3)
      val rules = new TicTacToeRules(board.spaces, tokens)
      val players = Array[GamePlayer](new User(board, tokens(0)), new HardAI(rules, board, tokens(1)))
      val helper = new GameLoopHelper(players)

      assert(helper.currentPlayer(0).isInstanceOf[User])
    }
    
    it("returns current player as 'HardAI' after turn is taken") {
      val tokens = ArrayBuffer[String]("X", "O")
      val board = new Board(3)
      val rules = new TicTacToeRules(board.spaces, tokens)
      val players = Array[GamePlayer](new User(board, tokens(0)), new HardAI(rules, board, tokens(1)))
      val helper = new GameLoopHelper(players)
      
      helper.takeTurn
      assert(helper.currentPlayer(1).isInstanceOf[HardAI])
    }
    
    it("returns current player as 'User' after second turn is taken") {
      val tokens = ArrayBuffer[String]("X", "O")
      val board = new Board(3)
      val rules = new TicTacToeRules(board.spaces, tokens)
      val players = Array[GamePlayer](new User(board, tokens(0)), new HardAI(rules, board, tokens(1)))
      val helper = new GameLoopHelper(players)

      helper.takeTurn
      helper.takeTurn
      assert(helper.currentPlayer(0).isInstanceOf[User])
    }
    
    it("returns the value of _playerIncrementer") {
      val token = "X"
      val board = new Board(3)
      val players = Array[GamePlayer](new User(board, token))
      val helper = new GameLoopHelper(players)

      assert(helper.incrementerValue == 0)

      helper.takeTurn

      assert(helper.incrementerValue == 1)
    }
  }
}