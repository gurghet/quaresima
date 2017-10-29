package com.gurghet.quaresima

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import doobie._
import doobie.implicits._

object Holidays {
  case class Holiday(localDay: LocalDate, description: String)
  object Holiday {
    def apply(day: String, description: String): Holiday = new Holiday(LocalDate.parse(day), description)
  }
  def find(day: LocalDate): ConnectionIO[Option[Holiday]] = {
    val localDateQ = day.format(DateTimeFormatter.ISO_DATE)
    sql"SELECT localDay, description FROM holiday WHERE localDay = $localDateQ".query[Holiday].option
  }
}