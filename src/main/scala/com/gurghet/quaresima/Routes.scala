package com.gurghet.quaresima

import java.time.LocalDate
import java.time.temporal.ChronoUnit

import cats.effect.IO
import com.gurghet.quaresima.Holidays.Holiday
import com.gurghet.quaresima.util.LocalDateVar
import doobie.util.transactor.Transactor
import io.circe.Json
import org.http4s.HttpService
import org.http4s.circe._
import org.http4s.dsl.Http4sDsl
import doobie.implicits._

object Routes extends Http4sDsl[IO] {
  implicit val xa = Transactor.fromDriverManager[IO]("org.h2.Driver", "jdbc:h2:tcp://138.68.177.123/./test")
  val service = HttpService[IO] {
    case GET -> Root / "days" / LocalDateVar(firstDay) / LocalDateVar(lastDay) =>
      if (lastDay isBefore firstDay) {
        BadRequest(s"You selected from $firstDay to $lastDay, you’re going backward in time.")
      } else {
        val lengthInDays = ChronoUnit.DAYS.between(firstDay, lastDay).toInt
        val days = (0 to lengthInDays).map(d => {
          val localDate = firstDay.plusDays(d)
          val holidayArr = findHoliday(localDate).unsafeRunSync() match {
            case Some(holiday) => Json.arr(Json.fromString(holiday.description))
            case None => Json.arr()
          }
          Json.obj(
            "day" -> Json.fromString(localDate.toString),
            "dayOfWeek" -> Json.fromInt(localDate.getDayOfWeek.getValue),
            "holiday" -> holidayArr)
        })
        Ok(Json.fromValues(days))
      }
  }
  def findHoliday(localDate: LocalDate)(implicit xa: Transactor[IO]): IO[Option[Holiday]] = {
    Holidays.find(localDate).transact(xa)
  }
}
