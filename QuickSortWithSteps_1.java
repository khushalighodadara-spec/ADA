import java.util.Scanner;

public class QuickSortWithSteps_1 {

    static int step = 1;

    public static int partition(int arr[], int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // print step after partition
        System.out.print("Step " + (step++) + ": ");
        printArray(arr);

        return i + 1;
    }

    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void printArray(int arr[]) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

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

        quickSort(arr, 0, n - 1);

        long endTime = System.nanoTime();

        System.out.println("\nSorted Elements:");
        printArray(arr);

        long time = endTime - startTime;
        System.out.println("\nExecution Time: " + time + " nanoseconds");

        sc.close();
    }
}

/*
================ SAMPLE OUTPUT =================

Enter number of elements:
5

Enter elements:
64 25 12 22 11

Step 1: 11 25 12 22 64
Step 2: 11 12 22 25 64
Step 3: 11 12 22 25 64

Sorted Elements:
11 12 22 25 64

Execution Time: 15000 nanoseconds

================================================
*/
