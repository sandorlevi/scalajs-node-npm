package org.scalajs.npm.kafkarest

import org.scalajs.nodejs.errors
import org.scalajs.nodejs.util.ScalaJsHelper._

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Topic Partition
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Partition extends js.Object {

  def produce[T](messages: KeyedMessage | js.Any, callback: js.Function2[errors.Error, T, Any]): Unit = js.native

}

/**
  * Topic Partition Companion
  * @author lawrence.daniels@gmail.com
  */
object Partition {

  /**
    * Topic Partition Enrichment
    * @param partition the given [[Partition topics partition]]
    */
  implicit class TopicPartitionEnrichment(val partition: Partition) extends AnyVal {

    @inline
    def produceFuture[T](messages: KeyedMessage | js.Any) = {
      futureCallbackE1[errors.Error, T](partition.produce(messages, _))
    }

  }

}