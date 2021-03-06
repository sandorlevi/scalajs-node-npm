package org.scalajs.nodejs.mongodb.gridfs

import org.scalajs.nodejs.mongodb._
import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.mongodb.{Db, MongoError}
import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.mongodb.Collection

import scala.scalajs.js

/**
  * Grid Store
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait GridStore extends EventEmitter {

  /////////////////////////////////////////////////////////////////////////////////
  //      Constructor Fields
  /////////////////////////////////////////////////////////////////////////////////

  /** A database instance to interact with. */
  var db: js.UndefOr[MongoDB] = js.native

  /** optional unique id for this file */
  var id: js.UndefOr[js.Any] = js.native

  /** optional filename for this file, no unique constrain on the field */
  var filename: js.UndefOr[String] = js.native

  /** set the mode for this file. */
  var mode: js.UndefOr[String] = js.native

  /** optional properties to specify. */
  var options: js.UndefOr[GridStoreOptions] = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns the current chunk size of the file.
    */
  var chunkSize: Integer = js.native

  /**
    * The md5 checksum for this file.
    */
  var md5: Integer = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Retrieve this file’s chunks collection.
    */
  def chunkCollection(callback: js.Function): Unit = js.native

  /**
    * Saves this file to the database. This will overwrite the old entry if it already exists. This will work
    * properly only if mode was initialized to “w” or “w+”.
    */
  def close(callback: js.Function): Unit = js.native

  /**
    * Retrieves the file collection associated with this object.
    */
  def collection(callback: js.Function): Unit = js.native

  /**
    * Verify if the file is at EOF.
    */
  def eof(): Boolean = js.native

  /**
    * Retrieves a single character from this file.
    */
  def getc(callback: js.Function): Unit = js.native

  /**
    * Opens the file from the database and initialize this object. Also creates a new one if file does not exist.
    */
  def open(callback: js.Function): Unit = js.native

  /**
    * Writes a string to the file with a newline character appended at the end if the given string does not have one.
    * @example puts(string, callback)
    */
  def puts(string: String, callback: js.Function): Unit = js.native

  /**
    * Retrieves the contents of this file and advances the read/write head. Works with Buffers only.
    * @example read([length][, buffer], callback)
    */
  def read(length: Int, buffer: Buffer, callback: js.Function): Unit = js.native

  /**
    * Retrieves the contents of this file and advances the read/write head. Works with Buffers only.
    * @example read([length][, buffer], callback)
    */
  def read(buffer: Buffer, callback: js.Function): Unit = js.native

  /**
    * Retrieves the contents of this file and advances the read/write head. Works with Buffers only.
    * @example read([length][, buffer], callback)
    */
  def read(callback: js.Function): Unit = js.native

  /**
    * Reads the data of this file.
    * @example readlines([separator], callback)
    */
  def readlines(separator: String, callback: js.Function): Unit = js.native

  /**
    * Reads the data of this file.
    * @example readlines([separator], callback)
    */
  def readlines(callback: js.Function): Unit = js.native

  /**
    * Deletes all the chunks of this file in the database if mode was set to “w” or “w+” and resets the read/write
    * head to the initial position.
    */
  def rewind(callback: js.Function): Unit = js.native

  /**
    * Retrieves the position of the read/write head of this file.
    * @param length   the number of characters to read. Reads all the characters from the read/write head to the
    *                 EOF if not specified (optional).
    * @param buffer   a String or Buffer to hold temporary data. This is used for storing the string data read so far when
    *                 recursively calling this method (optional).
    * @param callback the command callback.
    * @example tell(length, buffer, callback)
    */
  def tell(length: Int, buffer: Buffer, callback: js.Function2[MongoError, Int, Any]): Unit = js.native

  /**
    * Retrieves the position of the read/write head of this file.
    * @param length the number of characters to read. Reads all the characters from the read/write head to the
    *               EOF if not specified (optional).
    * @param buffer a String or Buffer to hold temporary data. This is used for storing the string data read so far when
    *               recursively calling this method (optional).
    * @example tell(length, buffer, callback)
    */
  def tell(length: Int, buffer: Buffer): js.Promise[Int] = js.native

  /**
    * Retrieves the position of the read/write head of this file.
    * @param length   the number of characters to read. Reads all the characters from the read/write head to the
    *                 EOF if not specified (optional).
    * @param buffer   a String or Buffer to hold temporary data. This is used for storing the string data read so far when
    *                 recursively calling this method (optional).
    * @param callback the command callback.
    * @example tell(length, buffer, callback)
    */
  def tell(length: Int, buffer: String, callback: js.Function2[MongoError, Int, Any]): Unit = js.native

  /**
    * Retrieves the position of the read/write head of this file.
    * @param length the number of characters to read. Reads all the characters from the read/write head to the
    *               EOF if not specified (optional).
    * @param buffer a String or Buffer to hold temporary data. This is used for storing the string data read so far when
    *               recursively calling this method (optional).
    * @example tell(length, buffer, callback)
    */
  def tell(length: Int, buffer: String): js.Promise[Int] = js.native

  /**
    * Retrieves the position of the read/write head of this file.
    * @example tell(length, buffer, callback)
    */
  def tell(): js.Promise[Int] = js.native

  /**
    * Moves the read/write head to a new location.
    * Seek Location Modes:
    * <ul>
    * <li>GridStore.IO_SEEK_SET, (default) set the position from the start of the file.</li>
    * <li>GridStore.IO_SEEK_CUR, set the position from the current position in the file.</li>
    * <li>GridStore.IO_SEEK_END, set the position from the end of the file.</li>
    * </ul>
    * @example seek([position][, seekLocation], callback)
    */
  def seek(position: Int, seekLocation: Int, callback: js.Function): Unit = js.native

  /**
    * Moves the read/write head to a new location.
    * Seek Location Modes:
    * <ul>
    * <li>GridStore.IO_SEEK_SET, (default) set the position from the start of the file.</li>
    * <li>GridStore.IO_SEEK_CUR, set the position from the current position in the file.</li>
    * <li>GridStore.IO_SEEK_END, set the position from the end of the file.</li>
    * </ul>
    * @example seek([position][, seekLocation], callback)
    */
  def seek(seekLocation: Int, callback: js.Function): Unit = js.native

  /**
    * Moves the read/write head to a new location.
    * Seek Location Modes:
    * <ul>
    * <li>GridStore.IO_SEEK_SET, (default) set the position from the start of the file.</li>
    * <li>GridStore.IO_SEEK_CUR, set the position from the current position in the file.</li>
    * <li>GridStore.IO_SEEK_END, set the position from the end of the file.</li>
    * </ul>
    * @example seek([position][, seekLocation], callback)
    */
  def seek(callback: js.Function): Unit = js.native

  /**
    * Returns read stream based on this GridStore file.
    */
  def stream(): GridStoreStream = js.native

  /**
    * Returns read stream based on this GridStore file.
    * @param autoclose if true current GridStore will be closed when EOF and ‘close’ event will be fired
    */
  def stream(autoclose: Boolean): GridStoreStream = js.native

  /**
    * Deletes all the chunks of this file in the database.
    */
  def unlink(callback: js.Function): Unit = js.native

  /**
    * Writes some data. This method will work properly only if initialized with mode “w” or “w+”.
    * @example write(data[, close], callback)
    */
  def write(data: Buffer, close: Boolean, callback: js.Function): Unit = js.native

  /**
    * Writes some data. This method will work properly only if initialized with mode “w” or “w+”.
    * @example write(data[, close], callback)
    */
  def write(data: String, close: Boolean, callback: js.Function): Unit = js.native

  /**
    * Writes some data. This method will work properly only if initialized with mode “w” or “w+”.
    * @example write(data[, close], callback)
    */
  def write(data: Buffer, callback: js.Function): Unit = js.native

  /**
    * Writes some data. This method will work properly only if initialized with mode “w” or “w+”.
    * @example write(data[, close], callback)
    */
  def write(data: String, callback: js.Function): Unit = js.native

  /**
    * Stores a file from the file system to the GridFS database.
    */
  def writeFile(file: String, callback: js.Function): Unit = js.native

}

