package test;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import task.stream.Stream;

public class StreamTest {

  public static void main(String[] args) {
    testAddNumbers();
    testFilterWordsByLetter();
    testSquareNumbers();
    testSumOfNumbers();
    testAverageOfNumbers();
    testFindMaxNumber();
    testFindMinNumber();
    testContainsValue();
    testRemoveDuplicates();
    testStringLengths();
    testConcatenateStrings();
    testFilterEvenNumbers();
    testFindFirstEvenNumber();
  }

  public static void testAddNumbers() {
    // given
    int num1 = 5;
    int num2 = 10;
    int expectedResult = 15;
    // when
    int actualResult = Stream.addNumbers(num1, num2);
    // then
    if (expectedResult == actualResult) {
      System.out.println("Тест 1 (addNumbers) пройден успешно!");
    } else {
      System.out.println(
          "Тест 1 (addNumbers) не пройден. Ожидался: " + expectedResult + ", получен: "
              + actualResult);
    }
  }

  public static void testFilterWordsByLetter() {
    // given
    List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry");
    char letter = 'a';
    List<String> expectedResult = List.of("apple");
    // when
    List<String> actualResult = Stream.filterWordsByLetter(words, letter);
    // then
    if (expectedResult.equals(actualResult)) {
      System.out.println("Тест 2 (filterWordsByLetter) пройден успешно!");
    } else {
      System.out.println(
          "Тест 2 (filterWordsByLetter) не пройден. Ожидался: " + expectedResult + ", получен: "
              + actualResult);
    }
  }

  public static void testSquareNumbers() {
    // given
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    List<Integer> expectedResult = List.of(1, 4, 9, 16, 25);
    // when
    List<Integer> actualResult = Stream.squareNumbers(numbers);
    // then
    if (expectedResult.equals(actualResult)) {
      System.out.println("Тест 3 (squareNumbers) пройден успешно!");
    } else {
      System.out.println(
          "Тест 3 (squareNumbers) не пройден. Ожидался: " + expectedResult + ", получен: "
              + actualResult);
    }
  }

  public static void testSumOfNumbers() {
    // given
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    int expectedResult = 15;
    // when
    int actualResult = Stream.sumOfNumbers(numbers);
    // then
    if (expectedResult == actualResult) {
      System.out.println("Тест 4 (sumOfNumbers) пройден успешно!");
    } else {
      System.out.println(
          "Тест 4 (sumOfNumbers) не пройден. Ожидался: " + expectedResult + ", получен: "
              + actualResult);
    }
  }

  public static void testAverageOfNumbers() {
    // given
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    double expectedResult = 3.0;
    // when
    OptionalDouble actualResult = Stream.averageOfNumbers(numbers);
    // then
    if (actualResult != null && actualResult.isPresent()
        && expectedResult == actualResult.getAsDouble()) {
      System.out.println("Тест 5 (averageOfNumbers) пройден успешно!");
    } else {
      if (actualResult == null) {
        System.out.println("Тест 5 не пройден actualResult: " + actualResult);
      } else {
        System.out.println(
            "Тест 5 (averageOfNumbers) не пройден. Ожидался: " + expectedResult + ", получен: " + (
                actualResult.isPresent() ? actualResult.getAsDouble() : "не найден"));
      }
    }
  }

  public static void testFindMaxNumber() {
    // given
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    int expectedResult = 5;
    // when
    Optional<Integer> actualResult = Stream.findMaxNumber(numbers);
    // then
    if (actualResult != null && actualResult.isPresent() && expectedResult == actualResult.get()) {
      System.out.println("Тест 6 (findMaxNumber) пройден успешно!");
    } else {
      System.out.println(
          "Тест 6 (findMaxNumber) не пройден. Ожидался: " + expectedResult + ", получен: " + (
              actualResult != null && actualResult.isPresent() ? actualResult.get() : "не найден"));
    }
  }

