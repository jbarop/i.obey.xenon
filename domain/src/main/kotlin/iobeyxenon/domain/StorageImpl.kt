package iobeyxenon.domain

internal class StorageImpl : Storage {

  private val representations = mutableMapOf<AnagramRepresentation, LinkedHashSet<String>>()

  override fun save(representation: AnagramRepresentation, text: String) {
    val texts = representations[representation] ?: LinkedHashSet()
    texts.add(text)
    representations[representation] = texts
  }

  override fun findAnagrams(representation: AnagramRepresentation): List<String> {
    return representations[representation]?.toList() ?: emptyList()
  }
}
