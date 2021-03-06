package org.scalajs.nodejs.mongodb

import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * Server Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ServerClass extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Constants
  /////////////////////////////////////////////////////////////////////////////////

  val READ_SECONDARY: String = js.native
  val READ_PRIMARY: String = js.native

}

/**
  * Server Class Companion
  * @author lawrence.daniels@gmail.com
  */
object ServerClass {

  /**
    * Server Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class ServerClassExtensions(val `class`: ServerClass) extends AnyVal {

    @inline
    def apply(host: String, port: Int) = `class`.New[Server](host, port)

  }

}