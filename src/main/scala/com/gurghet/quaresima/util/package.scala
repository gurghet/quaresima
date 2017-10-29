package com.gurghet.quaresima

import java.time.LocalDate

import scala.util.Try

package object util {
  object LocalDateVar {
    def unapply(str: String): Option[LocalDate] = {
      if (!str.isEmpty)
        Try(LocalDate.parse(str)).toOption
      else
        None
    }
  }
}
