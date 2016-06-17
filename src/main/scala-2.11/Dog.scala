/**
  * Created by soichiro_yoshimura on 2016/06/17.
  */
class Dog(name: String) {

  def greet(): Unit = println(s"${name}だワン")

}

object Taro extends Dog("タロウ")

object Dog {

  def apply(name: String) = new Dog(name)

}