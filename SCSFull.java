import java.util.*;

class SCSFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first string:");
        String X = sc.nextLine();

        System.out.println("Enter second string:");
        String Y = sc.nextLine();

        int m = X.length(), n = Y.length();
        int dp[][] = new int[m + 1][n + 1];
        char dir[][] = new char[m + 1][n + 1];

        // Build LCS table with arrows
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    dir[i][j] = '↖';
                } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    dir[i][j] = '↑';
                } else {
                    dp[i][j] = dp[i][j - 1];
                    dir[i][j] = '←';
                }
            }
        }

        // Print table
        System.out.println("DP Table (with arrows):");
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j]);
                if (i > 0 && j > 0)
                    System.out.print(dir[i][j]);
                else
                    System.out.print(" ");
                System.out.print("\t");
            }
            System.out.println();
        }

        // Build SCS string
        int i = m, j = n;
        String scs = "";

        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                scs = X.charAt(i - 1) + scs;
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                scs = X.charAt(i - 1) + scs;
                i--;
            } else {
                scs = Y.charAt(j - 1) + scs;
                j--;
            }
        }

        while (i > 0) {
            scs = X.charAt(i - 1) + scs;
            i--;
        }

        while (j > 0) {
            scs = Y.charAt(j - 1) + scs;
            j--;
        }

        System.out.println("SCS string: " + scs);
        System.out.println("SCS length: " + scs.length());
    }
}
