/**
  * Created by soichiro_yoshimura on 2016/06/23.
  */
object Graph {

  val matrix: Array[Array[Int]] = Array(
      Array(0, 1, 1, 0, 0),
      Array(1, 0, 0, 1, 0),
      Array(1, 0, 0, 1, 1),
      Array(0, 1, 1, 0, 1),
      Array(0, 0, 1, 1, 0)
    )

  case class Edge(from: Char, to: Char)

  val list = Seq(
      Edge('A', 'B'),
      Edge('B', 'A'),
      Edge('A', 'C'),
      Edge('C', 'A'),
      Edge('B', 'D'),
      Edge('D', 'B'),
      Edge('C', 'D'),
      Edge('D', 'D'),
      Edge('C', 'E'),
      Edge('E', 'C'),
      Edge('D', 'E'),
      Edge('E', 'D')
  )

}
