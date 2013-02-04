package scalatr

object Mappers {

  val list = 1::2::3::4::5::Nil

  //
  val add1 = (x:Int) => x + 1
  val mul2 = (x:Int) => x * 2
  
  
// Yeni bir pattern
  def add1ToAll(lon:List[Int]): List[Int] = 
    lon match {
      case Nil => Nil //Pattern 1
      case x::xs => add1(x) :: add1ToAll(xs) //Pattern 2
    }

  
  def mul2WithAll(lon:List[Int]): List[Int] = 
    lon match {
      case Nil => Nil //Pattern 1
      case x::xs => mul2(x) :: mul2WithAll(xs) //Pattern 2
    }

  
  def mapper[A,B](f: A => B)(loa:List[A]): List[B] = 
    loa match {
      case Nil => Nil //Pattern 1
      case x::xs => f(x) :: mapper(f)(xs) //Pattern 2
    }
}
