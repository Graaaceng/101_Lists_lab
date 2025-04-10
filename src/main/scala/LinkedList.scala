import java.security.KeyStore.TrustedCertificateEntry

class LinkedList(var head: Node = null) {

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

  def removeFirstElement(): Unit = {
    if (head == null) return null
    head = head.next
  }

  def getLastElement(): Node = {
    var tmp : Node = this.head
    for (i <- 0 until this.getSize -1){ // -1 : avant dernier (last = null)
      tmp = tmp.next
    }
    return tmp

//    recursive method
//    if(head == null) return null
//    if(head.next == null) return head
//    new LinkedList(head.next).getLastElement()  -> need a constructor
  }

  def addToEnd(e: String): Unit = {
    if (getLastElement() == null) head = new Node(e, null)
    getLastElement().next = new Node(e, null)
  }

  def isPresent(e: String): Boolean = {
    if(this.head == null) return false
    if(this.head.item == e) return true
    new LinkedList(head.next).isPresent(e)
  }

  def findElement(e:String): Node = {
    if (this.head == null) return null
    if (this.head.item == e) return head
    new LinkedList(head.next).findElement(e)
  }

  def swapElements(e1: String, e2: String): Unit = {
    if(this.isPresent(e1) && this.isPresent(e2)){
      findElement(e1).item = e2
      findElement(e2).item = e1
    }
  }

  def removeLastElement(): Unit = {
    if (head == null) return null
    var tmp : Node = this.head
    for (i <- 0 until this.getSize -2){
      tmp = tmp.next
    }
    tmp.next = null
  }

  def removeElement(e: String): Unit = {
    if (this.isPresent(e)) {
      if (head == findElement(e)) head = head.next
      if (head.next == findElement(e)) head.next = head.next.next
      new LinkedList(head.next).removeElement(e)
    }
  }

  def insertAfter(before: String, after: String): Unit ={
    if (this.isPresent(before)){
      findElement(before).next = new Node(after, findElement(before).next)
    }
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
  flightList.insertAfter("Paris", "Lisbon")
  flightList.insertAfter("Lisbon", "Zurich")
  flightList.addToEnd("Oslo")
  println(flightList)
  flightList.removeElement("Tokyo")
  println(flightList)
}
