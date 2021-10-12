package Aufgaben;

import java.sql.Array;
import java.util.stream.IntStream;

public class Aufgabe4 {

    public static int billigsteTastatur(int[] arrTastatur) {
        int temp, size;
        //int array[] = {10, 20, 25, 63, 96, 57};
        size = arrTastatur.length;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arrTastatur[i] > arrTastatur[j]) {
                    temp = arrTastatur[i];
                    arrTastatur[i] = arrTastatur[j];
                    arrTastatur[j] = temp;
                }
            }
        }
        return arrTastatur[0];
    }

    public static int teuersteGegenstand(int[] arrTastatur, int[] arrUSB) {
        int len1 = arrTastatur.length;
        int len2 = arrUSB.length;
        int max = IntStream
                .concat(IntStream.of(arrTastatur), IntStream.of(arrUSB))
                .max()
                .getAsInt();

        return max;
    }

    public static int BudgetFriendly(int budget, int[] arrUSB) {
        int start = 0, end = arrUSB.length - 1;
        //minimale size der Array muss 1 sein
        if (end == 0) return -1;
        //ob den geht uber max element, dann den Index von den streng kleiner Wert als den Budget soll (end-1) sein
        if (budget > arrUSB[end]) return end;

        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            // Bewegt links falls der Budget ist kleiner
            if (arrUSB[mid] >= budget) {
                end = mid - 1;
            }

            else {
                ans = mid;
                start = mid + 1;
            }
        }
        return arrUSB[ans];

    }

    public static int kannMarkusKaufen(int budget, int[] arrUSB, int[] arrTastatur) {
        int ans, sum = 0;
        ans = -1;

        for (int k : arrTastatur) {
            for (int i : arrUSB) {
                sum = k + i;
                if (sum > budget) {
                } else {
                    if (sum > ans)
                        ans = sum;

                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int Tastatur[] = {40, 35, 70, 15, 45};
        int USB[] = {20, 15, 40, 35, 45};
        int Budget = 60;
        int Tastatur1[] = {40, 50, 60};
        int USB1[] = {8, 12};
        int Tastatur2[] = {60};
        int USB2[] = {8, 12};
        int Tastatur3[] = {40,60};
        int USB3[] = {8, 12};

        System.out.println("Billigste Tastatur is " + billigsteTastatur(Tastatur));
        System.out.println("Teuerste Gegenstand is " + teuersteGegenstand(Tastatur, USB));
        System.out.println("Das teuerste USB Laufwerk, das Markus kaufen\n" +
                "kann ist: " + BudgetFriendly(Budget, USB));
        System.out.println("Er kann zwei Gegenstande fur " + kannMarkusKaufen(Budget, USB1, Tastatur1) + "€ kaufen");
        System.out.println("Er kann zwei Gegenstande fur " + kannMarkusKaufen(Budget, USB2, Tastatur2) + "€ kaufen");
        System.out.println("Er kann zwei Gegenstande fur " + kannMarkusKaufen(Budget, USB3, Tastatur3) + "€ kaufen");
    }
}
