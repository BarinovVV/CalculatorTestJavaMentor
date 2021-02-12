package Calculator.Test.JavaMentor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.join;
import static java.util.Collections.nCopies;

public class Calculator {
    public static ArrayList<String> userData;
    public static Integer firstOperand;
    public static Integer secondOperand;
    public static Integer result;
    public static boolean isRome;

    public final static List<String> arab = new ArrayList<>
            (List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
    public final static List<String> rome = new ArrayList<>
            (List.of("","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"));

    public static void main(String[] args) throws IOException {
        userData = UserEnter.start().getUserEnter();
        checkUserdata(userData);
        resultOfOperation(userData.get(1));
    }

    public static void resultOfOperation(String operation) {

        try {
            switch (operation) {
                case "+" -> result = firstOperand + secondOperand;
                case "-" -> result = firstOperand - secondOperand;
                case "/" -> result = firstOperand / secondOperand;
                case "*" -> result = firstOperand * secondOperand;
                default -> throw new IllegalArgumentException("Неверный знак арифметического действия!");
            }
            if (isRome){
                if (result <= 0) throw new IllegalCallerException("Римскими цифрами могут записаны только натуральные числа\n"
                        + "а у вас получился ноль или отрицательное число!");
                System.out.println("Результат  = " + intToRoman(result));
            } else {
                System.out.println("Результат  = " + result);
            }
        } catch (NullPointerException ex) {
            System.out.println("Запустите калькулятор снова )");
        } catch (IllegalArgumentException | IllegalCallerException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void checkUserdata(ArrayList<String> userData){
        try {
            if (checkNumber(userData.get(0)) == 0 || checkNumber(userData.get(2)) == 0){
                throw new IllegalArgumentException("Введенные вами данные не являются цифрами\n" +
                        "или находятся не в диапазоне от 1 до 10!");
            }
            else if (checkNumber(userData.get(0)) == 1 && checkNumber(userData.get(2)) == 1){
                firstOperand = Integer.parseInt(userData.get(0));
                secondOperand = Integer.parseInt(userData.get(2));
                isRome = false;
            } else if (checkNumber(userData.get(0)) == 2 && checkNumber(userData.get(2)) == 2) {
                firstOperand = rome.indexOf(userData.get(0));
                secondOperand = rome.indexOf(userData.get(2));
                isRome = true;
            } else {
                System.out.println("Oбе цифры должны быть одного типа арабские/римские");
            }
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static int checkNumber(String string){
            if (arab.contains(string)){
                return 1;
            } else if (rome.contains(string.toUpperCase())){
                return 2;
            } else {
                return 0;
            }
    }



    public static String intToRoman(int number) {
        return join("", nCopies(number, "I"))
                .replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("XXXX", "XL")
                .replace("LL", "C")
                .replace("LXL", "XC");
//                .replace("CCCCC", "D")
//                .replace("CCCC", "CD")
//                .replace("DD", "M")
//                .replace("DCD", "CM");
    }

//        public static String intToRoman(int num) {
//        StringBuilder sb = new StringBuilder();
//        int times;
//        String[] romans = new String[] { "I", "IV", "V", "IX", "X", "XL", "L",
//                "XC", "C", "CD", "D", "CM", "M" };
//        int[] ints = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500,
//                900, 1000 };
//        for (int i = ints.length - 1; i >= 0; i--) {
//            times = num / ints[i];
//            num %= ints[i];
//            while (times > 0) {
//                sb.append(romans[i]);
//                times--;
//            }
//        }
//        return sb.toString();
//    }


}
