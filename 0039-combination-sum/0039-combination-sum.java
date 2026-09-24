class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        find(candidates, target, new ArrayList<>(), 0, ans);
        return ans;
    }

    public void find(int[] arr, int tar, ArrayList<Integer> curr, int s, List<List<Integer>> ans){
        if(tar == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(tar < 0) return;

        for(int i=s; i<arr.length; i++){
            curr.add(arr[i]);
            find(arr, tar-arr[i], curr, i, ans);
            curr.remove(curr.size()-1);
        }
    }
}