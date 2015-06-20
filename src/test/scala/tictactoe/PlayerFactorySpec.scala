package tictactoe

import org.scalatest.FunSpec

import scala.collection.mutable.ArrayBuffer

class PlayerFactorySpec extends FunSpec {
  describe("Player Factory") {
    it("it initializes two User players when number of players is 2") {
      val board = new Board(3)
      val tokens = ArrayBuffer[String]("X", "O")
      val rules = new TicTacToeRules(board.spaces, tokens)
      val factory = new PlayerFactory(board, rules)

      val players = factory.getPlayers(2, tokens)
      assert(players(0).isInstanceOf[User])
      assert(players(1).isInstanceOf[User])
    }
    
//    it("it initializes one AI player and one user when number of players is 1") {
//      val board = new Board(3)
//      val tokens = ArrayBuffer[String]("X", "O")
//      val rules = new TicTacToeRules(board.spaces, tokens)
//      val factory = new PlayerFactory(board, rules)
//
//      val players = factory.getPlayers(1, tokens)
//      assert(players(1).isInstanceOf[User])
//      assert(players(0).isInstanceOf[HardAI])
//    }
  }
}