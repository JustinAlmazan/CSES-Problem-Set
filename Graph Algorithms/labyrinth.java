import java.util.*;
import java.io.*;

public class labyrinth
{
    static int n, m;
    static char [][] map;
    static boolean [][] visited;
    static Point A, B;
    static int [] dX = {-1, 0, 0, 1};
    static int [] dY = {0, -1, 1, 0};
    static char [] moves = {'U', 'L', 'R', 'D'};

    public static void main(String [] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        map = new char[n][m];
        visited = new boolean[n][m];

        sc.nextLine();

        for (int i = 0; i < n; i++)
        {
            String tmp = sc.nextLine();

            for (int j = 0; j < m; j++)
            {
                map[i][j] = tmp.charAt(j);

                if (map[i][j] == '#') visited[i][j] = true;
                else if (map[i][j] == 'A') A = new Point(i, j);
                else if (map[i][j] == 'B') B = new Point(i, j);
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(A);

        while (!q.isEmpty())
        {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++)
            {
                Point next = new Point(cur.x + dX[i], cur.y + dY[i]);

                if (next.x < 0 || n <= next.x || next.y < 0 || m <= next.y) continue;
                if (visited[next.x][next.y] == true) continue;

                visited[next.x][next.y] = true;
                map[next.x][next.y] = (char) i;
                q.add(next);
            }
        }

        if (!visited[B.x][B.y])
        {
            System.out.print("NO");
            return;
        }

        ArrayList<Integer> path = new ArrayList<>();
        
        while (A.x != B.x || A.y != B.y)
        {
            int prev = (int) map[B.x][B.y];
            path.add(prev);

            B.x -= dX[prev];
            B.y -= dY[prev];
        }

        Collections.reverse(path);

        System.out.println("YES");
        System.out.println(path.size());
        for (int move : path) System.out.print(moves[move]);
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