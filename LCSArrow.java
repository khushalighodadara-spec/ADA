import java.util.*;

class LCSArrow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first string:");
        String X = sc.nextLine();

        System.out.println("Enter second string:");
        String Y = sc.nextLine();

        int m = X.length(), n = Y.length();
        int dp[][] = new int[m + 1][n + 1];
        char dir[][] = new char[m + 1][n + 1];

        // Fill table
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

        // Print table with arrows
        System.out.println("DP Table with Arrows:");
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

        System.out.println("LCS length: " + dp[m][n]);
    }
}
/*
Enter first string:
ABCBDAB
Enter second string:
BDCAB

DP Table with Arrows:
0   0   0   0   0   0
0   0↖ 0← 0← 1↖ 1←
0   1↖ 1← 1← 1↑ 2↖
0   1↑ 1↑ 2↖ 2← 2↑
0   1↖ 1← 2↑ 2↑ 3↖
0   1↑ 2↖ 2← 2↑ 3↑
0   1↑ 2↑ 2↑ 3↖ 3←
0   1↑ 2↑ 2↑ 3↑ 4↖

LCS length: 4
  */
