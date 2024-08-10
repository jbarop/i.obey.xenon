package iobeyxenon.domain

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class AnagramTest {

  private val storageMock: Storage = mock()

  private val cut = Anagram(storageMock)

  @Test
  fun `should return true when anagram is valid`() {
    assertThat(cut.isAnagram("ab", "ba"), `is`(true))
  }

  @Test
  fun `should return false when anagram is not valid`() {
    assertThat(cut.isAnagram("ab", "aa"), `is`(false))
  }

  @Test
  fun `should save both texts to the storage when checking for an anagram`() {
    cut.isAnagram("text1", "text2")

    verify(storageMock).save(AnagramRepresentation("text1"), "text1")
    verify(storageMock).save(AnagramRepresentation("text2"), "text2")
  }

  @Test
  fun `should retrieve remembered texts from the storage`() {
    whenever(storageMock.findAnagrams(AnagramRepresentation("a"))).thenReturn(listOf("a", "b", "d"))
    whenever(storageMock.findAnagrams(AnagramRepresentation("b"))).thenReturn(listOf("a", "b", "d"))
    whenever(storageMock.findAnagrams(AnagramRepresentation("d"))).thenReturn(listOf("a", "b", "d"))
    whenever(storageMock.findAnagrams(AnagramRepresentation("c"))).thenReturn(listOf("c"))

    assertThat(cut.getRememberedAnagrams("a"), `is`(listOf("b", "d")))
    assertThat(cut.getRememberedAnagrams("b"), `is`(listOf("a", "d")))
    assertThat(cut.getRememberedAnagrams("c"), `is`(emptyList()))
  }

}
