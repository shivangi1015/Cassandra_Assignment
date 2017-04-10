import com.datastax.driver.core.Cluster

class QueryMethods {

  val cluster = Cluster.builder().addContactPoint("127.0.0.1").build()

  val session = cluster.connect("demo")

  /**
    * Selects user by given email
    *
    * @param email email id if the user
    */
  def userByEmail(email: String) = {
    val result = session.execute(s"SELECT * from user where email = '$email';")
    println("Selecting user by email : ")
    val iterate = result.iterator()
    while (iterate.hasNext) {

      println(iterate.next())

    }
  }

  /**
    * Selects video by the given video_name
    *
    * @param name name of the video to be selected
    */
  def videoByName(name: String) = {
    val result = session.execute(s"SELECT * FROM video WHERE video_name = '$name';")
    println("Selecting video by video_name : ")
    val iterate = result.iterator()
    while (iterate.hasNext) {

      println(iterate.next())

    }
  }

  /**
    * Selects videos that were uploaded after year 2017
    */
  def videoByYear() = {
    val result = session.execute("SELECT * FROM videobyyear WHERE year > 2015 ALLOW FILTERING ;")
    println("Selecting videos uploaded after 2015 : ")
    val iterate = result.iterator()
    while (iterate.hasNext) {

      println(iterate.next())

    }

  }

  /**
    * Selects video by user_id and records are selected in descending order by year
    *
    * @param userid
    */
  def videoById(userid: Int) = {
    val result = session.execute(s"SELECT * FROM videobyyear WHERE userid = $userid ORDER BY year DESC ;")
    println("Selecting videos by user_id : ")
    val iterate = result.iterator()
    while (iterate.hasNext) {

      println(iterate.next())

    }

  }
}
