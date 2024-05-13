package oops
package oops

abstract class LList[A] {
  def head: A
  def tail: LList[A]
  def isEmpty: Boolean
  def add(value: A): LList[A]

  override def toString: String = super.toString
}

class SLList[A](override val head: A, override val tail: LList[A]) extends LList[A]{
  override def isEmpty: Boolean = false
  override def add(value: A): LList[A] = new SLList(value,this)

  override def toString: String = {
    def traverse(ll: LList[A], accumulator: String):String = {
      if(!ll.isEmpty)
        traverse(ll.tail, s"$accumulator ${ll.head}")
      else accumulator
    }
    s"[${traverse(this.tail, s"$head")}]"
  }
}

class Empty[A] extends LList[A]{
  override def head: A = throw new NoSuchElementException
  override def tail: LList[A] = throw new NoSuchElementException

  override def isEmpty: Boolean = true
  override def add(value: A): LList[A] = new SLList(value,this)

  override def toString: String = "[]"
}
/*
Exercise: LList extension
1. Generic trait Predicate[T] with a little method test(T) => Boolean
2. Generic trait Transformer[A, B] with a method transform (A) => B
3. LList:
  - map (transformer) => LList[B]
  - filter(predicate) => LList[A]
  - flatMap(transformer from A to LList[B]) => LList[B]
  class EvenPredicate extends Predicate[Int]
  class StringToIntTransformer extends Transformer[String, Int]
  [1,2, 3]. map (n * 2) = [2,4,6]
  [1,2,3, 4]. filter(n % 2) = [2,4]
  [1,2, 3].flatMap(n => [n, n+1]) => [1, 2,2,3, 3, 4]
 */

trait Transform[A]
{
//  def map(lList: LList[A],): LList[A] = {
//    def traverseTailRecn(head: LList[A]): LList[A] = {
//      if(!head.isEmpty)
//      {
//        head.head
//      }
//
//    }
//  }
}
object LListTest {

  def main(args: Array[String]): Unit = {
    val intLinkedList = new SLList(3, new SLList(2, new SLList(1, new Empty)))

//    List(1,2).map()
    println(intLinkedList)

    val stringLL = new Empty[String]
    val stringLinkedList = stringLL.add("-1").add("2-").add("3-").add("4-")
    println(stringLinkedList)
  }
}

