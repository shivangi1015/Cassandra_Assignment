
object MainValues extends App {

  val userValues = new QueryMethods
  userValues.userByEmail("shivangi1015@gmail.com")
  userValues.videoByName("myVideo")
  userValues.videoByYear()
  userValues.videoById(2)
}
