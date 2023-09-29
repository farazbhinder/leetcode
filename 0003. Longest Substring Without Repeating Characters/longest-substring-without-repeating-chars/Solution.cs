// submitted on Nov 11, 2017

public class Solution
{
    public int LengthOfLongestSubstring(string s)
    {
        HashSet<char> tempset = new HashSet<char>();
        
        int size = 0;
        for (int i = 0; i < s.Length; i++)
        {
            int j = i;
            while (j < s.Length)
            {
                if (! tempset.Contains(s[j]))
                {
                    tempset.Add(s[j]);
                }
                else
                {
                    break;
                }
                j++;
            }
            if (tempset.Count > size)
            {
                size = tempset.Count;
            }
            tempset.Clear();
        }

        return size;
    }
}