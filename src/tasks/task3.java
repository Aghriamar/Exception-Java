package tasks;

import java.io.FileNotFoundException;

public class task3 {

    // Код в задаче №3 имеет ошибку: блок catch (Throwable ex) должен быть последним,
    // так как Throwable является наивысшим классом в иерархии исключений.
    // Кроме того, код printSum выбрасывает FileNotFoundException,
    // но не предоставляет соответствующего throws в сигнатуре метода.
    public static void main(String[] args) throws Exception{
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
        throw new FileNotFoundException("Это исключение выбрасывается для демонстрации.");
    }
}
