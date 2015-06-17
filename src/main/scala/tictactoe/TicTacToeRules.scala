package tictactoe

class TicTacToeRules(dataStructure: Array[String], tokens: Array[String], winningCombination: Array[Array[Int]]) {

  def validMove_?(index: Int, token: String, dataStructure: Array[String]) = {
    dataStructure(index) == "-"
  }

  def currentTurn_?(dataStructure: Array[String]) = {
    if (dataStructure.count(_ == "-") % 2 != 0) tokens(0) else tokens(1)
  }

  def allSpacesFilled_?(dataStructure: Array[String]) = {
    !dataStructure.contains("-")
  }

  def winningCombination_?(dataStructure: Array[String]) = {
    allSpacesFilled_?(dataStructure) && dataStructure.toSet.size == 1
  }

  def getComboSet(indices: Array[Int], dataStructure: Array[String]) = {
    indices.map(index => dataStructure(index))
  }

  def getMultipleComboSet(nestedIndices: Array[Array[Int]], dataStructure: Array[String]) = {
    nestedIndices.map(indexColl => getComboSet(indexColl, dataStructure))
  }

  def winningSet(dataStructure: Array[String]) = {
    getMultipleComboSet(winningCombination, dataStructure).filter(combo => winningCombination_?(combo))
  }
  
  def tieGame_?(dataStructure: Array[String]) = {
    allSpacesFilled_?(dataStructure) && winningSet(dataStructure).size == 0
  }
  
  def gameOver_?(dataStructure: Array[String]) = {
    tieGame_?(dataStructure) || winningSet(dataStructure).size >= 1
  }
  
  def winningToken(dataStructure: Array[String]) = {
    if (winningSet(dataStructure).size >= 1) {
      winningSet(dataStructure).head.head
    } else
    null
  }
}