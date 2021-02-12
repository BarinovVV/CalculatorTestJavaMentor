package Calculator.Test.JavaMentor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class UserEnter {
    String userEnter;
    String delimiter = " ";

    public UserEnter(String userEnter) {
        this.userEnter = userEnter;
    }

    public void printUserEnter() {
        System.out.println("Вы ввели следующие данные " + userEnter);
    }

    public ArrayList<String> getUserEnter() {
        return new ArrayList<>(Arrays.asList(userEnter.split(delimiter)));
    }

    public static UserEnter start() throws IOException {
        System.out.println("Вам надо ввести данные для калькулятора - >");
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            int count;
            UserEnter userEnter;

            while(true){
                userEnter = new UserEnter(bufferedReader.readLine());
                userEnter.printUserEnter();
                count = userEnter.getUserEnter().size();
                if (count != 3) {
                    System.out.println("Вам надо ввести выражение вида 1 + 2 и разделить пробелами цифры и знак действия\n"
                            + "Введите правильные данные для расчета!");
                } else {
                    return userEnter;
                }
            }
        }
    }
}
