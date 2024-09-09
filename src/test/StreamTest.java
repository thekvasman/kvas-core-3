package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import task.stream.Stream;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class StreamTest {

  @Test
  public void testAddNumbers() {
    // given
    int num1 = 5;
    int num2 = 10;
    int expectedResult = 15;

    // when
    int actualResult = Stream.addNumbers(num1, num2);

    // then
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testFilterWordsByLetter() {
    // given
    List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry");
    char letter = 'a';
    List<String> expectedResult = List.of("apple");

    // when
    List<String> actualResult = Stream.filterWordsByLetter(words, letter);

    // then
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testSquareNumbers() {
    // given
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    List<Integer> expectedResult = List.of(1, 4, 9, 16, 25);

    // when
    List<Integer> actualResult = Stream.squareNumbers(numbers);

    // then
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testSumOfNumbers() {
    // given
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    int expectedResult = 15;

    // when
    int actualResult = Stream.sumOfNumbers(numbers);

    // then
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testAverageOfNumbers() {
    // given
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    double expectedResult = 3.0;

    // when
    OptionalDouble actualResult = Stream.averageOfNumbers(numbers);

    // then
    assertTrue(actualResult.isPresent());
    assertEquals(expectedResult, actualResult.getAsDouble(), 0.0001);
  }

  @Test
  public void testFindMaxNumber() {
    // given
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    int expectedResult = 5;

    // when
    Optional<Integer> actualResult = Stream.findMaxNumber(numbers);

    // then
    assertTrue(actualResult.isPresent());
    assertEquals(expectedResult, actualResult.get().intValue());
  }

  @Test
  public void testFindMinNumber() {
    // given
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    int expectedResult = 1;

    // when
    Optional<Integer> actualResult = Stream.findMinNumber(numbers);

    // then
    assertTrue(actualResult.isPresent());
    assertEquals(expectedResult, actualResult.get().intValue());
  }

  @Test
  public void testContainsValue() {
    // given
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    int value = 3;
    boolean expectedResult = true;

    // when
    boolean actualResult = Stream.containsValue(numbers, value);

    // then
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testRemoveDuplicates() {
    // given
    List<Integer> numbers = List.of(1, 2, 2, 3, 4, 4, 5);
    List<Integer> expectedResult = List.of(1, 2, 3, 4, 5);

    // when
    List<Integer> actualResult = Stream.removeDuplicates(numbers);

    // then
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testStringLengths() {
    // given
    List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry");
    List<Integer> expectedResult = List.of(5, 6, 6, 4, 10);

    // when
    List<Integer> actualResult = Stream.stringLengths(words);

    // then
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testConcatenateStrings() {
    // given
    List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry");
    String expectedResult = "apple banana cherry date elderberry";

    // when
    String actualResult = Stream.concatenateStrings(words);

    // then
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testFilterEvenNumbers() {
    // given
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
    List<Integer> expectedResult = List.of(2, 4, 6);

    // when
    List<Integer> actualResult = Stream.filterEvenNumbers(numbers);

    // then
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testFindFirstEvenNumber() {
    // given
    List<Integer> numbers = List.of(1, 3, 5, 6, 7, 8);
    int expectedResult = 6;

    // when
    Optional<Integer> actualResult = Stream.findFirstEvenNumber(numbers);

    // then
    assertTrue(actualResult.isPresent());
    assertEquals(expectedResult, actualResult.get().intValue());
  }
}