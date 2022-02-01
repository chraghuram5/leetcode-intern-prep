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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        boolean flag=false;
        List<Integer> temp=new ArrayList<Integer>();
        while(!q.isEmpty()){
            TreeNode t=q.remove();
            if(t==null){
                if(flag){
                    Collections.reverse(temp);
                    flag=false;
                }
                else
                    flag=true;
                list.add(temp);
                temp=new ArrayList<Integer>();
                if(q.peek()==null)
                    break;
                q.add(null);
            }
            else{
                if(t.left!=null)
                    q.add(t.left);
                if(t.right!=null)
                    q.add(t.right);
                temp.add(t.val);
            }
        }
        return list;
    }
}