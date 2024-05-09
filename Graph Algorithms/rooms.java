import java.util.*;
import java.io.*;

public class rooms
{
    static int n, m;
    static char [][] map;

    public static void main(String [] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];
        sc.nextLine();
        
        for (int i = 0; i < n; i++)
        {
            String tmp = sc.nextLine();

            for (int j = 0; j < m; j++)
            {
                map[i][j] = tmp.charAt(j);
            }
        }

        System.out.print(solve());
    }

    public static int solve()
    {
        int res = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (map[i][j] == '.')
                {
                    res++;
                    deleteRoom(i, j);
                }
            }
        }

        return res;
    }

    public static void deleteRoom(int a, int b)
    {
        map[a][b] = '#';

        if (a > 0 && map[a-1][b] == '.') deleteRoom(a-1, b);
        if (a < n - 1 && map[a+1][b] == '.') deleteRoom(a+1, b);
        if (b > 0 && map[a][b-1] == '.') deleteRoom(a, b-1);
        if (b < m - 1 && map[a][b+1] == '.') deleteRoom(a, b+1);
    }
}