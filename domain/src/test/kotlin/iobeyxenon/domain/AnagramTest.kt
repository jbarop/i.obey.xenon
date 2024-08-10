package iobeyxenon.domain

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class AnagramTest {

  private val checkMock: Check = mock()

  private val cut = Anagram(checkMock)

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

}
