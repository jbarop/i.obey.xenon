package iobeyxenon.domain

internal class StorageImpl : Storage {

  private val texts = LinkedHashSet<String>()

  override fun save(text: String) {
    texts.add(text)
  }

  override fun load(): List<String> {
    return texts.toList()
  }
}
