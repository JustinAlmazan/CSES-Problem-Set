import java.util.*;
import java.io.*;
 
public class rectanglecutting
{
    static int MAX = 500;
 
    public static void main(String [] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
 
        int max = Math.max(a, b);
        int min = Math.min(a, b);
 
        int [][] dp = new int [MAX+1][MAX+1];
 
        for (int i = 2; i <= MAX; i++)
        {
            dp[i][1] = i - 1;
            dp[1][i] = i - 1;
        }
 
        for (int i = 2; i <= min; i++)
        {
            for (int j = i + 1; j <= max; j++)
            {
                dp[i][j] = (int) 1e6;
                for (int k = 1; k <= j/2; k++)
                {
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j-k] + dp[i][k]);
                }
 
                for (int k = 1; k <= i/2; k++)
                {
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i-k][j] + dp[k][j]);
                }
                dp[j][i] = dp[i][j];
            }
        }
 
        System.out.print(dp[a][b]);
    }
}