/**
  * Grid Store Companion
  * @author lawrence.daniels@gmail.com
  */
object GridStore {

  /**
    * Grid Store Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class GridStoreExtensions(val gridStore: GridStore) extends AnyVal {

    /**
      * Retrieve this file’s chunks collection.
      */
    @inline
    def chunkCollectionFuture() = callbackMongoFuture[Collection](gridStore.chunkCollection)

    /**
      * Saves this file to the database. This will overwrite the old entry if it already exists. This will work
      * properly only if mode was initialized to “w” or “w+”.
      */
    @inline
    def closeFuture() = callbackMongoFuture[js.Any](gridStore.close)

    /**
      * Retrieves the file collection associated with this object.
      */
    @inline
    def collectionFuture() = callbackMongoFuture[js.Any](gridStore.collection)

    /**
      * Retrieves a single character from this file.
      */
    @inline
    def getcFuture() = callbackMongoFuture[String](gridStore.getc)

    /**
      * Opens the file from the database and initialize this object. Also creates a new one if file does not exist.
      */
    @inline
    def openFuture() = callbackMongoFuture[Db](gridStore.open)

    /**
      * Writes a string to the file with a newline character appended at the end if the given string does not have one.
      */
    @inline
    def putsFuture(string: String) = callbackMongoFuture[GridStore](gridStore.puts(string, _))

