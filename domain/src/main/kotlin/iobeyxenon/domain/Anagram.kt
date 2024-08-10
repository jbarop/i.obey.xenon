package iobeyxenon.domain

class Anagram {

  private val check: Check
  private val storage: Storage

  constructor() {
    this.check = CheckImpl()
    this.storage = StorageImpl()
  }

  internal constructor(check: Check, storage: Storage) {
    this.check = check
    this.storage = storage
  }

  /**
   * Returns `true` if [text1] and [text2] form an anagram.
   */
  fun isAnagram(text1: String, text2: String): Boolean {
    storage.save(text1)
    storage.save(text2)
    return check.isAnagram(text1, text2)
  }

  /**
   * Returns the remembered texts that form an anagram with [text].
   */
  fun getRememberedAnagrams(text: String): List<String> {
    return storage
      .load()
      .filter { text != it } // Do not include the requested word
      .filter { check.isAnagram(text, it) }
  }

}
