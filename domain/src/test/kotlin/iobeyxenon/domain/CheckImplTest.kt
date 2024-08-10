package iobeyxenon.domain

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

class CheckImplTest {

  private val cut = CheckImpl()

  @Test
  fun `is not anagram`() {
    assertThat(cut.isAnagram("listen", "speechless"), `is`(false))
    assertThat(cut.isAnagram("listen", "zilent"), `is`(false))
    assertThat(cut.isAnagram("listen", "listenn"), `is`(false))
  }

  @Test
  fun `is anagram`() {
    assertThat(cut.isAnagram("listen", "silent"), `is`(true))
    assertThat(cut.isAnagram("listen", "Silent"), `is`(true))
    assertThat(cut.isAnagram("evil", "vile"), `is`(true))
    assertThat(cut.isAnagram("beyonnex.io", "iobeyxenon"), `is`(true))
    assertThat(cut.isAnagram("beyonnex.io", "i obey xenon"), `is`(true))
    assertThat(cut.isAnagram("beyonnex.io", "i.obey.xenon"), `is`(true))
    assertThat(cut.isAnagram("Church of Scientology", "rich-chosen goofy cult"), `is`(true))
    assertThat(cut.isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort"), `is`(true))
  }

}
