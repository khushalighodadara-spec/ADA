import java.util.Scanner;

public class InsertionSortPerformance_1 {

    public static void insertionSort(int arr[], int n) {

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;

            // show step (optional for large input)
            System.out.print("Step " + i + ": ");
            for (int k = 0; k < n; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long startTime = System.nanoTime();

        insertionSort(arr, n);

        long endTime = System.nanoTime();

        System.out.println("\nSorted Elements:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        long time = endTime - startTime;
        System.out.println("\n\nExecution Time: " + time + " nanoseconds");

        sc.close();
    }
}

/*
================ SAMPLE OUTPUT =================

Enter number of elements:
500

Enter 500 elements:
(large data...)

Step 1: ...
Step 2: ...
...
Step 499: ...

Sorted Elements:
(sorted output...)

Execution Time: 2100000 nanoseconds

================================================
*/
