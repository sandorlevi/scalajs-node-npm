package org.scalajs.nodejs

import org.scalajs.nodejs.express.Router
import org.scalajs.nodejs.express.Router

/**
  * Express-WS
  * @author lawrence.daniels@gmail.com
  */
package object expressws {

  /**
    * WsRouting Extensions
    * @param router the given [[Router router]]
    */
  implicit class WsRouterExtensions[T <: Router](val router: T) extends AnyVal {

    @inline
    def withWsRouting = router.asInstanceOf[T with WsRouting]

  }

}
