import java.util.*;
import java.io.*;

public class roads
{
    static int n, m;
    static ArrayList<Integer>[] alist;
    static boolean [] visited;
    static ArrayList<Integer> notConnected = new ArrayList<>();
    
    public static void main(String [] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        alist = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) alist[i] = new ArrayList<>();
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            alist[a].add(b);
            alist[b].add(a);
        }

        numGraphs();

        System.out.println(notConnected.size() - 1);

        for (int i = 1; i < notConnected.size(); i++)
        {
            System.out.println(notConnected.get(i-1) + " " + notConnected.get(i));
        }

    }

    public static void numGraphs()
    {
        for (int i = 1; i <= n; i++)
        {
            if (visited[i] == true) continue;
            notConnected.add(i);
            fill(i);
        }
    }

    public static void fill(int cur)
    {
        visited[cur] = true;

        for (int i = 0; i < alist[cur].size(); i++)
        {
            int next = alist[cur].get(i);
            if (!visited[next]) fill(next);
        }
    }
}