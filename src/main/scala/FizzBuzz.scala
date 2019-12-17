object FizzBuzz {

  def apply(start: Int, end: Int): String = {
    val fizzBuzzed = (start to end).map(fizzBuzzTheNumber)
    s"${(fizzBuzzed).mkString(" ")} ${report(fizzBuzzed)}"
  }

  private def report(fizzBuzzed: Seq[FizzBuzzResult]) = {
    val counts = fizzBuzzed.groupBy {
      case v: Number => Number
      case v => v
    }.view.mapValues(_.size)
    
    Seq(Fizz, Buzz, FizzBuzz, Lucky, Number).map {
      case k@Number => s"integer: ${counts.getOrElse(k, 0)}"
      case k => s"$k: ${counts.getOrElse(k, 0)}"
    }.mkString(" ")
  }

  private val fizzBuzzTheNumber: PartialFunction[Int, FizzBuzzResult] = {
    case n if n.toString.contains("3") => Lucky
    case n if n % 15 == 0 => FizzBuzz
    case n if n % 3 == 0 => Fizz
    case n if n % 5 == 0 => Buzz
    case n => Number(n)
  }

  sealed trait FizzBuzzResult
  case class Number(value: Int) extends FizzBuzzResult { override def toString = value.toString }
  case object Fizz extends FizzBuzzResult { override def toString = "fizz" }
  case object Buzz extends FizzBuzzResult { override def toString = "buzz" }
  case object FizzBuzz extends FizzBuzzResult { override def toString = "fizzbuzz" }
  case object Lucky extends FizzBuzzResult { override def toString = "lucky" }
}