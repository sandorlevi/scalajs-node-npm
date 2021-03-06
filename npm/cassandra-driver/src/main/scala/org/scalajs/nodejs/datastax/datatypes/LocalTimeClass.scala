package org.scalajs.nodejs.datastax.datatypes

import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.datastax.datatypes.LocalTimeClass.LocalTime
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * Cassandra Local Time class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LocalTimeClass extends js.Object {

  def fromBuffer(buffer: Buffer): LocalTime = js.native

  def fromDate(date: js.Date): LocalTime = js.native

  def fromMilliseconds(millis: Double): LocalTime = js.native

  def fromString(string: String): LocalTime = js.native

  def now(): LocalTime = js.native

}

/**
  * Cassandra Local Time Class Companion
  * @author lawrence.daniels@gmail.com
  */
object LocalTimeClass {

  /**
    * Cassandra Local Time instance
    */
  @js.native
  trait LocalTime extends js.Any

  /**
    * Cassandra Local Time Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class CassandraLocalTimeClassExtensions(val `class`: LocalTimeClass) extends AnyVal {

    @inline
    def apply(year: Int, month: Int, day: Int) = `class`.New[LocalTime](year, month, day)

  }

}