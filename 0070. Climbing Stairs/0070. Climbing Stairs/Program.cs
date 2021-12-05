using System;
using System.Collections.Generic;

// submitted on 02/05/2018 20:12 

namespace _0070._Climbing_Stairs
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(ClimbStairs(3));
        }

        static Dictionary<int, int> waysdict = new Dictionary<int, int>();
        public static int ClimbStairs(int n)
        {

            if (waysdict.ContainsKey(n))
            {
                return waysdict[n];
            }
            else if (n <= 0)
            {
                return 0;
            }
            else if (n == 1)
            {
                waysdict.Add(n, 1);
                return 1;
            }
            else if (n == 2)
            {
                waysdict.Add(n, 2);
                return 2;
            }
            else
            {
                int ways = ClimbStairs(n - 1) + ClimbStairs(n - 2);
                waysdict.Add(n, ways);
                return ways;
            }
        }
    }
}
