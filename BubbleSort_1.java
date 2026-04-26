import java.util.Scanner;

public class BubbleSort_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();   

        int arr[] = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long startTime = System.nanoTime();
        for (int i = 0; i < n - 1; i++) {
            System.out.print("Pass " + (i + 1) + ": ");

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            // print after each pass
            for (int k = 0; k < n; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }

        long endTime = System.nanoTime();

        System.out.println("\nSorted Elements:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        long time = endTime - startTime;
        System.out.println("\n\nTime: " + time + " nanoseconds");

        sc.close();
    }
}

/*
================ SAMPLE OUTPUT =================

Enter number of elements:
5

Enter elements:
64 25 12 22 11

Pass 1: 25 12 22 11 64
Pass 2: 12 22 11 25 64
Pass 3: 12 11 22 25 64
Pass 4: 11 12 22 25 64

Sorted Elements:
11 12 22 25 64

Time: 12000 nanoseconds

================================================
*/
