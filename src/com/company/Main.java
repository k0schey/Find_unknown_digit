package com.company;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int position = scan.nextInt(); // позиция Василия в очереди

        if (position-1 > 144)
        {
            System.out.println("NO");
        }
        else
        {
            for (int i = -1; i < 144; i++)
            {
                position--;
                if (position == 0)
                {
                    int hours = (i+1)/12;
                    int minutes = ((i+1)%12)*5;

                    System.out.println(hours + " " + minutes);
                    break;
                }
            }
        }
    }
}
