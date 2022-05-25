package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        String[][] arr = new String[4][4];
        String[] additional;
        Scanner scan = new Scanner(System.in);
        for (int t = 0; t < 4; t++)
        {
            additional = scan.nextLine().split("");
            for (int i = 0; i < 4; i++)
            {
                arr[t][i] = additional[i];
            }
        }
        for (int t = 0; t < 3; t++)
        {
            for (int i = 0; i < 3; i++)
            {
                if ((Objects.equals(arr[t][i], arr[t + 1][i]) && Objects.equals(arr[t][i], arr[t + 1][i + 1]) && Objects.equals(arr[t][i], arr[t][i + 1]))) {System.out.println("No"); System.exit(0);}
            }
        }

        System.out.println("Yes");
    }
}
