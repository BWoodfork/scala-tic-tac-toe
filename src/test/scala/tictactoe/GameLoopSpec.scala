package tictactoe

import org.scalatest.{OneInstancePerTest, Matchers, FunSpec}
import tictactoe.board.Board
import tictactoe.Game.Players.GamePlayer

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class GameLoopSpec extends FunSpec with Matchers with OneInstancePerTest {
  val testGame = new TestGame()
  val board = new Board(3)
  val tokens = ArrayBuffer[String]("X", "O")
  val players = Array[GamePlayer](new TestPlayer, new TestPlayer)
  val boardStructure = Array("-", "-", "-")
  val gameLoop = new GameLoop(testGame, players)

  describe("GameLoop") {
    it("does nothing if game is not running") {
      testGame.setRunning(false)
      gameLoop.run()

      assert(testGame.numberOfUpdates == 0)
    }

    it("invokes update when game is running") {
      testGame.setRunning(true)
      testGame.setRunning(false)

      gameLoop.run()

      assert(testGame.numberOfUpdates == 1)
    }

    it("invokes update as long as game is running") {
      testGame.setRunning(true)
      testGame.setRunning(true)
      testGame.setRunning(true)
      testGame.setRunning(false)

      gameLoop.run()

      assert(testGame.numberOfUpdates == 3)
    }

    it("invokes render after game update") {
      testGame.setRunning(true)
      testGame.setRunning(false)

      gameLoop.run()

      assert(testGame.numberOfRenders == 2)
    }

    it("updates spaces, given a move") {
      testGame.setRunning(true)
      testGame.setRunning(false)
      val boardStructure = Array("-", "-", "-",
                                 "-", "-", "-",
                                 "-", "-", "-")

      testGame.update(0, "X", boardStructure)

      boardStructure should be (Array("X", "-", "-",
                                     "-", "-", "-",
                                     "-", "-", "-"))
    }
  }

  class TestPlayer extends GamePlayer {
    override def getMove(): Int = {
      0
    }
  }

  class TestGame extends Game {
    var numberOfUpdates = 0
    var numberOfRenders = 0
    private var running = mutable.Queue[Boolean]()

    def setRunning(runningValues: Boolean) = {
      this.running += runningValues
    }

    def update(index: Int, token: String, boardStructure: Array[String]) = {
      boardStructure.update(index, token)
    }

    def isRunning: Boolean = {
      running.dequeue()
    }

    override def renderBoard() = {
      numberOfRenders += 1
    }

    override def updateBoard(index: Int, token: String): Array[String] = {
      numberOfUpdates += 1
      boardStructure.update(index, token)
      boardStructure
    }

    override def currentToken(): String = {
      "X"
    }

    override def validMove_?(index: Int): Boolean = {
      true
    }

    override def winningToken(): String = {
      "X"
    }
  }
}
