package oops

abstract class LList {
  def head: Int
  def tail: LList
  def isEmpty: Boolean
  def add(value: Int): LList

  override def toString: String = super.toString
}

class SLList(override val head: Int, override val tail: LList) extends LList{
  override def isEmpty: Boolean = false
  override def add(value: Int): LList = new SLList(value,this)

  override def toString: String = {
    def traverse(ll: LList, accumulator: String):String = {
      if(!ll.isEmpty)
        traverse(ll.tail, s"$accumulator ${ll.head}")
      else accumulator
    }
    s"[${traverse(this.tail, s"$head")}]"
  }
}

class Empty extends LList{
  override def head: Int = throw new NoSuchElementException
  override def tail: LList = throw new NoSuchElementException

  override def isEmpty: Boolean = true
  override def add(value: Int): LList = new SLList(value,this)

  override def toString: String = "[]"
}

object LListTest {

  def main(args: Array[String]): Unit = {
    val ll = new Empty
    val linkedList = ll.add(3).add(2).add(1).add(0)
    println(linkedList)
  }
}