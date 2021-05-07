class Solution {   
    int ans=-1;
    public int diameterOfBinaryTree(TreeNode root) 
    {    
        diameter(root);
        return ans; 
    }
    private int diameter(TreeNode root )
    {
        if(root == null ) return 0;
        int lh=diameter(root.left);
        int rh=diameter(root.right);
        ans=Math.max(ans,lh+rh);
        return 1+Math.max(lh,rh);
    }
}  
