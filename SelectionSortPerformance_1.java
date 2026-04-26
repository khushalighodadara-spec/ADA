import java.util.Scanner;

public class SelectionSortPerformance_1 {

    public static void selectionSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            // Show step
            System.out.print("Step " + (i + 1) + ": ");
            printArray(arr, n);
        }
    }

    public static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements (e.g., 500): ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\nOriginal Array:");
        printArray(arr, n);

    
        long startTime = System.nanoTime();

        selectionSort(arr, n);

        long endTime = System.nanoTime();

        System.out.println("\nSorted Array:");
        printArray(arr, n);

        long executionTime = endTime - startTime;

        System.out.println("\nExecution Time: " + executionTime + " nanoseconds");

        sc.close();
    }
}

/*
================ SAMPLE OUTPUT =================

Enter number of elements (e.g., 500): 5
Enter 5 elements:
64 25 12 22 11

Original Array:
64 25 12 22 11

Step 1: 11 25 12 22 64
Step 2: 11 12 25 22 64
Step 3: 11 12 22 25 64
Step 4: 11 12 22 25 64

Sorted Array:
11 12 22 25 64

Execution Time: 15000 nanoseconds

================================================
*/
