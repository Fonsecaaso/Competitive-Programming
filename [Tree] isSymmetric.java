// Symmetric Tree

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root.right==null || root.left==null) 
            return root.left==root.right;

        return helper(root.left,root.right);
    }    
    boolean helper(TreeNode p, TreeNode q){
        if(p==null || q==null) 
            return p==q;

        if(p.val!=q.val) return false;

        return helper(p.left,q.right) && helper(p.right,q.left);
    }
}
