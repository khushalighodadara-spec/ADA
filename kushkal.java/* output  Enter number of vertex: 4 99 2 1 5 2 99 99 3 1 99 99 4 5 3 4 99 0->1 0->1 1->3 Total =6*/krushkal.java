import java.util.*;
public class kushkal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices : ");
        int num = sc.nextInt();
        int matrix[][] = new int[num][num];
        int vi[] = new int[num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                matrix[i][j] = sc.nextInt();
            }
            vi[i] = i;
        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        int count = 0;
        int U = 0, V = 0;
        int min = 0;
        int total = 0;
        while (count < num - 1) {
            min = 99;
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    // min = matrix[i][j] ;
                    if (matrix[i][j] < min) {
                        min = matrix[i][j];
                        U = i;
                        V = j;
                    }
                }
            }
            int Ucomp = vi[U];
            int Vcomp = vi[V];
            if (Ucomp != Vcomp) {
                System.out.println(U + " " + V + " ->" + min);
                count++;
                total += min;
                for (int i = 0; i < num; i++) {
                    if (vi[i] == Ucomp) {
                        vi[i] = Vcomp;
                    }
                }
            }
            matrix[U][V] = matrix[V][U] = 99;
        }
        System.out.println("total = " + total);
        sc.close();
    }
}
/* output 
Enter number of vertex: 4
99 2 1 5
2 99 99 3
1 99 99 4
5 3 4 99
0->1
0->1
1->3
Total =6*/
