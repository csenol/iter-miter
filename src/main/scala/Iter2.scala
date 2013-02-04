package scalatr

object Iter2 {
  

  val l = 1::2::3::4::5::6::Nil

  def acc( lst:List[Int]) = {
    def helper(consume:List[Int], accu:List[Int]) = {
      if(accu.size == 3)
	accu.reduce(_ + ) :: helper(consume, List[Int]())
      else if (consume.isEmpty)
	Nil
      else 
	helper(consume.tail, consume.head :: accu)
    }    
  }

}
