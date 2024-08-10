package iobeyxenon.domain

internal class CheckImpl : Check {

  override fun isAnagram(text1: String, text2: String) =
    text1.toPotentialAnagram() == text2.toPotentialAnagram()

  private fun String.toPotentialAnagram() =
    this.filter { it.isLetter() }
      .uppercase()
      .toList()
      .sorted()

}
