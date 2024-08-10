package iobeyxenon.domain

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class AnagramTest {

  private val checkMock: Check = mock()
  private val storageMock: Storage = mock()

  private val cut = Anagram(checkMock, storageMock)

  @Test
  fun `should return true when anagram is valid`() {
    whenever(checkMock.isAnagram(any(), any())).thenReturn(true)

    assertThat(cut.isAnagram("", ""), `is`(true))
  }

  @Test
  fun `should return false when anagram is not valid`() {
    whenever(checkMock.isAnagram(any(), any())).thenReturn(false)

    assertThat(cut.isAnagram("", ""), `is`(false))
  }

  @Test
  fun `should save both texts to the storage when checking for an anagram`() {
    cut.isAnagram("text1", "text2")

    verify(storageMock).save("text1")
    verify(storageMock).save("text2")
  }

  @Test
  fun `should retrieve remembered texts from the storage`() {
    whenever(storageMock.load()).thenReturn(listOf("a", "b", "c", "d"))
    mockAnagram("a", "b")
    mockAnagram("a", "d")
    mockAnagram("b", "d")

    assertThat(cut.getRememberedAnagrams("a"), `is`(listOf("b", "d")))
    assertThat(cut.getRememberedAnagrams("b"), `is`(listOf("a", "d")))
    assertThat(cut.getRememberedAnagrams("c"), `is`(emptyList()))
  }

  private fun mockAnagram(text1: String, text2: String) {
    whenever(checkMock.isAnagram(text1, text1)).thenReturn(true)
    whenever(checkMock.isAnagram(text2, text2)).thenReturn(true)
    whenever(checkMock.isAnagram(text1, text2)).thenReturn(true)
    whenever(checkMock.isAnagram(text2, text1)).thenReturn(true)
  }

}
