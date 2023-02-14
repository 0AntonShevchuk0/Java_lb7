import java.util.Scanner;

// Всі методи статичні, бо клас не зберігає жодних даних
public class ConsoleInputManager {
    // Отримання цілого числа з консолі
    public static int GetInteger(Scanner scanner, String message) {
        System.out.print(message);
        String input = scanner.next();
        return Integer.parseInt(input);
    }
}
