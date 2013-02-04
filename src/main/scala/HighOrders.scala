package scalatr

import Mappers._
import Folders._

object HighOrders extends App {

  val list = 1::2::3::4::5::Nil
  
  //kotu cunku syntax kotu duruyor
  // ayrica add1 ve mul2 yapacagimiz her liste icin uzun uzun yazmamiz lazim
  val mapped = mapper(add1)(mapper(mul2)(list))
  println(mapped)

  val mappedComposed = mapper(add1)_ compose mapper(mul2)_

  println(mappedComposed(list))
  
  //function composition f(g(x))
  val addMul = add1 compose mul2

  //herhangi bir listeyi tek seferde once 2 ile carpip sonra 1 ekleyen fosnkiyon
  val mapAddMul = mapper(addMul) _
  
  println(mapAddMul(list))

  //herhangi bir listeyi concat edebilecek fonksiyon
  val concaterFolder = folder(".")(concat)_

  val concated = concaterFolder(mapAddMul(list))

  println(concated)

  //Bu sekilde dosyalardan ya da herhangi bir yerden bir veriyi okuyup
  // memory e liste seklinde alip
  //isleyebiliriz

  //Ancak hem memory harciyoruz hem de blocking isler yapiyoruz

}
