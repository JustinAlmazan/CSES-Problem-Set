import java.util.*;
import java.io.*;

public class arraydescription
{
    static int MOD = (int) 1e9 + 7;
    public static void main(String [] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [][] dp = new int [n][m+2];
        int res = 1;
        int tmp = sc.nextInt();

        int i = 0;

        if (tmp == 0)
        {
            for (int j = 1; j <= m; j++) dp[0][j] = 1;

            tmp = sc.nextInt();
            i++;

            while (tmp == 0)
            {
                for (int j = 1; j <= m; j++) dp[i][j] = (dp[i][j] + dp[i-1][j-1] + dp[i-1][j] + dp[i-1][j+1]) % MOD;

                if (i == n - 1)
                {
                    res = 0;
                    for (int k = 1; k <= m; k++) res = (res + dp[i][k]) % MOD;
                    System.out.print(res);
                    return;
                }

                i++;
                tmp = sc.nextInt();
            }

            res = (res * (dp[i-1][tmp-1] + dp[i-1][tmp] + dp[i-1][tmp+1])) % MOD;
        }

        for (; i < n; i++)
        {
            if (i == 0) continue;
            dp[i-1][tmp] = 1;
            tmp = sc.nextInt();
            if (tmp != 0) continue;

            while (tmp == 0)
            {
                for (int j = 1; j <= m; j++) dp[i][j] = (dp[i][j] + dp[i-1][j-1] + dp[i-1][j] + dp[i-1][j+1]) % MOD;

                if (i == n - 1)
                {
                    int tempRes = 0;
                    for (int k = 1; k <= m; k++) tempRes = (tempRes + dp[i][k]) % MOD;
                    res = (res * tempRes) % MOD;
                    System.out.print(res);
                    return;
                }

                i++;
                tmp = sc.nextInt();
            }

            if (i != 0) res = res * (dp[i-1][tmp-1] + dp[i-1][tmp] + dp[i-1][tmp+1]);
        }

        System.out.print(res);
    }
}