package scalatr

object Mappers {

  val numberList = 1::2::3::4::5::Nil

  val stringList = "1"::"2"::"3"::"4"::Nil
 
  def add1(x: Int) = x + 1
  def mul2(x: Int) = x * 2
  def toInt(x: String) = x.toInt

  def add1ToAll(lon: List[Int]): List[Int] = 
    if(lon.isEmpty)
      Nil
    else
      add1(lon.head) :: add1ToAll(lon.tail)

  def mul2WithAll(lon: List[Int]): List[Int] = 
    lon match {
      case Nil => Nil //Pattern 1
      case x::xs => mul2(x) :: mul2WithAll(xs) //Pattern 2
    }

  def toIntAll(lon: List[String]): List[Int] = 
    lon match {
      case Nil => Nil //Pattern 1
      case x::xs => toInt(x) :: toIntAll(xs) //Pattern 2
    }
    
  def mapper[A,B](f: A => B)(loa:List[A]): List[B] = 
    loa match {
      case Nil => Nil //Pattern 1
      case x::xs => f(x) :: mapper(f)(xs) //Pattern 2
    }
}
