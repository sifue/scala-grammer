package jp.co.dwango.marubatsu.field

private[marubatsu] trait CellState {

  private[field] def next: CellState

}

private[marubatsu] case object Empty extends CellState {

  private[field] def next: CellState = Empty

}

private[marubatsu] case object Maru extends CellState {

  private[field] def next: CellState = Batsu

}

private[marubatsu] case object Batsu extends CellState {

  private[field] def next: CellState = Maru

}