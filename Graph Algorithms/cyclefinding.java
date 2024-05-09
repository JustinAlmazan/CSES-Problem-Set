import java.util.*;
import java.io.*;

public class cyclefinding
{
    static ArrayList<Edge>[] alist;
    static int prev [];
    static int [] weights;
    static int n, m;
    static ArrayList<Integer> cycle = new ArrayList<Integer>();

    public static class Edge
    {
        int to, weight;

        public Edge(int too, int weightt)
        {
            to = too;
            weight = weightt;
        }
    }

    public static class Pair implements Comparable<Pair>
    {
        int pos, val;
        
        public Pair(int poss, int vall)
        {
            pos = poss;
            val = vall;
        }
        
        public int compareTo(Pair p) { return (int) (this.val - p.val); }
    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int start)
    {
        for (int i = 2; i <= n; i++) weights[i] = Integer.MAX_VALUE;

        for (int cnt = 1; cnt < n; cnt++)
        {
            for (int i = 1; i <= n; i++)
            {
                for (int j = 0; j < graph[i].size(); j++)
                {
                    int u = i;
                    int v = graph[i].get(j).to;
                    int w = graph[i].get(j).weight;

                    if (weights[u] != Integer.MAX_VALUE && weights[u] + w < weights[v]) 
                    {
                        weights[v] = weights[u] + w;
                        prev[v] = u;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++)
        {
            for (int j = 0; j < graph[i].size(); j++)
            {
                int u = i;
                int v = graph[i].get(j).to;
                int w = graph[i].get(j).weight;
                if (weights[u] != Integer.MAX_VALUE && weights[u] + w < weights[v])
                {
                    getNegativeCycle(graph, u);
                    break;
                }
            }
        }
    }

    public static void getNegativeCycle(ArrayList<Edge>[] graph, int u)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();

        do
        {
            list.add(u);
            set.add(u);
            u = prev[u];
        } while (!set.contains(u));

        list.add(u);
        set.add(u);

        cycle.add(list.get(list.size() - 1));
        int i = list.size() - 2;

        do
        {
            cycle.add(list.get(i));
            i--;
        } while (cycle.get(cycle.size() - 1) != cycle.get(0));
    }

    public static void main(String [] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        alist = new ArrayList[n+1];
        weights = new int [n+1];
        prev = new int [n+1];
        for (int i = 1; i <= n; i++) alist[i] = new ArrayList<Edge>();

        for (int i = 1; i <= m; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            alist[a].add(new Edge(b, c));
        }

        bellmanFord(alist, 1);

        if (cycle.size() == 0) System.out.print("NO");
        else
        {
            System.out.println("YES");
            for (int i = 0; i < cycle.size(); i++) System.out.print(cycle.get(i) + " ");
        }

    }
}