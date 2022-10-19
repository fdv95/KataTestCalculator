import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String result = "";
        System.out.println(calc(result));
    }

    public static String calc(String input) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение для двух арабских или для двух римских чисел.");
        String userInput = sc.nextLine(); // ввод пользователя
        String regex = "[IVX+/*-]+";
        String result;
        if (userInput.matches(regex)) {
            RomanOperations romanResult = new RomanOperations();
            romanResult.s = userInput;
            if ((romanResult.s).contains("+")) {
                result = romanResult.plus();
            } else if ((romanResult.s).contains("-")) {
                result = romanResult.minus();
            } else if ((romanResult.s).contains("*")) {
                result = romanResult.multiply();
            } else if ((romanResult.s).contains("/")) {
                result = romanResult.divide();
            } else {
                throw new IOException(); // некорректный ввод
            }
        } else {
            ArabOperations arabResult = new ArabOperations();
            arabResult.s = userInput;
            if ((arabResult.s).contains("+")) {
                result = arabResult.plus();
            } else if ((arabResult.s).contains("-")) {
                result = arabResult.minus();
            } else if ((arabResult.s).contains("*")) {
                result = arabResult.multiply();
            } else if ((arabResult.s).contains("/")) {
                result = arabResult.divide();
            } else {
                throw new IOException(); // некорректный ввод
            }
        }
        return result;
    }
}