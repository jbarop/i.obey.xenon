package iobeyxenon.domain

/**
 * Returns `true` if [word1] and [word2] form an anagram.
 */
fun isAnagram(word1: String, word2: String) =
  word1.toPotentialAnagram() == word2.toPotentialAnagram()

private fun String.toPotentialAnagram() =
  this.filter { it.isLetter() }
    .uppercase()
    .toList()
    .sorted()
