class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        long maxSum = 0;
        int i=0, j=0;
        HashSet<Integer> set = new HashSet<>();

        while(j<nums.length){
            int ch = nums[j];
            
            while(set.contains(ch) || j-i+1 > k){
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            set.add(ch);
            sum += ch;

            if(j-i+1 == k){
                maxSum = Math.max(maxSum, sum);
            }

            j++;
        }

        return maxSum;
    }
}