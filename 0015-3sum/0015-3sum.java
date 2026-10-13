class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;    

        for(int i=0; i<n; i++){
            HashSet<Integer> seen = new HashSet<>();

            for(int j=i+1; j<n; j++){
                int third = -(nums[i]+nums[j]);

                if(seen.contains(third)){
                    List<Integer> list = Arrays.asList(
                        nums[i], nums[j], third
                    );
                    Collections.sort(list);

                    if(!set.contains(list)){
                        set.add(list);
                        ans.add(list);
                    }
                }    

                seen.add(nums[j]);
            }
        }

        return ans;
    }
}