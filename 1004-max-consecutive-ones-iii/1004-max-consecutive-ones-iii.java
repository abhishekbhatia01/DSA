class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0, j=0, z=0;
        int len = 0;

        while(j<nums.length){
            if(nums[j] == 0) z++;

            while(z > k){
                if(nums[i] == 0) z--;
                i++;
            }

            len = Math.max(len, j-i+1);

            j++;
        }

        return len;
    }
}