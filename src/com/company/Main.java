package com.company;

import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println(solveExpression("?8?170-1?6256=7?2?14"));
    }

    public static int solveExpression(String m)
    {
        System.out.println(m);

        char[] n = m.toCharArray();
        List<Character> num1 = new ArrayList<Character>();
        char operator = 'q';
        List<Character> num2 = new ArrayList<Character>();
        List<Character> num3 = new ArrayList<Character>();

        int y = 0;
        int add = 0;
        num1.add(n[0]);
        for(int i = 1; (n[i] != ('*') && n[i] != ('-') && n[i] != ('+')); i++)
        {
            num1.add(n[i]);
            add = i;
        }
        y = add + 1;
        operator = n[y];
        int t = 0;
        for(int i = y+1; n[i]!='='; i++)
        {
            num2.add(n[i]);
            t++;
            y = i+1;
        }
        t=0;
        for(int i = y+1; i < n.length; i++)
        {
            num3.add(n[i]);
            t++;
        }

        // просто надо перебрать!
        for(int i = 0; i < 10; i++)
        {
            if (m.contains("??") && ((i == 0))) continue;
            else if (m.contains((String.valueOf(i)))) continue;
            else if ((((num1.get(0) == '?') && num1.size() != 1) || ((num2.get(0) == '?') && num2.size() != 1) || ((num3.get(0) == '?') && num3.size() != 1) ||
                    ((num1.get(0) == '-') && (num1.get(1) == '?')) || ((num2.get(0) == '-') && (num2.get(1) == '?')) ||
                    ((num3.get(0) == '-') && (num3.get(1) == '?'))) && (i == 0) )
            {
                continue;
            }
            else if (operator == '+')
            {
                if (ret(num1, i) + ret(num2, i) == ret(num3, i)) return i;
            }
            else if (operator == '-')
            {
                if (ret(num1, i) - ret(num2, i) == ret(num3, i)) return i;
            }
            else if (operator == '*')
            {
                if (ret(num1, i) * ret(num2, i) == ret(num3, i)) return i;
            }
        }

        return -1;
    }
    /*
        //TODO: сделать при ??+??=1
        Return a = ret(num1);
        Return b = ret(num2);
        Return c = ret(num3);

        if (operator == '+')
        {
            int d = (a.equation + b.equation - c.equation)/(c.coef-a.coef- b.coef);
            if ((d > 9) || d <= 0) return -1;
            else return d;
        }
        else if (operator == '-')
        {
            int d = (a.equation - b.equation - c.equation)/(c.coef-a.coef- b.coef);
            if ((d > 9) || d < 0) return -1;
            else return d;
        }
        else
        {
            if (num1.contains('?') && num2.contains('?'))
            {
                int q = a.coef*b.coef;
                int w = a.equation*b.coef + b.equation*a.coef - c.coef;
                int e = a.equation*b.equation - c.equation;

                if((q==0) && (w ==0) && (e==0)) return -1;
                double s = Math.sqrt(w*w - 4*q*e);
                if ((s >= 0) && (s % 1 == 0))
                {
                    int first = (int)(-w+s)/(2*q);
                    int second = (int)(-w+s)/(2*q);
                    if (first >= 0)
                    {
                        if (second < 0) return first;
                        else if (first < second) return first;
                        else return second;
                    }
                    else if (second >= 0)
                    {
                        return second;
                    }
                    else return -1;
                }
                else return -1;
            }
            else if (num1.contains('?'))
            {
                if ((a.equation*b.equation == c.equation) && (c.coef - b.coef* b.equation == 1)) System.out.println("dsadad");
                int d = (a.equation* b.equation-c.equation)/(c.coef -b.coef* b.equation);
                System.out.println((char)d + " ds");
                if ((d > 9) || d < 0) return -1;
                else return d;
            }
            else
            {
                int d = (a.equation* b.equation-c.equation)/(c.coef -a.equation* b.coef);
                /*if(d==0)
                {
                    for (int i = 1; i < 9; i++)
                    {
                        if (num1.contains(String.valueOf(i).toCharArray()[0]) || num2.contains(String.valueOf(i).toCharArray()[0]) || num3.contains(String.valueOf(i).toCharArray()[0]))
                        {
                            System.out.println("s");
                            continue;
                        }
                        else return i;
                    }
                }
                if ((d > 9) || d < 0) return -1;
                else return d;
            }
        }*/

    static boolean contains_x(List<Character> n, char x)
    {
        int d = 0;
        for (int i = 0; i < n.size(); i++)
        {
            if (n.get(i) == '?') d++;
        }
        if (d >= 2) return true;
        else return false;
    }

    static int ret(List<Character> num, int q)
    {
        int equation = 0;
        int coef = 0;
        if (num.get(0) == '-')
        {
            for (int i = num.size()-1; i > 0; i--)
            {
                if (num.get(i) != '?') equation += -Integer.parseInt(num.get(i).toString())*Math.pow(10, num.size()-1-i);
                else equation += -q*(int)Math.pow(10, num.size()-1-i);
            }
        }
        else
        {
            for (int i = num.size()-1; i > -1; i--)
            {
                if (num.get(i) != '?') equation += Integer.parseInt(num.get(i).toString())*Math.pow(10, num.size()-1-i);
                else equation += q*(int)Math.pow(10, num.size()-1-i);
            }
        }
        return equation;
    }
}

