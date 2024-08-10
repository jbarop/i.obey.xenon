package iobeyxenon.cli

import iobeyxenon.domain.Anagram

fun main() {
  val anagram = Anagram()
  var running = true

  while (running) {
    print("Enter first text or press ENTER to quit: ")
    val first = readln()
    if (first.isNotEmpty()) {
      print("Enter second text or press ENTER to check against remembered words: ")
      val second = readln()
      if (second.isNotEmpty()) {
        println("Are `$first` and `$second` anagrams? ${anagram.isAnagram(first, second)}")
      } else {
        println("I remembered anagrams to `$first`: ${anagram.getRememberedAnagrams(first)}")
      }
      println()
    } else {
      running = false
    }
  }
}
