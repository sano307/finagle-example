import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.http.{Request, Response, Status}
import com.twitter.finagle.http.Method.Get
import com.twitter.finagle.http.path.{->, /, Root}
import com.twitter.finagle.http.service.RoutingService
import com.twitter.util.{Await, Future}

object HttpServer extends App {

  val route: Service[Request, Response] = RoutingService.byMethodAndPathObject {
    case Get -> Root / "hello" => hello()
  }

  private[this] def hello() = new Service[Request, Response] {
    override def apply(req: Request): Future[Response] = {
      val rep = Response(req.version, Status.Ok)
      rep.setContentString("Hello")

      Future.value(rep)
    }
  }

  val server = Http.serve(":9001", route)

  Await.ready(server)

}
