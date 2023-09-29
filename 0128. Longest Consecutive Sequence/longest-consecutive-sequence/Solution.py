# submitted on May 16, 2020
class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        if len(nums) == 0:
            return 0

        dict = {}
        for elem in nums:
            dict[elem] = True

        dict2 = {}
        for key in dict:
            if key - 1 in dict:
                dict2[key - 1] = key

        if len(dict2.keys()) == 0:
            return 1

        longestArrAtKey = dict2.keys()[0]
        dict3 = {k: 1 for k in dict.keys()}
        for key in dict2:
            theNextVal = dict2[key]
            while theNextVal in dict2:
                dict3[key] += 1
                theNextVal += 1
            if theNextVal - 1 in dict2:
                dict3[key] += 1
            # find largest arr key
            if dict3[key] > dict3[longestArrAtKey]:
                longestArrAtKey = key

        return dict3[longestArrAtKey]
