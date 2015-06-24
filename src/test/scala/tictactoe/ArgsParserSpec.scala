package tictactoe

import org.scalatest.{Matchers, FunSpec}

class ArgsParserSpec extends FunSpec with Matchers {

  describe("ArgsParser") {
    it("gets both tokens from the game arguments") {
      val gameArgs = Array("1", "X", "O")
      val parser = new ArgsParser(gameArgs)

      assert(parser.getPlayerTokens.size == 2)
    }

    it("throws exception when both tokens are the same") {
      val gameArgs = Array("1", "X", "X")
      val parser = new ArgsParser(gameArgs)

      intercept[Exception] {
        parser.getPlayerTokens
      }
    }

    it("throws exception when token length is longer than 1 character") {
      val gameArgs = Array("1", "X", "OOXOXXX")
      val parser = new ArgsParser(gameArgs)

      intercept[Exception] {
        parser.getPlayerTokens
      }
    }

    it("Upcases tokens if they are lower case") {
      val gameArgs = Array("1", "x", "o")
      val parser = new ArgsParser(gameArgs)

      assert(parser.getPlayerTokens.contains("X"))
      assert(parser.getPlayerTokens.contains("O"))
    }

    it("it returns 1 as the number of players requested to play the game") {
      val gameArgs = Array("1", "X", "O")
      val parser = new ArgsParser(gameArgs)

      parser.getPlayerTokens
      assert(parser.playerTotal == 1)
    }

    it("returns 2 as the number of players requested to play the game") {
      val gameArgs = Array("2", "X", "O")
      val parser = new ArgsParser(gameArgs)

      parser.getPlayerTokens
      assert(parser.playerTotal == 2)
    }
  }
}
