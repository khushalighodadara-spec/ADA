import java.util.* ;
public class knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        System.out.println("Enetr a number of item you want to put to sell : ");
        int n = sc.nextInt() ;
        int w[] = new int[n+1] ;
        int v[] = new int[n+1] ;
        System.out.println("Enter a maximum capacity of your beg : ");
        int W = sc.nextInt() ;
        int V[][] = new int[n+1][W+1] ;
        for(int i = 1 ; i < n+1 ; i++){
            System.out.print("Enter weight of item : ");
            w[i] = sc.nextInt() ;
            System.out.print("Enter value of item : ");
            v[i] = sc.nextInt() ;
        }
        for(int i = 1 ; i < n+1 ; i++){
        for(int j = 1 ; j < W+1  ; j++) {
            if(j < w[i]){
                    V[i][j] = V[i-1][j] ;
                }
                else{
                    V[i][j] = Math.max(V[i-1][j],V[i-1][j-w[i]] + v[i]) ;
                }
            }
        }
        for(int i = 1 ; i < n+1 ; i++) {
            for(int j = 1 ; j < W+1 ; j++){
                System.out.print(V[i][j] + " ");
            }
            System.out.println();
        }
        sc.close(); 
    }
}
/*output 
Enter number of item you want to put to sell :
3
Enter maximum capacity of your bag :
5
Enter weight of item : 1
Enter value of item : 6
Enter weight of item : 2
Enter value of item : 10
Enter weight of item : 3
Enter value of item : 12
DP Table:
6 6 6 6 6
6 10 16 16 16
6 10 16 18 22
Maximum Profit = 22 */