    /**
      * Retrieves the contents of this file and advances the read/write head. Works with Buffers only.
      */
    @inline
    def readFuture[T <: js.Any](length: Int, buffer: Buffer) = callbackMongoFuture[js.Array[T]](gridStore.read(length, buffer, _))

    /**
      * Retrieves the contents of this file and advances the read/write head. Works with Buffers only.
      */
    @inline
    def readFuture[T <: js.Any](buffer: Buffer) = callbackMongoFuture[js.Array[T]](gridStore.read(buffer, _))

    /**
      * Retrieves the contents of this file and advances the read/write head. Works with Buffers only.
      */
    @inline
    def readFuture[T <: js.Any]() = callbackMongoFuture[js.Array[T]](gridStore.read)

    /**
      * Reads the data of this file.
      */
    @inline
    def readlinesFuture(separator: String) = callbackMongoFuture[js.Array[String]](gridStore.readlines(separator, _))

    /**
      * Reads the data of this file.
      */
    @inline
    def readlinesFuture = callbackMongoFuture[js.Array[String]](gridStore.readlines)

    /**
      * Deletes all the chunks of this file in the database if mode was set to “w” or “w+” and resets the read/write
      * head to the initial position.
      */
    @inline
    def rewindFuture() = callbackMongoFuture[js.Any](gridStore.rewind)

    /**
      * Moves the read/write head to a new location.
      */
    @inline
    def seekFuture(position: Int, seekLocation: Int) = callbackMongoFuture[GridStore](gridStore.seek(position, seekLocation, _))

    /**
      * Moves the read/write head to a new location.
      */
    @inline
    def seekFuture(seekLocation: Int) = callbackMongoFuture[GridStore](gridStore.seek(seekLocation, _))

    /**
      * Moves the read/write head to a new location.
      */
    @inline
    def seekFuture() = callbackMongoFuture[GridStore](gridStore.seek)

    /**
      * Deletes all the chunks of this file in the database.
      */
    @inline
    def unlinkFuture() = callbackMongoFuture[Boolean](gridStore.unlink)

    /**
      * Writes some data. This method will work properly only if initialized with mode “w” or “w+”.
      */
    @inline
    def writeFuture(data: Buffer, close: Boolean) = callbackMongoFuture[GridStore](gridStore.write(data, close, _))

    /**
      * Writes some data. This method will work properly only if initialized with mode “w” or “w+”.
      */
    @inline
    def writeFuture(data: String, close: Boolean) = callbackMongoFuture[GridStore](gridStore.write(data, close, _))

    /**
      * Writes some data. This method will work properly only if initialized with mode “w” or “w+”.
      */
    @inline
    def writeFuture(data: Buffer) = callbackMongoFuture[GridStore](gridStore.write(data, _))

    /**
      * Writes some data. This method will work properly only if initialized with mode “w” or “w+”.
      */
    @inline
    def writeFuture(data: String) = callbackMongoFuture[GridStore](gridStore.write(data, _))

    /**
      * Stores a file from the file system to the GridFS database.
      */
    @inline
    def writeFileFuture(file: String) = callbackMongoFuture[GridStore](gridStore.writeFile(file, _))

  }

}