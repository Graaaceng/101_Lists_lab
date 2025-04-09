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
   this.head = this.head.next
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

  def addtoEnd(e: String): Unit = {
    getLastElement().next = new Node(e, null)
  }

  def isPresent(e: String): Boolean = {
    if(head == null) return false
    if (head.item == e) return true
    new LinkedList(head.next).isPresent(e)
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
