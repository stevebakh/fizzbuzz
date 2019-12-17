object FizzBuzz {

  def apply(start: Int, end: Int): String = {
    val fizzBuzzed = (start to end).map(fizzBuzzTheNumber)
    s"${(fizzBuzzed).mkString(" ")} ${report(fizzBuzzed)}"
  }

  private def report(fizzBuzzed: Seq[Any]) = {
    val counts = fizzBuzzed.groupBy {
      case v: Int => "integer"
      case v => v
    }.view.mapValues(_.size)
    
    List("fizz", "buzz", "fizzbuzz", "lucky", "integer")
      .map(k => s"$k: ${counts.getOrElse(k, 0)}")
      .mkString(" ")
  }

  private val fizzBuzzTheNumber: PartialFunction[Int, Any] = {
    case n if n.toString.contains("3") => "lucky"
    case n if n % 15 == 0 => "fizzbuzz"
    case n if n % 3 == 0 => "fizz"
    case n if n % 5 == 0 => "buzz"
    case n => n
  }
}