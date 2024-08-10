package iobeyxenon.domain

class Anagram {

  private val storage: Storage

  constructor() {
    this.storage = StorageImpl()
  }

  internal constructor(storage: Storage) {
    this.storage = storage
  }

  /**
   * Returns `true` if [text1] and [text2] form an anagram.
   */
  fun isAnagram(text1: String, text2: String): Boolean {
    val text1Representation = AnagramRepresentation(text1)
    val text2Representation = AnagramRepresentation(text2)

    storage.save(text1Representation, text1)
    storage.save(text2Representation, text2)

    return text1Representation == text2Representation
  }

  /**
   * Returns the remembered texts that form an anagram with [text].
   */
  fun getRememberedAnagrams(text: String): List<String> {
    return storage
      .findAnagrams(AnagramRepresentation(text))
      .filter { text != it } // Do not include the requested word
  }

}
