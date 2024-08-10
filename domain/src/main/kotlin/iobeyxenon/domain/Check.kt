package iobeyxenon.domain

internal interface Check {

  /**
   * Returns `true` if [text1] and [text2] form an anagram.
   */
  fun isAnagram(text1: String, text2: String): Boolean
}
