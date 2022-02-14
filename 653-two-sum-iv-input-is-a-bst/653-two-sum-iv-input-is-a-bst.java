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
    public boolean find(TreeNode root, int k, HashMap<Integer, HashSet<TreeNode>> map){
        if(root==null)
            return false;
        if(map.containsKey(k-root.val)){
            HashSet<TreeNode> set=map.get(k-root.val);
            if(!set.contains(root))
                return true;
        }
        if(map.get(root.val)==null){
            HashSet<TreeNode> set=new HashSet<TreeNode>();
            set.add(root);
            map.put(root.val, set);
        }
        else{
            HashSet<TreeNode> set=map.get(root.val);
            set.add(root);
            map.put(root.val, set);
        }
        return find(root.left, k, map)||find(root.right, k, map);
    }
    
    public boolean findTarget(TreeNode root, int k) {
        HashMap<Integer, HashSet<TreeNode>> map=new HashMap<Integer, HashSet<TreeNode>>();
        return find(root, k, map);
    }
}