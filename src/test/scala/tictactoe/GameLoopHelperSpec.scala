package tictactoe

import org.scalatest.FunSpec
import tictactoe.Board.Board
import tictactoe.Game.Players.{HardAI, User, GamePlayer}
import tictactoe.GameLoopHelper

class GameLoopHelperSpec extends FunSpec {
  val board = new Board(3)
      val rules = new TicTacToeRules(board.spaces)
      val game = new TestGame
      val players = Array[GamePlayer](new User(), new HardAI(rules, board, board.spaces, game))
      val helper = new GameLoopHelper(players)

  describe("GameLoopHelper") {
    it("increments _playerIncrementer when takeTurn is called") {
      assert(helper.incrementerValue == 0)

      helper.takeTurn()

      assert(helper.incrementerValue == 1)
    }

    it("returns current player as 'User' before turn is taken") {

      assert(helper.currentPlayer(0).isInstanceOf[User])
    }

    it("returns current player as 'HardAI' after turn is taken") {
      helper.takeTurn()

      assert(helper.currentPlayer(1).isInstanceOf[HardAI])
    }

    it("returns current player as 'User' after second turn is taken") {
      helper.takeTurn()
      helper.takeTurn()

      assert(helper.currentPlayer(0).isInstanceOf[User])
    }

    it("returns the value of _playerIncrementer") {
      val players = Array[GamePlayer](new User())
      val helper = new GameLoopHelper(players)

      assert(helper.incrementerValue == 0)

      helper.takeTurn()

      assert(helper.incrementerValue == 1)
    }
  }
}
