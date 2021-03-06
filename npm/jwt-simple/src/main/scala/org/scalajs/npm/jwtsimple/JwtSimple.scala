package org.scalajs.npm
package jwtsimple

import org.scalajs.nodejs.{NodeModule, NodeRequire}

import scala.scalajs.js

/**
  * jwt-simple - JWT(JSON Web Token) encode and decode module
  * @see [[https://www.npmjs.com/package/jwt-simple]]
  * @version 0.5.0
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait JwtSimple extends NodeModule {

  /**
    * Decodes the token using the specified secret
    * @param token  the given token to decode
    * @param secret the given secret
    * @example jwt.decode(token, secret)
    */
  def decode(token: JwtToken, secret: String): js.Any = js.native

  /**
    * Decodes the token using the specified secret and algorithm
    * @param token            the given token to decode
    * @param secret           the given secret
    * @param skipVerification if true, decode without verify the signature of the token
    * @example jwt.decode(token, secret, true)
    */
  def decode(token: JwtToken, secret: String, skipVerification: Boolean): js.Any = js.native

  /**
    * Decodes the token using the specified secret and algorithm
    * @param token            the given token to decode
    * @param secret           the given secret
    * @param skipVerification if true, decode without verify the signature of the token
    * @param algorithm        The supported algorithms for encoding and decoding are HS256, HS384, HS512 and RS256.
    * @example jwt.decode(token, secret, true)
    */
  def decode(token: JwtToken, secret: String, skipVerification: Boolean, algorithm: Algorithm): js.Any = js.native

  /**
    * Encodes the payload using the specified secret
    * @param payload the given payload to encode
    * @param secret  the given secret
    * @example jwt.encode(payload, secret)
    */
  def encode(payload: js.Any, secret: String): JwtToken = js.native

  /**
    * Encodes the payload using the specified secret and algorithm
    * @param payload   the given payload to encode
    * @param secret    the given secret
    * @param algorithm The supported algorithms for encoding and decoding are HS256, HS384, HS512 and RS256.
    * @example jwt.encode(payload, secret, "HS512")
    */
  def encode(payload: js.Any, secret: String, algorithm: Algorithm): JwtToken = js.native

}

/**
  * JwtSimple Companion
  * @author lawrence.daniels@gmail.com
  */
object JwtSimple {

  /**
    * Convenience method for retrieving the 'jwt-simple' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the JwtSimple instance
    */
  def apply()(implicit require: NodeRequire) = require[JwtSimple]("jwt-simple")

  /**
    * JwtSimple Extensions
    * @author lawrence.daniels@gmail.com
    */
  final implicit class JwtSimmpleExtensions(val jwt: JwtSimple) extends AnyVal {

    def decodeAs[T <: js.Any](token: JwtToken, secret: String, skipVerification: Boolean = false, algorithm: Algorithm = HS256): T = {
      jwt.decode(token, secret, skipVerification, algorithm).asInstanceOf[T]
    }

  }

}