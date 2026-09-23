class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        solve(ans, nums, new boolean[nums.length], new ArrayList<>());

        return ans;

    }

    public void solve(List<List<Integer>> ans, int[] nums, boolean[] vis, ArrayList<Integer> curr){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));

            return;
        }

        for(int i=0; i<nums.length; i++){
            if(vis[i]) continue;

            vis[i] = true;
            curr.add(nums[i]);
            solve(ans, nums, vis, curr);

            curr.remove(curr.size()-1);
            vis[i] = false;
        }
    }
}