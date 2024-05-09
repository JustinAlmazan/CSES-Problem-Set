import java.util.*;
import java.io.*;

public class message
{
    static int n, m;
    static ArrayList<Integer>[] alist;
    static int [] visited;
    static ArrayList<Integer> path = new ArrayList<>();

    public static void main(String [] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        visited = new int [n+1];
        alist = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) alist[i] = new ArrayList<Integer>();

        for (int i = 0; i < m; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            alist[a].add(b);
            alist[b].add(a);
        }

        BFS(1, n);

        if (path.size() == 0)
        {
            System.out.print("IMPOSSIBLE");
            return;
        }

        System.out.println(path.size());
        for (int i = 0; i < path.size(); i++) System.out.print(path.get(i) + " ");
    }

    public static void BFS(int start, int end)
    {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);

        while (!q.isEmpty())
        {
            int cur = q.poll();

            for (int i = 0; i < alist[cur].size(); i++)
            {
                int next = alist[cur].get(i);

                if (visited[next] != 0) continue;

                visited[next] = cur;

                if (next == n)
                {
                    int prev = n;

                    while (prev != 1)
                    {
                        path.add(prev);
                        prev = visited[prev];
                    }

                    path.add(1);
                    Collections.reverse(path);
                    return;
                }

                q.add(next);
            }
        }
    }
}