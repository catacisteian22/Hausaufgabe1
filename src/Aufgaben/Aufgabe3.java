package Aufgaben;

public class Aufgabe3 {

    public static void main(String[] args) {
        int[] number1 = {1, 3, 0, 0, 0, 0, 0};
        int[] number2 = {8, 7, 0, 0, 0, 0, 0};
        int n = number1.length;
        int m = number2.length;

        Aufgabe3 aufgabe3 = new Aufgabe3();
        System.out.println("Die Summe der zwei Zahlen ist: " + calSum(number1, number2, n, m));

        int[] firstNumber = {8, 3, 0, 0, 0, 0, 0, 0, 0};
        int[] secondNumber = {5, 4, 0, 0, 0, 0, 0, 0, 0};

        System.out.println("Die Differenz der zwei Zahlen ist: ");
        diffArrays(firstNumber, secondNumber);System.out.println("\n");


//        int[] num3 = {2, 3, 6, 0, 0, 0, 0, 0, 0};
//        int[] num4={2};
//        System.out.println("Die Multiplikation der zwei Zahlen ist: " + mulArrays(num3, num4));

    }


    private static void diffArrays(int[] num1, int[] num2) {
        if (num1.length < num2.length) {
            diffArrays(num2, num1);
            return;
        }

        if (num1.length == num2.length) {
            // prufen wer ist grosser
            int idx = 0;
            while (idx < num1.length) {
                if (num1[idx] > num2[idx]) break;

                if (num1[idx] < num2[idx]) {
                    diffArrays(num2, num1);
                    return;
                }

                idx++;
            }
        }

        int ptr1 = num1.length - 1;
        int ptr2 = num2.length - 1;
        while (ptr1 >= 0 && ptr2 >= 0) {
            int digit1 = num1[ptr1--];
            int digit2 = num2[ptr2--];

            int diff = 0;
            if (digit1 < digit2) {
                diff = digit1 + 10 - digit2;
                num1[ptr1] -= 1;
            } else {
                diff = digit1 - digit2;
            }

            num1[ptr1 + 1] = diff;
        }

        int last = 0;
        boolean zeroes = true;
        while (last < num1.length) {
            int num = num1[last++];
            if (num > 0) {
                zeroes = false;
            }

            if (!zeroes) System.out.print(num);
        }
    }

    static int sumArrays(int a[], int b[], int n, int m) {
        int[] sum = new int[n];

        int i = n - 1, j = m - 1, k = n - 1;

        int carry = 0, s = 0;
        //befor wir der Anfang der Array erreichen, wir vergleichen nur fur das zweite array,
        //weil wir die size der arrays in Wrapper Funktion schon vergleichen
        while (j >= 0) {
            // die Summe der zugehorigen Element fur beide Arrays
            s = a[i] + b[j] + carry;

            sum[k] = (s % 10);

            // finden carry fur naxhste sum
            carry = s / 10;

            k--;
            i--;
            j--;
        }
        //falls die Size der zweite Array is kleiner als der size der erste Array
        while (i >= 0) {
            //wir fugen den carry zu den ersten Array Elements
            s = a[i] + carry;
            sum[k] = (s % 10);
            carry = s / 10;

            i--;
            k--;
        }

        int ans = 0;


        if (carry == 1)
            ans = 10;

        // Array zu Zahl
        for (i = 0; i <= n - 1; i++) {
            ans += sum[i];
            ans *= 10;
        }

        return ans / 10;
    }

    // Wrapper Funktion
    static int calSum(int a[], int b[], int n, int m) {
        //machen das erste Array, welche hat das grosste Anzaghl von Elemente
        if (n >= m)
            return sumArrays(a, b, n, m);

        else
            return sumArrays(b, a, n, m);
    }

    public static int[] addX(int n, int arr[], int x) {
        int i;

        int newarr[] = new int[n + 1];

        for (i = 0; i < n; i++)
            newarr[i] = arr[i];

        newarr[n] = x;

        return newarr;
    }
}