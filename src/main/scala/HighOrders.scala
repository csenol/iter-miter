package scalatr

import Mappers._
import Folders._
as;as;sa,sda
object HighOrders {

  val listNumbers = 1::2::3::4::5::Nil
  val listStrings = List("1", "2", "3", "4", "5")

  def add1(x: Int) = x + 1
  def mul2(x: Int) = x * 2
  def toInt(x: String) = x.toInt

  def sum(a:Int, b:Int) = a + b

  val result1 = listStrings.map(toInt).fold(0)(sum)
  println(result1 == 15)

  val result2 = listStrings.map((x: String) =>x.toInt).fold(0)((x:Int, y:Int) => x + y)
  println(result2 == 15)

  val result3 = listStrings.map(_.toInt).fold(0)( _ + _)
  println(result3 == 15)

  //dosyadaki sayilari toplama
  val file = scala.io.Source.fromFile("/tmp/hede")
  val fileResult = file.getLines().map(_.toInt).fold(0)(_ + _)
  file.close()
}
