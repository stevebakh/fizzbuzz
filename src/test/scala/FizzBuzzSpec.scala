import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class FizzBuzzSpec extends AnyFunSpec with Matchers {
  describe("Return the string 'fizz' for numbers that are a multiple of 3") {
    it("so the number '6' will return 'fizz'") {
      FizzBuzz(6, 6) should startWith ("fizz")
    }

    it("and the number '18' will return 'fizz'") {
      FizzBuzz(18, 18) should startWith ("fizz")
    }
  }

  describe("Return the string 'buzz' for numbers that are a multiple of 5") {
    it("so the number '5' will return 'buzz'") {
      FizzBuzz(5, 5) should startWith ("buzz")
    }

    it("and the number '20' will return 'buzz'") {
      FizzBuzz(20, 20) should startWith ("buzz")
    }
  }

  describe("Return the string 'fizzbuzz' for numbers that are a multiple of both 3 and 5") {
    it("so the number '15' will return 'fizzbuzz'") {
      FizzBuzz(15, 15) should startWith ("fizzbuzz")
    }

    it("and the number '45' will return 'fizzbuzz'") {
      FizzBuzz(45, 45) should startWith ("fizzbuzz")
    }
  }

  describe("Return numbers as-is when they are not a multiple of 3, 5 or 15") {
    it("so the number '2' will return '2'") {
      FizzBuzz(2, 2) should startWith ("2")
    }

    it("and the number '7' will return '7'") {
      FizzBuzz(7, 7) should startWith ("7")
    }

    it("and the number '11' will return '11'") {
      FizzBuzz(11, 11) should startWith ("11")
    }
  }
  
  describe("Return the word 'lucky' for numbers that contains the digit '3'") {
    it("so the number '3' will return 'lucky'") {
      FizzBuzz(3, 3) should startWith ("lucky")
    }

    it("and the number '13' will return 'lucky'") {
      FizzBuzz(13, 13) should startWith ("lucky")
    }

    it("and the number '30' will return 'lucky'") {
      FizzBuzz(30, 30) should startWith ("lucky")
    }
  }

  describe("Apply fizzbuzz to a contiguous range of integers") {
    it("to show transformation of numbers from 1 to 20") {
      val expected = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz"
      FizzBuzz(1, 20) should startWith (expected)
    }

    it("and include a report showing the counts of each category of value") {
      val expected = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz fizz: 4 buzz: 3 fizzbuzz: 1 lucky: 2 integer: 10"
      FizzBuzz(1, 20) should startWith (expected)
    }
  }
}