package iobeyxenon.cli

import iobeyxenon.domain.Anagram


fun main(args: Array<String>) {
  val anagram = Anagram()
  val first = args[0]
  val second = args[1]

  println("Are `$first` and `$second` anagrams? ${anagram.isAnagram(first, second)}")
}
