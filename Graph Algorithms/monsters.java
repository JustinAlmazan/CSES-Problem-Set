import java.util.*;
import java.io.*;

public class monsters
{
    static char [][] grid;
    static int [][] steps;
    static ArrayList<Point> monsters = new ArrayList<Point>();
    static ArrayList<Point> exits = new ArrayList<Point>();
    static ArrayList<Character> res = new ArrayList<Character>();
    static int n, m;

    public static void main(String [] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        Point me = new Point(-1, -1);
        grid = new char [n][m];
        steps = new int [n][m];

        for (int i = 0; i < n; i++)
        {
            String tmp = sc.nextLine();

            for (int j = 0; j < m; j++)
            {
                grid[i][j] = tmp.charAt(j);

                if ((i == 0 || i == n-1 || j == 0 || j == m-1) && grid[i][j] == '.')
                {
                    exits.add(new Point(i, j));
                }
                else if (grid[i][j] == 'M') monsters.add(new Point(i, j));
                else if (grid[i][j] == 'A') me = new Point(i, j);
            }
        }

        for (int i = 0; i < monsters.size(); i++) traverse(monsters.get(i), 1);

        ArrayList<Integer> dist = new ArrayList<Integer>();
        for (int i = 0; i < exits.size(); i++)
        {
            int x = exits.get(i).x;
            int y = exits.get(i).y;
            dist.add(steps[x][y]);
        }

        traverse(me, 1);

        for (int i = 0; i < exits.size(); i++)
        {
            int x = exits.get(i).x;
            int y = exits.get(i).y;
            
            if (steps[x][y] < dist.get(i))
            {
                backtrack(new Point(x, y));
                break;
            }
        }

        if (res.size() == 0) System.out.print("NO");
        else
        {
            System.out.println("YES");
            Collections.reverse(res);
            System.out.println(res.size());
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i));
        }
    }

    public static void backtrack(Point p)
    {
        int x = p.x;
        int y = p.y;

        if (steps[x][y] == 1) return;
        else if (x-1 >= 0 && steps[x][y] - 1 == steps[x-1][y])
        {
            res.add('D');
            backtrack(new Point(x-1, y));
        }
        else if (x+1 < n && steps[x][y] - 1 == steps[x+1][y])
        {
            res.add('U');
            backtrack(new Point(x+1, y));
        }
        else if (y-1 >= 0 && steps[x][y] - 1 == steps[x][y-1])
        {
            res.add('R');
            backtrack(new Point(x, y-1));
        }
        else if (y+1 < m && steps[x][y] - 1 == steps[x][y+1])
        {
            res.add('L');
            backtrack(new Point(x, y+1));
        }

    }

    public static void traverse(Point p, int numSteps)
    {
        int x = p.x;
        int y = p.y;

        if (grid[x][y] == '#') return;

        else if (steps[x][y] == 0 || steps[x][y] >= numSteps)
        {
            steps[x][y] = numSteps;
            
            if (x-1 >= 0) traverse(new Point(x-1, y), numSteps + 1);
            if (x+1 <= n-1) traverse(new Point(x+1, y), numSteps + 1);
            if (y-1 >= 0) traverse(new Point(x, y-1), numSteps + 1);
            if (y+1 <= m-1) traverse(new Point(x, y+1), numSteps + 1);
        }
    }

}

class Point
{
    int x, y;

    public Point(int a, int b)
    {
        x = a;
        y = b;
    }
}