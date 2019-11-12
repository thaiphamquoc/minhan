package com.bihasi.sandbox.monads.generators.random

import org.scalamock.scalatest.MockFactory
import org.scalatest.{Matchers, WordSpecLike}

class GeneratorSpec extends MockFactory with WordSpecLike with Matchers {

  val integers = new Generator[Int] {
    val rand = new java.util.Random
    override def generate: Int = rand.nextInt()
  }

  "integers" should {
    "generate a random integer" in {
      val randomInt = integers.generate
      println(s"Random integer: $randomInt")
      assert(randomInt * 1 == randomInt)
    }
  }
}
