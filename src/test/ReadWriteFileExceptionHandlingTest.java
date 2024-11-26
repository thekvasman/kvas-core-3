package test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import task.io.ReadWriteFileExceptionHandling;

public class ReadWriteFileExceptionHandlingTest {

  public static void main(String[] args) {
    try {
      testCreateAndWriteFile();
      testDivideNumbers();
      testConvertStringToNumber();
      testCreateFileAndReadFirstWord();
    } catch (IOException e) {
      System.out.println("Ошибка ввода-вывода: " + e.getMessage());
    }
  }

  public static void testCreateAndWriteFile() throws IOException {
    // given
    String fileName = "test_output.txt";
    String content = "Test content";
    // when
    ReadWriteFileExceptionHandling.createAndWriteFile(fileName, content);
    String actualResult = new String(Files.readAllBytes(Paths.get(fileName)));
    // then
    if (content.equals(actualResult)) {
      System.out.println("Тест 1 (createAndWriteFile) пройден успешно!");
    } else {
      System.out.println(
          "Тест 1 (createAndWriteFile) не пройден. Ожидался: " + content + ", получен: "
              + actualResult);
    }
    // Удаление тестового файла
    Files.deleteIfExists(Paths.get(fileName));
  }

  public static void testDivideNumbers() {
    // given
    double expectedResult = 2.0;
    int numerator = 10;
    int denominator = 5;
    // when
    double actualResult = ReadWriteFileExceptionHandling.divideNumbers(numerator, denominator);
    // then
    if (expectedResult == actualResult) {
      System.out.println("Тест 2 (divideNumbers) пройден успешно!");
    } else {
      System.out.println(
          "Тест 2 (divideNumbers) не пройден. Ожидался: " + expectedResult + ", получен: "
              + actualResult);
    }

    // given
    Integer given = 10;
    Integer givenDenominator = 0;
    // when & then
    try {
      ReadWriteFileExceptionHandling.divideNumbers(given, givenDenominator);
      System.out.println(
          "Тест 2 (divideNumbers) не пройден. Ожидалось исключение ArithmeticException.");
    } catch (ArithmeticException e) {
      System.out.println("Тест 2 (divideNumbers) с делением на ноль пройден успешно!");
    }
  }

  public static void testConvertStringToNumber() {
    // given
    int expectedResult = 123;
    String input = "123";
    // when
    int actualResult = ReadWriteFileExceptionHandling.convertStringToNumber(input);
    // then
    if (expectedResult == actualResult) {
      System.out.println("Тест 3 (convertStringToNumber) пройден успешно!");
    } else {
      System.out.println(
          "Тест 3 (convertStringToNumber) не пройден. Ожидался: " + expectedResult + ", получен: "
              + actualResult);
    }

    // given
    String given = "abc";
    // when & then
    try {
      ReadWriteFileExceptionHandling.convertStringToNumber(given);
      System.out.println(
          "Тест 3 (convertStringToNumber) не пройден. Ожидалось исключение NumberFormatException.");
    } catch (NumberFormatException e) {
      System.out.println("Тест 3 (convertStringToNumber) с некорректной строкой пройден успешно!");
    }
  }

  public static void testCreateFileAndReadFirstWord() throws IOException {
    // given
    String fileName = "test_first_word.txt";
    String content = "First Second Third";
    String expectedResult = "First";
    // when
    ReadWriteFileExceptionHandling.createFileAndReadFirstWord(fileName, content);
    String fileContent = new String(Files.readAllBytes(Paths.get(fileName)));
    String actualResult = fileContent.split(" ")[0];
    // then
    if (expectedResult.equals(actualResult)) {
      System.out.println("Тест 4 (createFileAndReadFirstWord) пройден успешно!");
    } else {
      System.out.println(
          "Тест 4 (createFileAndReadFirstWord) не пройден. Ожидался: " + expectedResult
              + ", получен: " + actualResult);
    }
    // Удаление тестового файла
    Files.deleteIfExists(Paths.get(fileName));
  }
}