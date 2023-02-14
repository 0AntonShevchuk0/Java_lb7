import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Створення об'єкту класу для зчитування введення користувача
        Scanner scanner = new Scanner(System.in);

        // Блок, де може статися помилка
        try {
            // Введення даних
            int fibonacciCount = ConsoleInputManager.GetInteger(scanner, "Fibonacci numbers count: ");
            int factorial = ConsoleInputManager.GetInteger(scanner, "Factorial: ");
            int naturalNumber = ConsoleInputManager.GetInteger(scanner, "Natural number: ");

            // Виведення інформації
            System.out.println();
            System.out.println(fibonacciCount + " Fibonacci numbers");
            showFibonacci(fibonacciCount, 0, 0, 1);
            System.out.println("Factorial of " + factorial + ":");
            System.out.println(getFactorial(factorial));
            System.out.println("Number of digits in " + naturalNumber + ":");
            System.out.println(countDigits(naturalNumber));
        }
        // Блок обробки помилок
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    // Числа Фібоначчі
    private static void showFibonacci(int count, int counter, int previous2, int previous1) throws Exception {
        if (count <= 0) {
            // Створення виключення
            throw new Exception("Wrong count.");
        }

        System.out.println(counter + " - " + previous2);

        if (counter < count) {
            int sum = previous2 + previous1;
            showFibonacci(count, counter + 1, previous1, sum);
        }
    }

    // Розрахунок факторіалу
    private static double getFactorial(int number) throws Exception {
        if (number < 0) {
            throw new Exception("Cant calculate factorial for a negative number.");
        }

        // Вихід з рекурсії
        if (number == 0 || number == 1) {
            return 1;
        }

        return number * getFactorial(number - 1);
    }

    // Підрахунок цифр
    private static int countDigits(int naturalNumber) throws Exception {
        if (naturalNumber <= 0) {
            throw new Exception("A number must be natural.");
        }
        // Кожне число має хоча б одну цифру
        int digitsCount = 1;

        while (naturalNumber >= 10) {
            digitsCount++;
            naturalNumber /= 10;
        }

        return digitsCount;
    }
}

