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

 // Time Complexity = O(N)
 // Space Complexity = O(N)

class Solution {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length-1);
    }
    
    private TreeNode helper (int[] preorder, int[] inorder, int start, int end){
        if(start > end) return null;
        
        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        
        idx++;
        int rootIdx = map.get(rootVal);
        root.left = helper(preorder, inorder, start, rootIdx-1);
        
        root.right = helper(preorder, inorder, rootIdx+1, end);
        return root;
    }   
}