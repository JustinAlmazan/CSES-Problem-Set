import java.util.*;
import java.io.*;

public class discount
{
    static ArrayList<Edge>[] a, b;
    static boolean [] visited;
    static int [] aw, bw;

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

    public static void DJK(ArrayList<Edge>[] alist, int [] weights, int n, int start)
    {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(start, 0));

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

    public static void main(String [] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        a = new ArrayList[n+1];
        b = new ArrayList[n+1];
        visited = new boolean [n+1];
        aw = new int [n+1];
        bw = new int [n+1];
        for (int i = 1; i <= n; i++)
        {
            a[i] = new ArrayList<Edge>(); 
            b[i] = new ArrayList<Edge>();
        }

        for (int i = 1; i <= m; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            a[a1].add(new Edge(b1, c1));
            b[b1].add(new Edge(a1, c1));
        }

        DJK(a, aw, n, 1);
        Arrays.fill(visited, false);
        DJK(b, bw, n, n);

        int res = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++)
        {
            ArrayList<Edge> tmp = a[i];
            for (Edge e1 : tmp)
            {
                res = Math.min(res, aw[i] + bw[e1.to] + e1.weight/2);
            }
        }

        System.out.print(res);
        out.close();
    }
}

