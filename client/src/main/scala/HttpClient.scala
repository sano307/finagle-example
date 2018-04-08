import com.twitter.finagle.{Http, Service}
import com.twitter.conversions.time._
import com.twitter.finagle.http.Method.Get
import com.twitter.finagle.http.Version.Http11
import com.twitter.finagle.http.{Request, Response}
import com.twitter.util.Await

object HttpClient extends App {

  val client: Service[Request, Response] = Http.client
    .withSession.acquisitionTimeout(100.millis)
    .withRequestTimeout(1.second)
    .newService("localhost:9001", "client")

  val req = Request(Http11, Get, "/hello")

  Await.result(
    client(req) onSuccess {
      req => println("Success: " + req.getContentString)
    } onFailure {
      e => println("Failure: " + e.getMessage)
    } ensure {
      println("Close client")
      client.close()
    }
  )

}
