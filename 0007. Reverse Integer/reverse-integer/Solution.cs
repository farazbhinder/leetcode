// submitted on Nov 30, 2017
public class Solution
{
    public int Reverse(int x)
    {
        try
        { 
            if (x % 10 == x)
            {
                return x;
            }

            bool isneg = false;
            if (x < 0) { isneg = true; }

            StringBuilder s = new StringBuilder();
            Console.WriteLine(s.ToString());

            int temp = x;
            if (isneg) { temp = Math.Abs(temp); }
            int rem = 0;
            while (temp % 10 != temp) 
            {
                rem = temp % 10;
                temp = temp / 10;
                s.Append(rem.ToString());
            }
            s.Append(temp);
            if (isneg)
            {
                return -1* Convert.ToInt32(s.ToString());
            }
            else
            {
                return Convert.ToInt32(s.ToString());
            }
        }
        catch (OverflowException e)
        {
            return 0;
        }
    }
}