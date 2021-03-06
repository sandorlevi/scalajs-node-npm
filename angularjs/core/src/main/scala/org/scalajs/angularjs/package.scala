package org.scalajs

import scala.concurrent.duration.FiniteDuration
import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Angularjs Package Object
  * @author lawrence.daniels@gmail.com
  */
package object angularjs {

  //////////////////////////////////////////////////////////////
  //    Globals
  //////////////////////////////////////////////////////////////

  /**
    * Singleton "angular" instance
    */
  @js.native
  @JSName("angular")
  object angular extends Angular

  //////////////////////////////////////////////////////////////
  //    Implicit Conversions
  //////////////////////////////////////////////////////////////

  implicit def durationToInt(duration: FiniteDuration): Int = duration.toMillis.toInt

  implicit def durationToLong(duration: FiniteDuration): Double = duration.toMillis

}
