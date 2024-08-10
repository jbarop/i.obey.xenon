package iobeyxenon.domain

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

class StorageImplTest {

  private val cut = StorageImpl()

  @Test
  fun `should return empty list for unkown representations`() {
    assertThat(cut.findAnagrams(AnagramRepresentation("blah")), equalTo(emptyList()))
  }

  @Test
  fun `should store multiple anagrams for representations and retain insertion order`() {
    val representation1 = AnagramRepresentation("a")
    val representation2 = AnagramRepresentation("b")

    cut.save(representation1, "a")
    cut.save(representation1, "b")
    cut.save(representation1, "c")
    cut.save(representation2, "x")
    cut.save(representation2, "y")
    cut.save(representation2, "z")

    assertThat(cut.findAnagrams(representation1), equalTo(listOf("a", "b", "c")))
    assertThat(cut.findAnagrams(representation2), equalTo(listOf("x", "y", "z")))
  }

  @Test
  fun `should ignore duplicates`() {
    val text = "a"
    val representation = AnagramRepresentation(text)

    cut.save(representation, text)
    cut.save(representation, text)

    assertThat(cut.findAnagrams(representation), equalTo(listOf("a")))
  }

}
