package scalatr

//import play.api.libs.iteratee._
import play.api.libs.iteratee.{Iteratee, Enumerator, Enumeratee}

object Iter1 {

  //Enumerator lar listeler gibi ancak, Memoryde yer tutmuyorlar
  // ve map ve fold isleri non-blocking yapabiliyoruz
  val l = Enumerator(1,2,3,4,5)

  val add1 = Enumeratee.map( (x:Int) => x + 1)
  val mul2 =  Enumeratee.map( (x:Int) => x * 2)

  val sum = Iteratee.fold(0)( (x:Int, y:Int) =>  x + y)

  val printer = Iteratee.foreach(println _)

  val addMul = add1.compose(mul2)

  //fish operator ile yukaridakinin aynisi
  //alias
  val addMul2 = add1 ><> mul2

  //map ediyoruz ve ardindan fold luyoruz
  
  //apply alias i da &>> 
  val consume = addMul2 &>> sum 
  
  //en son listeyi tuketiyoruz
  //f artik bir future deger
  val f = l |>>> consume 

  val f2 =  l |>>> add1 ><> mul2 &>> sum
    
 
  //

}






