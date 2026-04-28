import java.util.*;
public class MCM {
    void print(int s[][] , int i , int j){
        if(i == j){
            System.out.print("A" + i);
        }
        else{
            System.out.print("(");
            print(s, i, s[i][j]);
            print(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();
        int p[] = new int[n + 1];
        System.out.println("Enter dimensions array (size " + (n + 1) + "):");
        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }
        int m[][] = new int[n+1][n+1];
        int s[][] = new int[n+1][n+1] ;
        for (int i = 1; i < n; i++)
            m[i][i] = 0;
        for (int L = 2; L < n+1; L++) {
            for (int i = 1; i < n - L + 2; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];

                    if (q < m[i][j]){

                        m[i][j] = q;
                        s[i][j] = k ;
                    }
                }
            }
        }
        System.out.println("m matrix:");
        for(int i = 1 ; i < n+1 ; i++){
            for(int j = 1 ; j < n+1 ; j++){
                if(i < j )
                    System.out.print(m[i][j] +  " ");
            }
            System.out.println();
        }
        System.out.println("s matrix:");
        for(int i = 1 ; i < n+1 ; i++){
            for(int j = 1 ; j < n+1 ; j++){
                if(i < j )
                    System.out.print(s[i][j] +  " ");
            }
            System.out.println();
        }
        MCM mcm = new MCM();
        System.out.print("Optimal parenthesization is:");
        mcm.print(s, 1, n);
        System.out.println();
        System.out.println("Minimum number of multiplications is: " + m[1][n]);
        sc.close();
    }
}
/* output 
Enter number of matrix 4
enter rows and columns of matrix 
2
5
8
9
4
m matrix 
80 224 296
360 448
288
s matrix 
1 2 3
2 2
3 
optimal parenthesization ia (((A1A2)A3)A4)
Minimum number of multiplication ia 296 */
