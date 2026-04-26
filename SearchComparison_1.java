import java.util.Scanner;
import java.util.Arrays;

public class SearchComparison_1 {
    public static void linearSearch(int arr[], int n, int key) {

        boolean found = false;

        long start = System.nanoTime();

        for (int i = 0; i < n; i++) {
            System.out.println("Linear Step " + (i + 1) + ": Checking " + arr[i]);

            if (arr[i] == key) {
                System.out.println("Linear Search: Found at position " + (i + 1));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Linear Search: Not Found");
        }

        long end = System.nanoTime();
        System.out.println("Linear Time: " + (end - start) + " ns\n");
    }
    public static void binarySearch(int arr[], int n, int key) {

        int low = 0, high = n - 1;
        int step = 1;
        boolean found = false;

        long start = System.nanoTime();

        while (low <= high) {

            int mid = (low + high) / 2;

            System.out.println("Binary Step " + (step++) + ": Checking " + arr[mid]);

            if (arr[mid] == key) {
                System.out.println("Binary Search: Found at position " + (mid + 1));
                found = true;
                break;
            } 
            else if (arr[mid] < key) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Binary Search: Not Found");
        }

        long end = System.nanoTime();
        System.out.println("Binary Time: " + (end - start) + " ns");
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

        System.out.println("Enter element to search:");
        int key = sc.nextInt();

        // Linear Search (original array)
        System.out.println("\n--- Linear Search ---");
        linearSearch(arr, n, key);

        // Sort for Binary Search
        Arrays.sort(arr);

        System.out.println("\nSorted Array for Binary Search:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

        // Binary Search
        System.out.println("\n--- Binary Search ---");
        binarySearch(arr, n, key);

        sc.close();
    }
}

/*
================ SAMPLE OUTPUT =================

Enter number of elements:
5

Enter elements:
40 10 30 20 50

Enter element to search:
30

--- Linear Search ---
Linear Step 1: Checking 40
Linear Step 2: Checking 10
Linear Step 3: Checking 30
Linear Search: Found at position 3
Linear Time: 9000 ns

Sorted Array for Binary Search:
10 20 30 40 50

--- Binary Search ---
Binary Step 1: Checking 30
Binary Search: Found at position 3
Binary Time: 5000 ns

================================================
*/
