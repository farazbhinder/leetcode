using System;
using System.Collections.Generic;

// submitted on 01/28/2018 05:41 

namespace _0017._Letter_Combinations_of_a_Phone_Number
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
            foreach(string elem in LetterCombinations("23"))
            {
                Console.Write(elem + ", ");
            }
        }

        public static List<string> AppendCombinations(List<string> listsofar, char dc, Dictionary<char, List<char>> dict)
        {
            List<string> ret = new List<string>();

            for (int i = 0; i < listsofar.Count; i++)
            {
                for (int j = 0; j < dict[dc].Count; j++)
                {
                    ret.Add(listsofar[i] + dict[dc][j]);
                }
            }
            return ret;
        }
        public static IList<string> LetterCombinations(string digits)
        {
            Dictionary<char, List<char>> dict = new Dictionary<char, List<char>>();
            dict.Add('2', new List<char>() { 'a', 'b', 'c' });
            dict.Add('3', new List<char>() { 'd', 'e', 'f' });
            dict.Add('4', new List<char>() { 'g', 'h', 'i' });
            dict.Add('5', new List<char>() { 'j', 'k', 'l' });
            dict.Add('6', new List<char>() { 'm', 'n', 'o' });
            dict.Add('7', new List<char>() { 'p', 'q', 'r', 's' });
            dict.Add('8', new List<char>() { 't', 'u', 'v' });
            dict.Add('9', new List<char>() { 'w', 'x', 'y', 'z' });

            List<string> retlist = new List<string>() { };
            List<string> templist = new List<string>() { "" };
            for (int i = 0; i < digits.Length; i++)
            {
                retlist = AppendCombinations(templist, digits[i], dict);
                templist = new List<string>(retlist);
            }
            return retlist;
        }
    }
}
