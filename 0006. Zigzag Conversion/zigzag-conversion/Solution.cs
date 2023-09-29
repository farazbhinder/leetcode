// submitted on Nov 25, 2017
public class Solution
{
    public string Convert(string s, int numRows)
    {
        
        // base cases

        if (numRows <= 1)
        {
            return s;
        }
        
        StringBuilder retstr = new StringBuilder();
        int len = s.Length;
        int trows = numRows;
        int maxjump = (numRows - 1) + (numRows - 1);
        int i = 0;
        int jump = 0;
        int counter = 0;
        int min = 0;
        while (counter < len)
        {
            retstr.Append(s[i]);
            counter++;

            jump = (trows - 1) + (trows - 1);
            if (jump == 0)
            {
                jump = maxjump;
            }
            i = i + jump;
            min = Math.Min(i, min);
            if (i >= len)
            {
                trows = trows - 1;
                i = min + 1;
                min = i;
                continue;
            }

            retstr.Append(s[i]);
            counter++;

            jump = maxjump - jump;
            if (jump == 0)
            {
                jump = maxjump;
            }
            i = i + jump;
            min = Math.Min(i, min);
            if (i >= len)
            {
                trows = trows - 1;
                i = min + 1;
                min = i;
                continue;
            }
        }

        return retstr.ToString();
    }
}