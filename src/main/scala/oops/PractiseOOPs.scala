package oops

object PractiseOOPs extends App {
  class Person(val name: String, age: Int = 10) {
    def +(person: Person): String =
      s"${this.name} and ${person.name} are together"

    /* use of infix is strictly important from scala 3.1,
       so if we want to use a function with one arg only to be used like this : obj funcName arg, instead of: obj.funcName(arg).
       it would be: infix def greet(person: Person) */
    protected def sayHi() = {
      s"Hi, my name is $name."
    }

    def greet(person: Person) = {
      s"${this.name} says hello to ${person.name}"
    }

    def unary_- : String = s"$name with unary" // prefix, with this we can have any prefix for an object.
  }

  // protected == access to inside the class + children classes
  class Kid(override val name: String,private var age: Int = 0) extends Person(name) {
    def greetPolitely(): String = // no modifier = "public
      sayHi() + " " + "I love to play!"

    def setAge(age: Int): Unit = this.age = age
  }

  aKid eq aPerson // in scala gives out put as false
  aKid equals aPerson // similar in java gives as false

  val aPerson = new Person("Alice")
  val aKid = new Kid("David")
  println(aKid.greetPolitely() + aKid)
  val harry = new Person("Harry")
  val perry = new Person("Perry")
  aKid.setAge(10)
  println(harry + perry)
  println(harry greet perry)
  println(-harry) // also as println(harry.unary_-).
}
