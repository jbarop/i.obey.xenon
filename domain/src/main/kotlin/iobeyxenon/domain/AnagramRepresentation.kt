package iobeyxenon.domain

internal class AnagramRepresentation(text: String) {

  private val representation = text
    .filter { it.isLetter() }
    .uppercase()
    .toList()
    .sorted()

  override fun equals(other: Any?): Boolean =
    if (other is AnagramRepresentation) {
      this.representation == other.representation
    } else {
      false
    }

  override fun hashCode(): Int = representation.size

}
