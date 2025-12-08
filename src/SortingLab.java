import java.util.Arrays;

public class SortingLab {

    public static void main(String[] args) {
        // Вхідні дані (double масив)
        double[] arrayForInsertion = {12.5, 3.14, 0.5, 99.9, 15.0, -2.4, 45.1};
        // Робимо копію для другого методу, щоб сортувати однакові дані
        double[] arrayForBubble = Arrays.copyOf(arrayForInsertion, arrayForInsertion.length);

        System.out.println("Початковий масив: " + Arrays.toString(arrayForInsertion));
        System.out.println("--------------------------------------------------");

        // 1. Виклик сортування вставкою
        insertionSort(arrayForInsertion);
        System.out.println("Результат Insertion Sort: " + Arrays.toString(arrayForInsertion));

        // 2. Виклик сортування бульбашкою
        bubbleSort(arrayForBubble);
        System.out.println("Результат Bubble Sort:    " + Arrays.toString(arrayForBubble));
    }

    /**
     * Метод 1: Сортування включенням (Insertion Sort)
     */
    public static void insertionSort(double[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            double key = arr[i]; // Елемент, який ми вставляємо
            int j = i - 1;

            // Пересуваємо елементи масиву arr[0..i-1], які більші за key,
            // на одну позицію вперед
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key; // Вставляємо key на правильне місце
        }
    }

    /**
     * Метод 2: Сортування обміном (Bubble Sort)
     */
    public static void bubbleSort(double[] arr) {
        int n = arr.length;
        boolean swapped;
        // Зовнішній цикл відповідає за проходи
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // Внутрішній цикл порівнює сусідні елементи
            // n - i - 1, тому що останні i елементів вже на своїх місцях
            for (int j = 0; j < n - i - 1; j++) {
                // Умова "arr[j] > arr[j + 1]" забезпечує сортування ЗА ЗРОСТАННЯМ
                if (arr[j] > arr[j + 1]) {
                    // Міняємо місцями (Swap)
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Оптимізація: якщо не було обмінів, масив вже відсортований
            if (!swapped) break;
        }
    }
}