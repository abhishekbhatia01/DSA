class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        solve(nums, ans, new boolean[nums.length], new ArrayList<>());

        return ans;
    }

        public void solve(int[] nums, List<List<Integer>> ans, boolean[] vis, ArrayList<Integer> curr){
            if(curr.size() == nums.length){
                ans.add(new ArrayList<>(curr));
                return;
            }

            for(int i=0; i<nums.length; i++){
                if(vis[i]) continue;

                if(i>0 && nums[i] == nums[i-1] && !vis[i-1]) continue;

                vis[i] = true;
                curr.add(nums[i]);
                solve(nums, ans, vis, curr);

                curr.remove(curr.size()-1);
                vis[i] = false;
            }
        }

}