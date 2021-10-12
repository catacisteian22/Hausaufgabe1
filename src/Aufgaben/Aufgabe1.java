package Aufgaben;

import java.util.Arrays;

public class Aufgabe1 {


    public static int[] nicht_ausreichend(int[] arr) {
        int[] newArray = new int[0];
        for (int j : arr) {
            if (j < 40)
                newArray = addX(newArray.length, newArray, j);
        }

        return newArray;
    }

    public static int Durchschnitt(int[] nums) {
        return Arrays.stream(nums).sum() / nums.length;
    }

    public static int[] abgerundetenNoten(int[] arr) {
        int[] newArray = new int[0];
        int[] newArray2 = new int[0];
        for (int j : arr) {
            if (abrunden(j) != -1) {
                newArray = addX(newArray.length, newArray, j);
            }
        }
        for (int z : newArray) {
            z = abrunden(z);
            newArray2 = addX(newArray2.length, newArray2, z);
        }
        return newArray2;
    }

    public static int maxAbgerundeteNote(int[] arr){
        int[] abgerArray = abgerundetenNoten(arr);
        int maximaleNote = maxNote(abgerArray, abgerArray.length);
        return maximaleNote;
    }

    public static int abrunden(int note) {
        int remainder = note % 5;
        if (note < 38) {
            return -1;
        } else if (remainder >= 3) {
            note += 5 - remainder;
        }
        return note;
    }

    public static int maxNote(int[] array, int n) {
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

    public static int[] addX(int n, int arr[], int x) {               //Funktion welches einen Element hinzufugt
        int i;

        int newarr[] = new int[n + 1];

        for (i = 0; i < n; i++)
            newarr[i] = arr[i];

        newarr[n] = x;

        return newarr;
    }

    public static void main(String[] args) {
        //Aufgabe1 aufgabe1 = new Aufgabe1();
        int[] Noten = {35, 41, 58, 63, 89, 96, 25, 12, 54, 92, 49, 67};

        System.out.println("Die nichtausreichende Noten sind: " + Arrays.toString(nicht_ausreichend(Noten)));
        System.out.println("Der Durchschnitt der Noten ist: " + Durchschnitt(Noten));
        System.out.println("Eine abgerundete Note ist: " + abrunden(84));
        System.out.println("Die Noten, die abgerunded wurden sind: " + Arrays.toString(abgerundetenNoten(Noten)));
        System.out.println("Die maximale abgerundete Note ist: "+ maxAbgerundeteNote(Noten));
    }
}
