package iobeyxenon.domain

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckKtTest {

  private val cut = CheckImpl()

  @Test
  fun `is not anagram`() {
    assertFalse(cut.isAnagram("listen", "speechless"))
    assertFalse(cut.isAnagram("listen", "zilent"))
    assertFalse(cut.isAnagram("listen", "listenn"))

  }

  @Test
  fun `is anagram`() {
    assertTrue(cut.isAnagram("listen", "silent"))
    assertTrue(cut.isAnagram("listen", "Silent"))
    assertTrue(cut.isAnagram("evil", "vile"))
    assertTrue(cut.isAnagram("beyonnex.io", "iobeyxenon"))
    assertTrue(cut.isAnagram("beyonnex.io", "i obey xenon"))
    assertTrue(cut.isAnagram("beyonnex.io", "i.obey.xenon"))
    assertTrue(cut.isAnagram("Church of Scientology", "rich-chosen goofy cult"))
    assertTrue(cut.isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort"))
  }

}
