package tictactoe

import org.scalatest.{Matchers, FunSpec}

import scala.collection.mutable.ArrayBuffer

class UISpec extends FunSpec with Matchers {
  val ui = new ConsoleUI(Array[String]())
  
  describe("UI") {
    it("returns true if token already exists") {
      val playerTokens = ArrayBuffer[String]("X")
      
      assert(ui.tokenExists_?(playerTokens, "X"))
    }
    
    it("returns false if token does not exist") {
      val playerTokens = ArrayBuffer[String]("X")

      assert(!ui.tokenExists_?(playerTokens, "O"))
    }
    
    it("returns true if game token is one character") {
      val token = "X"
      
      assert(ui.validTokenLength_?(token))
    }
    
    it("returns false if game token is more than one character") {
      val token = "XXXXX"
      
      assert(!ui.validTokenLength_?(token))
    }
    
    it("returns true if game token is a character") {
      val token = "X"

      assert(ui.validTokenLength_?(token))
    }

    it("returns true if token is") {
      val token = "X"

      assert(ui.validTokenLength_?(token))
    }
  }
}