package iobeyxenon.domain

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class AnagramKtTest {

  @Test
  fun `is not anagram`() {
    assertFalse(isAnagram("listen", "speechless"))
    assertFalse(isAnagram("listen", "zilent"))
    assertFalse(isAnagram("listen", "listenn"))

  }

  @Test
  fun `is anagram`() {
    assertTrue(isAnagram("listen", "silent"))
    assertTrue(isAnagram("listen", "Silent"))
    assertTrue(isAnagram("evil", "vile"))
    assertTrue(isAnagram("beyonnex.io", "iobeyxenon"))
    assertTrue(isAnagram("beyonnex.io", "i obey xenon"))
    assertTrue(isAnagram("beyonnex.io", "i.obey.xenon"))
    assertTrue(isAnagram("Church of Scientology", "rich-chosen goofy cult"))
    assertTrue(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort"))
  }

}
