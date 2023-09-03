package tasks;

import java.util.Scanner;

public class task4 {
    public static void main(String[] args){
        try {
            String userInput = getUserInput();
            if (userInput.isEmpty()) {
                throw new Exception("Пустые строки вводить нельзя.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: ");
        return scanner.nextLine();
    }
}
