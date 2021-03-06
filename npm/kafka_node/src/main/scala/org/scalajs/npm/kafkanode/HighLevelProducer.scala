package org.scalajs.npm.kafkanode

import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * Kafka-Node High-level Producer
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HighLevelProducer extends KafkaNodeEventListener {

  /**
    * @example createTopics(topics, [async,] callback)
    */
  def createTopics(topics: js.Array[String], async: Boolean, callback: js.Function): Unit = js.native

  /**
    * @example createTopics(topics, [async,] callback)
    */
  def createTopics(topics: js.Array[String], callback: js.Function): Unit = js.native

  /**
    * @example send(payloads, callback)
    */
  def send(payloads: js.Array[Payload], callback: js.Function): Unit = js.native

}

/**
  * High-level Producer Companion
  * @author lawrence.daniels@gmail.com
  */
object HighLevelProducer {

  /**
    * High Level Producer Extensions
    * @param producer the given [[Producer producer]]
    */
  implicit class HighLevelProducerExtensions(val producer: HighLevelProducer) extends AnyVal {

    /**
      * @see [[HighLevelProducer.createTopics()]]
      */
    def createTopicsAsync(topics: js.Array[String], async: Boolean) = futureCallbackE1[js.Error, js.Any](producer.createTopics(topics, async, _))

    /**
      * @see [[HighLevelProducer.send()]]
      */
    def sendAsync(payloads: js.Array[Payload]) = futureCallbackE1[js.Error, js.Any](producer.send(payloads, _))

    /**
      * @see [[HighLevelProducer.on()]]
      */
    def onError(callback: js.Function) = producer.on("error", callback)

    /**
      * @see [[HighLevelProducer.on()]]
      */
    def onReady(callback: js.Function) = producer.on("ready", callback)

  }

}