package Aufgaben;

import java.util.Arrays;

public class Aufgabe2 {


    public static int maxZahl(int[] array, int n) {
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array[n - 1];
    }

    public static int minZahl(int[] array, int n) {
        Arrays.sort(array);
        return array[0];
    }

    static void minMax(int[] array) {
        long min_value = 0;
        long max_value = 0;
        int n = array.length;

        Arrays.sort(array);

        for (int i = 0, j = n - 1;
             i < n - 1; i++, j--) {
            min_value += array[i];

            max_value += array[j];
        }

        // Output: min_value and max_value
        System.out.println("Minimale Summe: " +
                min_value + " und " + "Maximale Summe: "
                +max_value);
    }

    public static void main(String args[]) {

        int arr[] = {48, 66, 100, 77, 33, 20, 55};
        System.out.println("Maximal Zahl: " + maxZahl(arr, arr.length));
        System.out.println("Minimal Zahl: " + minZahl(arr, arr.length));
        minMax(arr);
    }
}
