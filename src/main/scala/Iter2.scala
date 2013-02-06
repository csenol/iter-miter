package scalatr

import play.api.libs.iteratee.{Enumerator,Enumeratee,Iteratee}

object Iter2 {
  
  val r = new java.io.BufferedReader( new java.io.FileReader("/tmp/hede"))

  val e = Enumerator.generateM{
    val line = r.readLine
    val chunk = if(line == null) None else Some(line)
    scala.concurrent.Future.successful(chunk)
  }

  val toInt = Enumeratee.map( (x:String) => x.toInt)

  val sum = Iteratee.fold(0)((x:Int, y:Int) => x + y)

  
}
