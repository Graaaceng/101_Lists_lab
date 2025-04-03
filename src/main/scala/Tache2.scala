object Tache2 extends App{
  var names: List[String] = List[String]("Jane", "Paul", "Nicole", "Anby")

  println(names.mkString(", "))
  if (names.contains("Paul")) println("Yes, Paul is here")

  var newNames = names.filter(name => name != "Paul")
  println(newNames.mkString(", "))
}
