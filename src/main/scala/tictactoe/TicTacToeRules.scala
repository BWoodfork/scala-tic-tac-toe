package tictactoe

class TicTacToeRules(boardStructure: Array[String]) {

  def validMove_?(index: Int) = {
    (index >= boardStructure.indices.head) && !(index >= boardStructure.size) && boardStructure(index) == "-" && index.isInstanceOf[Int]
  }

  def allSpacesFilled_?(boardStructure: Array[String]) = {
    !boardStructure.contains("-")
  }

  def winningCombination_?(boardStructure: Array[String]) = {
    allSpacesFilled_?(boardStructure) && boardStructure.toSet.size == 1
  }

  def getComboSet(indices: Array[Int], boardStructure: Array[String]) = {
    indices.map(index => boardStructure(index))
  }

  def getMultipleComboSet(nestedIndices: Array[Array[Int]], boardStructure: Array[String]) = {
    nestedIndices.map(indexColl => getComboSet(indexColl, boardStructure))
  }

  def winningSet(boardStructure: Array[String]) = {
    getMultipleComboSet(allWinningIndexCombinations(), boardStructure).filter(combo => winningCombination_?(combo))
  }

  def tieGame_?(boardStructure: Array[String]) = {
    allSpacesFilled_?(boardStructure) && winningSet(boardStructure).size == 0
  }

  def gameOver_?(boardStructure: Array[String]) = {
    tieGame_?(boardStructure) || winningSet(boardStructure).size >= 1
  }

  def winningToken(boardStructure: Array[String]) = {
    if (winningSet(boardStructure).size >= 1) {
      winningSet(boardStructure).head.head
    } else UIMessages.NoWinningToken
  }

  def allWinningIndexCombinations() = {
    rowIndices() ++ columnIndices() ++ leftAndRightDiagonalIndices
  }

  private def rowIndices() = {
    boardStructure.indices.toArray.grouped(size).toArray
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

  private val size = math.sqrt(boardStructure.size).toInt
  private val indices = boardStructure.indices.toArray
}