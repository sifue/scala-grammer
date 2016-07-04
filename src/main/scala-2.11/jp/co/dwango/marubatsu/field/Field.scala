package jp.co.dwango.marubatsu.field

class Field(val cells: Map[(Int, Int), CellState], val next: CellState) {

  private[marubatsu] def put(row: Int, column: Int): Field = {
    new Field(cells + ((row, column) -> next), next.next)
  }

  private[marubatsu] def canPut(row: Int, column: Int): Boolean = cells((row, column)) == Empty

  override def toString = s"Field($cells, $next)"
}

object Field {

  private[marubatsu] def apply(): Field = {
    val keyValues = for(row <- 0 to 2; column <- 0 to 2) yield (row, column) -> Empty
    new Field(keyValues.toMap, Maru)
  }

}
