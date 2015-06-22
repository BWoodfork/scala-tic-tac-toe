package tictactoe.Players

import org.scalatest.FunSpec
import tictactoe.Board.Board
import tictactoe.Game.Players.{HardAI, PlayerFactory, User}
import tictactoe.{TestGame, TicTacToeRules}

class PlayerFactorySpec extends FunSpec {
  describe("Player Factory") {
    it("it initializes two User players when number of players is 2") {
      val board = new Board(3)
      val rules = new TicTacToeRules(board.spaces)
      val boardStructure = board.spaces
      val game = new TestGame
      val factory = new PlayerFactory(boardStructure, rules, board, game)
      val players = factory.getPlayers(2)

      assert(players(0).isInstanceOf[User])
      assert(players(1).isInstanceOf[User])
    }

    it("it initializes one AI player and one user when number of players is 1") {
      val board = new Board(3)
      val rules = new TicTacToeRules(board.spaces)
      val boardStructure = board.spaces
      val game = new TestGame
      val factory = new PlayerFactory(boardStructure, rules, board, game)
      val players = factory.getPlayers(1)

      assert(players(0).isInstanceOf[User] && players(1).isInstanceOf[HardAI])
    }
  }
}
