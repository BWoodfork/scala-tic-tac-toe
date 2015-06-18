package tictactoe

class TicTacToeRules(dataStructure: Array[String], tokens: Array[String]) {
  var size = math.sqrt(dataStructure.size).toInt
  val indices = dataStructure.indices.toArray

  def validMove_?(index: Int) = {
    (index >= dataStructure.indices.head) && !(index >= dataStructure.size) && dataStructure(index) == "-" && index.isInstanceOf[Int]
  }

  def currentTurn_?() = {
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
    getMultipleComboSet(allWinningIndexCombinations(), dataStructure).filter(combo => winningCombination_?(combo))
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
  
  def allWinningIndexCombinations() = {
    rowIndices() ++ columnIndices() ++ leftAndRightDiagonalIndices
  }

  private def rowIndices() = {
    dataStructure.indices.toArray.grouped(size).toArray
  }

  private def columnIndices() = {
    val groupedIndices = indices.grouped(size)

    transpose_indices(groupedIndices.toArray)
  }

  private def leftAndRightDiagonalIndices =
    Array(leftDiagonalIndices(), rightDiagonalIndices())

  private def leftDiagonalIndices() = {
    indices.groupBy(_ % (size + 1) == 0)(true)
  }

  private def rightDiagonalIndices() = {
    val indicesWithoutLast = indices.init
    
    indicesWithoutLast.groupBy(_ % (size - 1) == 0)(true).tail
  }

  private def transpose_indices(collection: Array[Array[Int]]) = {
    collection.transpose
  }
}