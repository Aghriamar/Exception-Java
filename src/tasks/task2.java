package tasks;

public class task2 {

    // Код в задаче №2 выглядит правильно и обрабатывает деление на ноль
    // с использованием блока catch для ArithmeticException. Ничего не требуется исправлять.
    private static int[] intArray = new int[] {1,2,3,4,5,6,7,8,9};
    public static void main(String[] args){
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
