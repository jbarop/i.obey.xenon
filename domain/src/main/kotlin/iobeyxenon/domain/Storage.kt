package iobeyxenon.domain

internal interface Storage {

  fun save(representation: AnagramRepresentation, text: String)

  fun findAnagrams(representation: AnagramRepresentation): List<String>

}
