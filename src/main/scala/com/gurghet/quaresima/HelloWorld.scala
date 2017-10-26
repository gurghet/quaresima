package com.gurghet.quaresima

import io.circe._
import org.http4s._
import org.http4s.circe._
import org.http4s.server._
import org.http4s.dsl._
import org.http4s.MediaType._

object HelloWorld {
  val service = HttpService {
    case GET -> Root / "hello" / name =>
      Ok("""<h2 style="font-size:200">Ciao Ania2!</h2>""").withContentType(Some(`text/html`))
      //Ok(Json.obj("message" -> Json.fromString(s"Hello, ${name}")))
  }
}
