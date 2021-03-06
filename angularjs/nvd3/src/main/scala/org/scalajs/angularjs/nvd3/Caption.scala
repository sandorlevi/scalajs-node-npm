package org.scalajs.angularjs.nvd3

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * nvD3 Chart Caption
  * @author Lawrence Daniels <lawrence.daniels@gmail.com>
  */
@ScalaJSDefined
class Caption(val html: String,
              val enable: Boolean = true,
              val css: js.UndefOr[js.Dictionary[_ <: Any]] = js.undefined) extends js.Object