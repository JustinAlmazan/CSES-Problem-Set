import java.util.*;
import java.io.*;

public class teams
{
    static int n, m;
    static ArrayList<Integer>[] alist;
    static int [] team;
    static boolean impossible = false;

    public static void main(String [] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        team = new int [n+1];
        alist = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) alist[i] = new ArrayList<Integer>();

        for (int i = 0; i < m; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            alist[a].add(b);
            alist[b].add(a);
        }

        for (int i = 1; i < n; i++)
        {
            if (team[i] == 0) color(i, 1);
        }

        if (impossible)
        {
            System.out.println("IMPOSSIBLE");
            return;
        }

        for (int i = 1; i <= n; i++) System.out.print(team[i] + " ");
    }

    public static void color(int cur, int group)
    {
        int newGroup = (group % 2) + 1;

        if (team[cur] == newGroup) impossible = true;
        if (team[cur] == 0)
        {
            team[cur] = group;
            for (int i = 0; i < alist[cur].size(); i++) color(alist[cur].get(i), newGroup);
        }
    }
}