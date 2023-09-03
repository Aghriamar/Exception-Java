package tasks;

import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {
        float result = getUserFloat();
        System.out.println("Вы ввели: " + result);
    }

    public static float getUserFloat() {
        Scanner scanner = new Scanner(System.in);
        float userInput = 0.0f;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Введите дробное число (float): ");
            if (scanner.hasNextFloat()) {
                userInput = scanner.nextFloat();
                validInput = true;
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите дробное число.");
                scanner.next(); // Очистить буфер ввода
            }
        }

        return userInput;
    }
}
