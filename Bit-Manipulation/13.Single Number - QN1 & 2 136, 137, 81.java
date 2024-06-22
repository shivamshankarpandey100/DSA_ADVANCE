
//  https://leetcode.com/problems/single-number/description/


class Solution {
    public int singleNumber(int[] nums) {
    int tn = -1;
    int tn1 = 0;

    for(int val : nums){
        int csbwtn = tn & val;     // csbwtn = common set bit b/t tn
        int csbwtn1 = tn1 & val;

        tn = tn & ~csbwtn;
        tn1 = tn1 | csbwtn;

        tn1 = tn1 & ~csbwtn1;
        tn = tn | csbwtn1;
    }

    return tn1;
    }
}