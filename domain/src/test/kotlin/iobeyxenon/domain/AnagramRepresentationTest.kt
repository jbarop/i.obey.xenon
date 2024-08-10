package iobeyxenon.domain

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.not
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class AnagramRepresentationTest {

  @ParameterizedTest(name = "{0} does not form an anagram with {1}")
  @CsvSource(
    "listen,speechless",
    "listen,zilent",
    "listen,listenn",
  )
  fun `is not anagram`(givenText1: String, givenText2: String) {
    assertThat(AnagramRepresentation(givenText1), not(equalTo(AnagramRepresentation(givenText2))))
  }

  @ParameterizedTest(name = "{0} forms an anagram with {1}")
  @CsvSource(
    "listen,silent",
    "listen,Silent",
    "evil,vile",
    "beyonnex.io,iobeyxenon",
    "beyonnex.io,i obey xenon",
    "beyonnex.io,i.obey.xenon",
    "Church of Scientology,rich-chosen goofy cult",
    "Tom Marvolo Riddle,I am Lord Voldemort",
  )
  fun `is anagram`(givenText1: String, givenText2: String) {
    assertThat(AnagramRepresentation(givenText1), equalTo(AnagramRepresentation(givenText2)))
  }

  @ParameterizedTest(name = "{0} should have a hash code of {1}")
  @CsvSource(
    "listen,6",
    "evil,4",
    "beyonnex.io,10",
    "i obey xenon,10",
    "i.obey.xenon,10",
    "Church of Scientology,19",
    "Tom Marvolo Riddle,16",
  )
  fun `hash code`(givenText: String, expectedHashCode: String) {
    assertThat(AnagramRepresentation(givenText).hashCode(), equalTo(expectedHashCode.toInt()))
  }

}
