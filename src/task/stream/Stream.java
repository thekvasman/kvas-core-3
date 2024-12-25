package task.stream;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Stream {
    //1
    public static int addNumbers(int num1, int num2) {
        BinaryOperator<Integer> sum = Integer::sum;
        return sum.apply(num1, num2);
    }

    //2
    public static List<String> filterWordsByLetter(List<String> words, char letter) {
        return words.stream()
                .filter(v -> v.startsWith(String.valueOf(letter)))
                .toList();
    }

    //3
    public static List<Integer> squareNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(v -> v * v)
                .toList();
    }

    //4
    public static void printUpperCase(List<String> words) {
        words.forEach(s -> s.toUpperCase());
    }

    //5
    public static int sumOfNumbers(List<Integer> numbers) {
        return numbers.stream().mapToInt(v -> v).sum();
    }

    //6
    public static OptionalDouble averageOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(v -> v)
                .average();
    }

    //7
    public static Optional<Integer> findMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compare);
    }

    //8
    public static Optional<Integer> findMinNumber(List<Integer> numbers) {
        return numbers.stream()
                .min(Integer::compare);
    }

    //9
    public static boolean containsValue(List<Integer> numbers, int value) {
        return numbers.stream()
                .anyMatch(v -> v == value);
    }

    //10
    public static List<Integer> removeDuplicates(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .toList();
    }

    //11
    public static List<Integer> stringLengths(List<String> words) {
        return words.stream()
                .map(String::length)
                .toList();
    }

    //12
    public static String concatenateStrings(List<String> words) {
        return words.stream()
                .collect(Collectors.joining(" "));
    }

    //13
    public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(v -> v % 2 == 0)
                .toList();
    }

    //14
    public static Optional<Integer> findFirstEvenNumber(List<Integer> numbers) {
        return numbers.stream()
                .filter(v -> v % 2 ==0)
                .findFirst();
    }

}