  public static void testFindMinNumber() {
    // given
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    int expectedResult = 1;
    // when
    Optional<Integer> actualResult = Stream.findMinNumber(numbers);
    // then
    if (actualResult != null && actualResult.isPresent() && expectedResult == actualResult.get()) {
      System.out.println("Тест 7 (findMinNumber) пройден успешно!");
    } else {
      System.out.println(
          "Тест 7 (findMinNumber) не пройден. Ожидался: " + expectedResult + ", получен: " + (
              actualResult != null && actualResult.isPresent() ? actualResult.get() : "не найден"));
    }
  }

  public static void testContainsValue() {
    // given
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    int value = 3;
    boolean expectedResult = true;
    // when
    boolean actualResult = Stream.containsValue(numbers, value);
    // then
    if (expectedResult == actualResult) {
      System.out.println("Тест 8 (containsValue) пройден успешно!");
    } else {
      System.out.println(
          "Тест 8 (containsValue) не пройден. Ожидался: " + expectedResult + ", получен: "
              + actualResult);
    }
  }

  public static void testRemoveDuplicates() {
    // given
    List<Integer> numbers = List.of(1, 2, 2, 3, 4, 4, 5);
    List<Integer> expectedResult = List.of(1, 2, 3, 4, 5);
    // when
    List<Integer> actualResult = Stream.removeDuplicates(numbers);
    // then
    if (expectedResult.equals(actualResult)) {
      System.out.println("Тест 9 (removeDuplicates) пройден успешно!");
    } else {
      System.out.println(
          "Тест 9 (removeDuplicates) не пройден. Ожидался: " + expectedResult + ", получен: "
              + actualResult);
    }
  }

  public static void testStringLengths() {
    // given
    List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry");
    List<Integer> expectedResult = List.of(5, 6, 6, 4, 10);
    // when
    List<Integer> actualResult = Stream.stringLengths(words);
    // then
    if (expectedResult.equals(actualResult)) {
      System.out.println("Тест 10 (stringLengths) пройден успешно!");
    } else {
      System.out.println(
          "Тест 10 (stringLengths) не пройден. Ожидался: " + expectedResult + ", получен: "
              + actualResult);
    }
  }

  public static void testConcatenateStrings() {
    // given
    List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry");
    String expectedResult = "apple banana cherry date elderberry";
    // when
    String actualResult = Stream.concatenateStrings(words);
    // then
    if (expectedResult.equals(actualResult)) {
      System.out.println("Тест 11 (concatenateStrings) пройден успешно!");
    } else {
      System.out.println(
          "Тест 11 (concatenateStrings) не пройден. Ожидался: " + expectedResult + ", получен: "
              + actualResult);
    }
  }

  public static void testFilterEvenNumbers() {
    // given
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
    List<Integer> expectedResult = List.of(2, 4, 6);
    // when
    List<Integer> actualResult = Stream.filterEvenNumbers(numbers);
    // then
    if (expectedResult.equals(actualResult)) {
      System.out.println("Тест 12 (filterEvenNumbers) пройден успешно!");
    } else {
      System.out.println(
          "Тест 12 (filterEvenNumbers) не пройден. Ожидался: " + expectedResult + ", получен: "
              + actualResult);
    }
  }

  public static void testFindFirstEvenNumber() {
    // given
    List<Integer> numbers = List.of(1, 3, 5, 6, 7, 8);
    int expectedResult = 6;
    // when
    Optional<Integer> actualResult = Stream.findFirstEvenNumber(numbers);
    // then
    if (actualResult != null && actualResult.isPresent() && expectedResult == actualResult.get()) {
      System.out.println("Тест 13 (findFirstEvenNumber) пройден успешно!");
    } else {
      System.out.println(
          "Тест 13 (findFirstEvenNumber) не пройден. Ожидался: " + expectedResult + ", получен: "
              + (actualResult != null && actualResult.isPresent() ? actualResult.get()
              : "не найден"));
    }
  }
}