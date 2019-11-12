package com.bihasi.sandbox.monads.generators.random

trait Generator[+T] {
  def generate: T
}
