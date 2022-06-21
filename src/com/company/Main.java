package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] b = new int[10];
        int w=0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                w = (i+1)*(j+1);
                while (w != 0)
                {
                    b[w%10] += 1;
                    w/=10;
                }
            }
        }
        for(int i = 0; i < b.length; i++)
        {
            System.out.println(b[i]);
        }
    }
}
