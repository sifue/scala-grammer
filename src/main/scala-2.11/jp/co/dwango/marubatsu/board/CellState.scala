package jp.co.dwango.marubatsu.board

private[marubatsu] trait CellState {

  protected def next: CellState

}

private[marubatsu] case object Empty extends CellState {

  private[board] def next: CellState = Empty

}

private[marubatsu] case object Maru extends CellState {

  private[board] def next: CellState = Batsu

}

private[marubatsu] case object Batsu extends CellState {

  private[board] def next: CellState = Maru

}