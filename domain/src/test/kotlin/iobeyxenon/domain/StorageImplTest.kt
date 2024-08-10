package iobeyxenon.domain

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

class StorageImplTest {

  private val cut = StorageImpl()

  @Test
  fun `should store and retrieve a text`() {
    cut.save("a")

    assertThat(cut.load(), equalTo(listOf("a")))
  }

  @Test
  fun `should ignore duplicates`() {
    cut.save("a")
    cut.save("a")

    assertThat(cut.load(), equalTo(listOf("a")))
  }

  @Test
  fun `should retain insertion order`() {
    cut.save("z")
    cut.save("y")
    cut.save("x")
    cut.save("a")
    cut.save("b")
    cut.save("c")
    cut.save("x")
    cut.save("a")

    assertThat(cut.load(), equalTo(listOf("z", "y", "x", "a", "b", "c")))
  }

}
