import java.util.*;
import java.io.*;

public class routes1
{
    static ArrayList<Edge>[] alist;
    static boolean [] visited;
    static int [] weights;

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

    public static void main(String [] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        alist = new ArrayList[n+1];
        visited = new boolean [n+1];
        weights = new int [n+1];
        for (int i = 1; i <= n; i++) alist[i] = new ArrayList<Edge>();

        for (int i = 1; i <= m; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            alist[a].add(new Edge(b, c));
        }

        DJK(n);

        for (int i = 1; i <= n; i++) System.out.print(weights[i] + " ");

        out.close();
    }

    public static void DJK(int n)
    {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(1, 0));

        while (!q.isEmpty())
        {
            int cur = q.remove().pos;

            if (visited[cur]) continue;
            
            visited[cur] = true;

            for (int i = 0; i < alist[cur].size(); i++)
            {
                int des = alist[cur].get(i).to;
                int cost = alist[cur].get(i).weight;

                if (visited[des] == true) continue;
                else if (weights[des] == 0) weights[des] = weights[cur] + cost;
                else weights[des] = Math.min(weights[des], weights[cur] + cost);

                q.add(new Pair(des, weights[des]));
            }
        }

    }
}