/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> curr = new ArrayList<>();

            int size = q.size();

            for(int i=0; i<size; i++){
                TreeNode front = q.poll();
                curr.add(front.val);

                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
            }
            ans.add(curr);
        }

        return ans;

    }   
}