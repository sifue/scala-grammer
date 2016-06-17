/**
  * Created by soichiro_yoshimura on 2016/06/17.
  */
object BannerCreator {

  private val decor = ".｡:･・.｡:*･★.｡:･・.｡:*･★.｡:･・.｡:*･★.｡:･・.｡:*･★.｡:･・.｡:*･★"

  def create(message: String): String = {
    s"""${decor}
       |${message}
       |${decor}""".stripMargin
  }

}


object MessageContainer {
  var message = ""
}