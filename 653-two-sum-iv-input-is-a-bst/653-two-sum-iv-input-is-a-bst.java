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
    public boolean search(TreeNode root, int k, TreeNode current){
        if(root==null)
            return false;
        if(root.val==k && root!=current)
            return true;
        if(k<root.val)
            return search(root.left, k, current);
        else
            return search(root.right, k, current);
    }
    
    public boolean traverse(TreeNode current, int k, TreeNode root){
        if(current==null)
            return false; 
        if(search(root, k-current.val, current))
            return true;
        return traverse(current.left, k, root)||traverse(current.right, k, root);
    }
    public boolean findTarget(TreeNode root, int k) {
        return traverse(root, k, root);
    }
}