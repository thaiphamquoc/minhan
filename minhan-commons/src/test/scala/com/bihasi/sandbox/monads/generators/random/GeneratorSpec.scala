package com.bihasi.sandbox.monads.generators.random

import org.scalamock.scalatest.MockFactory
import org.scalatest.{Matchers, WordSpecLike}

class GeneratorSpec extends MockFactory with WordSpecLike with Matchers {

  private trait BaseContext {
    val integers = new Generator[Int] {
      val rand = new java.util.Random
      override def generate: Int = rand.nextInt()
    }
  }

  private trait BooleanGeneratorContext extends BaseContext {
    val booleans = for (x <- integers) yield x > 0
  }

  "integers" should {
    "generate a random integer" in new BaseContext {
      val randomInt = integers.generate
      println(s"Random integer: $randomInt")
      assert(randomInt * 1 == randomInt)
    }
  }

  "booleans" should {
    "generate a randon boolean value" in new BooleanGeneratorContext {
      println(booleans.generate)
    }
  }
}
