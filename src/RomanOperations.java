import java.io.IOException;

class RomanOperations {
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
        String result = "";
        int indexOperation = s.indexOf(operation);
        if (indexOperation == (s.length() - 1)) {
            throw new IOException();
//            result = "throws Exception"; // некорректный ввод
        } else {
            String s1 = s.substring(0, indexOperation);
            String s2 = s.substring(indexOperation + 1, s.length());
            String regex = "[IVX]+";
            String[] arr1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            String[] arr2 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            if (s1.matches(regex) && s2.matches(regex)) {
                for (int i = 0; i < arr2.length; i++) {
                    if (s1.equals(arr2[i])) {
                        s1 = arr1[i];
                        x = Integer.parseInt(s1);
                        break;
                    } else {
                        x = 0;
                    }
                }
                for (int i = 0; i < arr2.length; i++) {
                    if (s2.equals(arr2[i])) {
                        s2 = arr1[i];
                        y = Integer.parseInt(s2);
                        break;
                    } else {
                        y = 0;
                    }
                }
                if (x == 0 || y == 0) {
                    throw new IOException(); // числа вне диапазона от I до X
                } else {
                    int resultArab = calculateTheExpression(operation); // результат в арабских числах
                    if (resultArab <= 0) {
                        throw new IOException(); // В римской системе нет отрицательных чисел и нуля
                    } else {
                        String resultRoman = Integer.toString(resultArab);
                        if (resultRoman.length() == 1) {
                            for (int i = 0; i < arr2.length; i++) {
                                if (resultRoman.equals(arr1[i])) {
                                    resultRoman = arr2[i];
                                    result = resultRoman;
                                    break;
                                }
                            }
                        } else if (resultRoman.length() == 2) {
                            String[] arr3 = {"10", "20", "30", "40", "50", "60", "70", "80", "90"};
                            String[] arr4 = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
                            String result1 = resultRoman.charAt(0) + "0";
                            String result2 = Character.toString(resultRoman.charAt(1));
                            for (int i = 0; i < arr4.length; i++) {
                                if (result1.equals(arr3[i])) {
                                    result1 = arr4[i];
                                    break;
                                }
                            }
                            for (int i = 0; i < arr4.length; i++) {
                                if (result2.equals(arr1[i])) {
                                    result2 = arr2[i];
                                    break;
                                }
                            }
                            result = result2.equals("0") ? result1 : result1 + result2;
                        } else if (resultRoman.length() == 3) {
                            result = "C";
                        }
                    }
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