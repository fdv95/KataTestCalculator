import java.io.IOException;

class ArabOperations {
    String s; //ввод пользователя
    int x; // число 1
    int y; // число 2


    int calculateTheExpression(String operation) {
        int result = 0;
        switch (operation) {
            case "+" -> result = x + y;
            case "-" -> result = x - y;
            case "*" -> result = x * y;
            case "/" -> result = x / y;
        }
        return result;
    }


    String performTheOperation(String operation) throws IOException {
        String result;
        int indexOperation = s.indexOf(operation);
        if (indexOperation == (s.length() - 1)) {
            throw new IOException(); // проверка на то, что знак операции не последний в строке
        } else {
            String s1 = s.substring(0, indexOperation);
            String s2 = s.substring(indexOperation + 1, s.length());
            String regex = "\\d+";
            if (s1.matches(regex) && s2.matches(regex)) {
                x = Integer.parseInt(s1);
                y = Integer.parseInt(s2);
                if (x >= 1 && y >= 1 && x <= 10 && y <= 10) {
                    int theExpression = calculateTheExpression(operation);
                    result = Integer.toString(theExpression);
                } else {
                    throw new IOException(); // числа вне диапазона от 1 до 10
                }
            } else {
                throw new IOException(); // некорректный ввод
            }
        }
        return result;
    }


    String plus() throws IOException {
        return performTheOperation("+");
    }


    String minus() throws IOException {
        return performTheOperation("-");
    }


    String multiply() throws IOException {
        return performTheOperation("*");
    }


    String divide() throws IOException {
        return performTheOperation("/");
    }


}