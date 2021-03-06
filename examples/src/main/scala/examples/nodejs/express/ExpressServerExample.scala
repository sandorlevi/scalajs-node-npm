package examples.nodejs.express

import org.scalajs.nodejs._
import org.scalajs.nodejs.express._
import org.scalajs.dom.console
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.express.{Express, Request, Response}

import scala.scalajs.js

/**
  * Express Server Example
  * @author lawrence.daniels@gmail.com
  */
class ExpressServerExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val express = Express()
  val app = express()

  app.get("/", (req: Request, res: Response) => {
    res.send("Hello World")
  })

  val server = app.listen(8081, connect)

  private def connect: js.Function = () => {
    val host = server.address().address
    val port = server.address().port

    console.log("Example app listening at http://%s:%s", host, port)
  }

}
