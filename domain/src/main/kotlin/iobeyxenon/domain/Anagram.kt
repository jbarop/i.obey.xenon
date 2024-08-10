package iobeyxenon.domain

class Anagram {

  private val check: Check

  constructor() {
    this.check = CheckImpl()
  }

  internal constructor(check: Check) {
    this.check = check
  }

  /**
   * Returns `true` if [text1] and [text2] form an anagram.
   */
  fun isAnagram(text1: String, text2: String): Boolean {
    return check.isAnagram(text1, text2)
  }

}
