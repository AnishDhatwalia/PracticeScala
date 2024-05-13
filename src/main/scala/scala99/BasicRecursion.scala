package scala99

object BasicRecursion {
  def last[A](list: List[A]): A = {
    list match {
      case li::Nil => li
      case _::tail => last(tail)
      case Nil => throw new NoSuchElementException
    }
  }

  def secondLast[A](list: List[A]): A = {
    list match {
      case li::_::Nil => li
      case _::tail => secondLast(tail)
      case Nil => throw new NoSuchElementException
    }
  }

  def kthElement[A](k: Int, list: List[A]): A = {
//    if(k == 0)
//      list.headOption.getOrElse(throw new NoSuchElementException)
//    else kthElement(k-1,list.tail)

    (k, list) match {
      case (0,li::_) => li
      case (k, _::tail) => kthElement(k-1, tail)
      case (_, Nil) => throw new NoSuchElementException
    }
  }

  def sizeOfList[A](list: List[A], accumulator: Int = 0): Int = {
    list match {
      case _::tail => sizeOfList(tail,accumulator+1)
      case Nil => accumulator
    }
  }

  def reverseList[A](list: List[A], reversedList: List[A] = List()): List[A] = {
    list match {
      case Nil => reversedList
      case head::tail => reverseList(tail, head+:reversedList)
    }
  }

  def sliceList[A](innerBound: Int, outerBound: Int, list: List[A], counter: Int = 0, accumulator: List[A] = List()): List[A] = {
    if(list.isEmpty || outerBound <= counter)
      accumulator
    else
      sliceList(innerBound, outerBound, list.tail, counter+1,if(innerBound <= counter) accumulator:+list.head else accumulator)
  }

  def flattenList(list: Any, accumulator: List[Any] = List()): List[Any] = {
    list match {
      case Nil => accumulator
      case li: Int =>
        accumulator:+li
      case nestedList: List[Any] =>
        nestedList.map(nestedL=> flattenList(nestedL, accumulator)).flatten
    }
  }

  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case ms: List[_] => flatten(ms)
    case e => List(e)
  }

  def compressList[A](list: List[A], accumulator: List[A] = Nil): List[A] = {
    list match {
      case Nil => accumulator
      case x::tail => compressList(tail.dropWhile(_ == x),accumulator:+ x)
    }
  }

  def main(args: Array[String]):Unit = {
    val tempList = List(3,2,1,4,3,2,1,67,45,3,3,7,8,778,8,888,9,577)
    val tempList2 =List(1,2,3,4)
    val tempNestedList: List[Any] = List(List(1,2,3,4),123,List(List(1,2,3),4))
    val listFlatMap: List[List[Int]] = List(List(1,2,3), List(3,4),List(1,5))
    println(last(tempList))
    println(secondLast(tempList))
    println(kthElement(3,tempList2))
    println(sizeOfList(tempList2))
    println(reverseList(tempList))
    println(sliceList(1,28,tempList))
    println(tempList drop 3 dropRight (tempList.size - (5 max 0)))
    println(tempList drop 3 take (5 - (3 max 0)))
    println(tempList.span((x)=> x<500))
    println(flattenList(tempNestedList))
    println(listFlatMap.flatMap(x=>x))
    println(compressList(List(1,1,1,1,2,2,3,4,4,5)))
  }
}
