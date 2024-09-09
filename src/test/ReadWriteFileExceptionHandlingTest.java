package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import task.io.ReadWriteFileExceptionHandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadWriteFileExceptionHandlingTest {

  @Test
  public void testCreateAndWriteFile() throws IOException {
    // given
    String fileName = "test_output.txt";
    String content = "Test content";

    // when
    ReadWriteFileExceptionHandling.createAndWriteFile(fileName, content);
    String actualResult = new String(Files.readAllBytes(Paths.get(fileName)));

    // then
    assertEquals(content, actualResult);

    // Удаление тестового файла
    Files.deleteIfExists(Paths.get(fileName));
  }

  @Test
  public void testDivideNumbers() {
    // given
    double expectedResult = 2.0;
    int numerator = 10;
    int denominator = 5;

    // when
    double actualResult = ReadWriteFileExceptionHandling.divideNumbers(numerator, denominator);

    // then
    assertEquals(expectedResult, actualResult, 0.0001);

    // given
    Integer given = 10;
    Integer givenDenominator = 0;

    // when & then
    assertThrows(ArithmeticException.class,
        () -> ReadWriteFileExceptionHandling.divideNumbers(given, givenDenominator));
  }

  @Test
  public void testConvertStringToNumber() {
    // given
    int expectedResult = 123;
    String input = "123";

    // when
    int actualResult = ReadWriteFileExceptionHandling.convertStringToNumber(input);

    // then
    assertEquals(expectedResult, actualResult);

    // given
    String given = "abc";

    // when & then
    assertThrows(NumberFormatException.class, () -> ReadWriteFileExceptionHandling.convertStringToNumber(given));
  }

  @Test
  public void testCreateFileAndReadFirstWord() throws IOException {
    // given
    String fileName = "test_first_word.txt";
    String content = "First Second Third";
    String expectedResult = "First";

    // when
    ReadWriteFileExceptionHandling.createFileAndReadFirstWord(fileName, content);
    String fileContent = new String(Files.readAllBytes(Paths.get(fileName)));
    String actualResult = fileContent.split(" ")[0];

    // then
    assertEquals(expectedResult, actualResult);

    // Удаление тестового файла
    Files.deleteIfExists(Paths.get(fileName));
  }
}