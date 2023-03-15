class Solution {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root){
        if(root==null) return;

        if(root.right==null){
            root.right=root.left;
            root.left=null;
            invert(root.right);
        }

        else if(root.left==null){
            root.left=root.right;
            root.right=null;
            invert(root.left);
        }

        else{
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            invert(root.left);
            invert(root.right);
        }
    }
}


/*
226. Invert Binary Tree

Given the root of a binary tree, invert the tree, and return its root.
*/
