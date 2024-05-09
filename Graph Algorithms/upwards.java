import java.util.*;
import java.io.*;

public class upwards
{
    public static void main(String [] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();

        for (int tc = 0; tc < c; tc++)
        {
            int k = sc.nextInt() + 1;  // SPACE BETWEEN LETTERS
            int n = sc.nextInt();      // NUMBER OF LETTERS
            int r = sc.nextInt();      // Nth COMBINATION

            char [] letters = new char [n];
            letters[0] = 'a';
            
            for (int i = 1; i < n; i++)
                letters[i] = letters[i-1] + k;

            int cur = 1;
            
            for (int i = 0; i < n; i++)
            {
                int inc = increment(n - i, 'z' - letters[n-1] + 1);

                while (cur + inc <= r)
                {
                    for (int j = i; j < n; j++)
                        letters[j]++;
                    
                    cur += inc;

                    inc = increment(n - i, 'z' - letters[n-1] + 1);
                }
            }

            System.out.println(String.valueOf(letters));
        }
    }

    public static boolean increment(int n, int d)
    {
        int res = 1;

        for (int i = 0; i < n; i++)
        {
            res *= d + i;
            res /= i + 1;
        }
        
        return res;
    }
}