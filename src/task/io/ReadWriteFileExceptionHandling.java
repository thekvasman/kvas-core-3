package task.io;


import java.io.*;

import java.util.Scanner;

public class ReadWriteFileExceptionHandling {

    public static void createAndWriteFile(String fileName, String content) {
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file, false)) {
            fileWriter.write(content);
        } catch (IOException e) {
            System.out.println("Файл уже существует и будет перезаписан " + e.getMessage());
        }

    }

    public static void createFileFromConsoleInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла: ");
        String name = scanner.nextLine();
        System.out.println("Введите то, что вы хотите записать");
        String content = scanner.nextLine();
        File file = new File(name);
        try (FileWriter writer = new FileWriter(name)) {
            writer.write(content);
            System.out.println("Файл " + name + " успешно создан и записан");
            System.out.println("Его содержимое: " + content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static double divideNumbers(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    public static void readNumberAndPrintSquare() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");
        double number = scanner.nextDouble();
        System.out.println("Квадрат вашего числа: " + number * number);
    }

    public static void readFileAndPrint(String fileName) {
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static int convertStringToNumber(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    public static void divideConsoleInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите делимое число: ");
        double a = scanner.nextDouble();
        System.out.println("Введите число-делитель: ");
        double b = scanner.nextDouble();
        if (b == 0) {
            throw new ArithmeticException("Ты внатуре ебан? Какой нахуй на ноль делить?");
        }
        System.out.println("Результат деления: " + a / b);
    }

    public static String createFileAndReadFirstWord(String fileName, String content){
        File file = new File(fileName);

        try {
            try (FileWriter writer = new FileWriter(file, false)) {
                writer.write(content);
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line = reader.readLine();
                if (line != null && !line.isEmpty()) {
                    return line.split(" ")[0];
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args){
        readFileAndPrint("");
        createFileFromConsoleInput();
        readNumberAndPrintSquare();
        divideConsoleInput();
        createFileAndReadFirstWord("test.txt", "Hello world");
    }
}