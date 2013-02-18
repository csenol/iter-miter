package scalatr

import scala.concurrent._
import play.api.libs.iteratee.{Enumerator,Enumeratee,Iteratee}
import ExecutionContext.Implicits.global

object Iter2{
  
  def enumFromFile(path:String) = {
    val r = new java.io.BufferedReader( new java.io.FileReader(path))
    
    Enumerator.fromCallback1( b => {
      val line = r.readLine
      val chunk = if(line == null) None else Some(line)
      scala.concurrent.Future.successful(chunk)
    }, r.close			     )
  }

  val intMapper = Enumeratee.map( (x:String) => x.toInt)

  val sum = Iteratee.fold(0)((x:Int, y:Int) => x + y)


  //lazy val res = e |>>> toInt &>> sum
  
  //res.onFailure{ case t => println(t.getCause + " mesaj " + t.getMessage()) }
  //res.onSuccess{ case t => println(t)}
}
