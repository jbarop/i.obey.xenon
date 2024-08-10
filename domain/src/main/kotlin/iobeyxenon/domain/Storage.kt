package iobeyxenon.domain

internal interface Storage {

  fun save(text: String)

  fun load(): List<String>

}
