package scalatr

object Folders {

  val list = 1::2::3::4::5::Nil

  def sum (a:Int, b:Int) = a + b
  def mul (a:Int, b:Int) =  a * b
  def concat (a:Int, b:String) = a.toString + b

  def listSum(lon:List[Int]): Int = {
    lon match {
      case Nil => 0 // Pattern 1
      case x::xs => sum(x , listSum(xs)) //Pattern 2
    }
  }
  
  def listMul(lon:List[Int]): Int = 
    lon match {
      case Nil => 1 // Pattern 1
      case x::xs => mul(x , listMul(xs)) //Pattern 2
    }
  
  def listConcat(lon:List[Int]): String = 
    lon match {
      case Nil => "" // Pattern 1
      case x::xs => concat(x, listConcat(xs)) //Pattern 2
    }

  //Hepsi Int yine bir pattern
  def fold1(z:Int)(f: (Int,Int) => Int)(lon:List[Int]) : Int = 
    lon match {
      case Nil => z 
      case x::xs => f(x , fold1(z)(f)(xs)) 
    }
  
  def fold2[A](z:A)(f: (A,A) => A)(lon:List[A]) : A = 
    lon match {
      case Nil => z // Pattern 1
      case x::xs => f(x , fold2(z)(f)(xs)) //Pattern 2
    }
  // Int => Int calisacak. Ama listConcat calismayacak
  
  def folder[A,B](z:B)(f: (A,B) => B)(loa:List[A]) : B = 
    loa match {
      case Nil => z // Pattern 1
      case x::xs => f(x , folder(z)(f)(xs)) //Pattern 2
    }


}
