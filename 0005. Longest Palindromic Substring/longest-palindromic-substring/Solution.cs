// submitted on Nov 17, 2017
public class Solution
{
    public string LongestPalindrome(string s)
    {
        int length = s.Length;
        string pal = "";
        bool[,] table = new bool[length, length];

        if(length >= 1)
        {
            pal = s.Substring(0, 1);
        }

        for (int i = 0; i < length; i++)
        {
            table[i, i] = true;
        }

        for (int i = 1; i < length; i++)
        {
            if (s[i] == s[i - 1])
            {
                table[i - 1, i] = true;
                pal = s.Substring(i - 1, 2);
            }
        }

        for (int i = 2; i < length; i++)
        {
            for (int j = i; j < length; j++)
            {
                if (s[j] == s[j - i] && table[j - i + 1, j - 1] == true)
                {
                    table[j - i, j] = true;
                    if (i + 1 > pal.Length)
                    {
                        pal = s.Substring(j - i, i + 1);
                    }
                }
            }
        }
        return pal;
    }
}