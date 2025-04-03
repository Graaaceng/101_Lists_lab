class LinkedList {
  var head: Node = null

  def addToStart(s: String): Unit ={
    head = new Node(s, head)
  }

  def getSize(): Int = {
    var tmp: Node = this.head
    var count = 0
    while (tmp != null){
      count += 1
      tmp = tmp.next
    }
    return count
  }

  override def toString: String = {
    var list: String = ""
    var tmp: Node = this.head
    while(tmp != null){
      list += s"${tmp.item} -> "
      tmp = tmp.next
    }
    s"List Content (size ${this.getSize}): ${list}null"
  }
}

object LinkedList extends App {
  var flightList:LinkedList = new LinkedList()
  println(flightList)
  flightList.addToStart("Rome")
  println(flightList)
  flightList.addToStart("Paris")
  println(flightList)
  flightList.addToStart("Tokyo")
  println(flightList)
  }
