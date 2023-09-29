// submitted on Nov 13, 2017
public class Solution
{
    public double FindMedianSortedArrays(int[] nums1, int[] nums2)
    {
        double median = 0;

        // handle all base cases i.e. nums1 or nums2 of size 0,1,2
        if (nums1.Length == 0 && nums2.Length == 0)
        {
            throw new Exception("no median of both empty arrays");
        }
        else if (nums1.Length == 0 && nums2.Length == 1)
        {
            median = nums2[0];
        }
        else if (nums1.Length == 0 && nums2.Length == 2)
        {
            median = (double)(nums2[0] + nums2[1]) / 2;
        }
        else if (nums1.Length == 1 && nums2.Length == 0)
        {
            median = nums1[0];
        }
        else if (nums1.Length == 1 && nums2.Length == 1)
        {
            median = (double)(nums1[0] + nums2[0]) / 2;
        }
        else if (nums1.Length == 1 && nums2.Length == 2)
        {
            median = Math.Min(Math.Max(nums1[0], nums2[0]), nums2[1]); //
        }
        else if (nums1.Length == 2 && nums2.Length == 0)
        {
            median = (double)(nums1[0] + nums1[1]) / 2;
        }
        else if (nums1.Length == 2 && nums2.Length == 1)
        {
            median = Math.Min(Math.Max(nums2[0], nums1[0]), nums1[1]); //
        }
        else if (nums1.Length == 2 && nums2.Length == 2)
        {
            median = (double)(Math.Max(nums1[0], nums2[0]) + Math.Min(nums1[1], nums2[1])) / 2;
        }
        else if (nums1.Length % 2 == 1 && nums2.Length % 2 == 1 && nums1[nums1.Length / 2] == nums2[nums2.Length / 2])
        {
            median = nums1[nums1.Length / 2];
        }
        else
        {
            // atleast one of the two arrays has size >=3
            int[] larger;
            int[] smaller;
            if (nums1.Length > nums2.Length)
            {
                larger = nums1;
                smaller = nums2;
            }
            else
            {
                larger = nums2;
                smaller = nums1;
            }

            if (smaller.Length == 0)
            {
                if (larger.Length % 2 == 0)
                {
                    median = (double)(larger[(larger.Length / 2) - 1] + larger[larger.Length / 2]) / 2;
                }
                else
                {
                    median = larger[larger.Length/2];
                }
            }
            else if (smaller.Length == 1)
            {
                median = FitOneSizeArrInLargerArr(smaller[0], larger, 0, larger.Length-1);
            }
            else if (smaller.Length == 2)
            {
                median = FitTwoSizeArrInLargerArr(smaller, larger, 0, larger.Length - 1);
            }
            else
            {
                // larger arr size >=3;
                int i = 0;
                int j = larger.Length-1;

                int p = 0;
                int q = smaller.Length-1;

                int lmid_idx = (j - i + 1) / 2;
                int smid_idx = (q - p + 1) / 2;
                if ((smaller[smid_idx] == larger[lmid_idx]) && 
                        (larger.Length % 2 == 0 && smaller.Length % 2 == 0))
                {
                    median = (double)(Math.Max(smaller[smid_idx - 1], larger[lmid_idx-1]) + Math.Min(smaller[smid_idx], larger[lmid_idx])) / 2;
                }
                else if ((smaller[smid_idx] == larger[lmid_idx]) &&
                    ((larger.Length % 2 == 0 && smaller.Length % 2 == 1) ||
                         (larger.Length % 2 == 1 && smaller.Length % 2 == 0) ||
                            (larger.Length % 2 == 1 && smaller.Length % 2 == 1)))
                {
                    median = smaller[smid_idx];  
                }
                else
                {
                    int count1 = 0;
                    int count2 = 0;
                    int nums_count_to_remove = 0;
                    while (j - i + 1 > 2 && q - p + 1 > 2)
                    {
                        lmid_idx = ((j - i + 1) / 2) + i;
                        smid_idx = ((q - p + 1) / 2) + p;



                        if (smaller[smid_idx] < larger[lmid_idx])
                        {
                            nums_count_to_remove = smid_idx - p;
                            if ((q - p + 1)% 2 == 0)
                            {
                                nums_count_to_remove = nums_count_to_remove - 1;
                            }
                            p = p + nums_count_to_remove;
                            j = j - nums_count_to_remove;
                        }
                        else
                        {
                            nums_count_to_remove = q - smid_idx;
                            q = q - nums_count_to_remove;
                            i = i + nums_count_to_remove;
                        }
                    }
                    if (q - p + 1 == 2 && j - i + 1 >= 2)
                    {
                        median = FitTwoSizeArrInLargerArr(new int[] { smaller[p], smaller[q]}, larger, i, j);
                    }
                    else if (q - p + 1 == 1 && j - i + 1 >= 2)
                    {
                        median = FitOneSizeArrInLargerArr(smaller[p], larger, i, j);
                    }
                }
            }

        }
        return median;
    }

    public double GetMedian(int[] arr, int i, int j)
    {
        int len = j - i + 1;
        int mid = i + len / 2;
        if (len % 2 == 0)
        {
            return  (double)(arr[mid-1] + arr[mid]) / 2;
        }
        else
        {
            return arr[mid];
        }
    }

    public double FitOneSizeArrInLargerArr(int s, int[] larr, int i, int j) // param1 is one size arr
    {
        int lleng = j - i + 1;
        int mid = (lleng / 2) + i;
        if (lleng % 2 == 0)
        {
            return Math.Min(Math.Max(s, larr[mid-1]), larr[mid]);
        }
        else
        {
            return (double)(Math.Min(Math.Max(s, larr[mid - 1]), larr[mid]) + Math.Min(Math.Max(s, larr[mid]), larr[mid + 1])) / 2;
        }
    }

    public double FitTwoSizeArrInLargerArr(int[] sarr, int[] larr, int i, int j) // param1 is two size arr
    {
        if (sarr.Length == 2 && j-i+1 == 2)
        {
            return (double)(Math.Max(sarr[0], larr[i]) + Math.Min(sarr[1], larr[j])) / 2;
        }

        int lleng = j - i + 1;
        int mid = (lleng / 2) + i;
        if (lleng % 2 == 0)
        {
            if (sarr[1] <= larr[i])
            {
                return (double)(larr[mid - 2] + larr[mid-1]) / 2;
            }
            else if (sarr[0] >= larr[j])
            {
                return (double)(larr[mid] + larr[mid + 1]) / 2;
            }
            else if (sarr[1] <= larr[mid-2])
            {
                return (double)(larr[mid-2] + larr[mid - 1]) / 2;
            }
            else if (sarr[0] >= larr[mid+1])
            {
                return (double)(larr[mid] + larr[mid + 1]) / 2;
            }
            return (double)(Math.Max(sarr[0], larr[mid-1]) + Math.Min(sarr[1], larr[mid])) / 2;
        }
        else
        {
            if (sarr[1] < larr[mid])
            {
                if (sarr[1] < larr[mid - 1])
                {
                    return larr[mid - 1];
                }
                else
                {
                    return sarr[1];
                }
            }
            else if (sarr[0] > larr[mid])
            {
                if (sarr[0] > larr[mid + 1])
                {
                    return larr[mid + 1];
                }
                else
                {
                    return sarr[0];
                }
            }
            else if (sarr[0] < larr[mid] && sarr[1] > larr[mid])
            {
                return larr[mid];
            }
            else if(sarr[0] == larr[mid] || sarr[1] == larr[mid])
            {
                return larr[mid];
            }
        }
        return -1;
    }
}