import java.util.*;
import java.io.*;

public class roundtrip
{
    static ArrayList<Integer>[] alist;
    static ArrayList<Integer> res = new ArrayList<Integer>();
    static int n;
    static int [] prev;

    public static void main(String [] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        alist = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) alist[i] = new ArrayList<>();

        for (int i = 1; i <= m; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            alist[a].add(b);
            alist[b].add(a);
        }

        prev = new int [n+1];

        for (int i = 1; i <= n; i++)
        {
            if (prev[i] == 0)
            {
                checkCycles(i, -1);
            }
        }

        if (res.size() == 0) System.out.print("IMPOSSIBLE");

        else
        {
            System.out.println(res.size());
            Collections.reverse(res);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
        }
    }

    public static void checkCycles(int cur, int from)
    {
        prev[cur] = from;

        for (int i = 0; i < alist[cur].size(); i++)
        {
            int next = alist[cur].get(i);

            if (from != -1 && prev[next] != cur && next != from && res.size() == 0)
            {
                res.add(next);
                getCycle(cur);
                break;
            }

            else if (prev[next] < 1) return;

            checkCycles(next, cur);
        }
    }

    public static void getCycle(int x)
    {
        res.add(x);
        if (x == res.get(0)) return;
        getCycle(prev[x]);
    }
}