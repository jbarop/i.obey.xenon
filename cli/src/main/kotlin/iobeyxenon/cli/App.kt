package iobeyxenon.cli

import iobeyxenon.domain.isAnagram

fun main(args: Array<String>) {
  val first = args[0]
  val second = args[1]

  println("Are `$first` and `$second` anagrams? ${isAnagram(first, second)}")
}
