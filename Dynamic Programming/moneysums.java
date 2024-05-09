import java.util.*;
import java.io.*;

public class moneysums
{
    public static void main(String [] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] c = new int [n];
        for (int i = 0; i < n; i++) c[i] = sc.nextInt();
        
        TreeSet<Integer> sums = new TreeSet<Integer>();
        sums.add(c[0]);
        for (int i = 1; i < n; i++)
        {
            HashSet<Integer> temp = new HashSet<Integer>();
            for (int element : sums)
            {
                temp.add(element + c[i]);
            }

            for (int element: temp)
            {
                sums.add(element);
            }

            sums.add(c[i]);
        }

        System.out.println(sums.size());
        for (int element : sums) System.out.print(element + " ");
    }
}