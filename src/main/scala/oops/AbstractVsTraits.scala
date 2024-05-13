package oops

object AbstractVsTraits {
  abstract class Animal {       // for a thing
    def eat(): List[String]
  }

  abstract class LandAnimal {
    def speed: Int
  }

//  only one abstract class can be inherited at once for a class
//  multiple traits can be inherited at once

  class Lion extends LandAnimal {       //it can extend only 1 abstract class
    //    override def eat() = "Anything"
    override def speed: Int = 20
  }
/*
    philosophical difference abstract classes vs traits
    - abstract classes are THINGS
    - traits are BEHAVIORS
*/

  trait Carnivores        // mostly for behaviour of something

  trait WaterBeings

  class Dolphin extends Animal with Carnivores with WaterBeings {     //multiple inheritance of traits
    override def eat(): List[String] = List("fish","crabs")
  }

  /*
    Any
      AnyRef
      All classes we write
        Strings, Set, Map etc
          scala.Null (the null reference)
      AnyVal
      Int, Boolean, Char, ...

        scala.Nothing
*/

  val dolphin: Dolphin = null
  val nothing: Boolean = throw new Exception("Nothing")
}
