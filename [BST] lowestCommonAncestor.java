class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return aux(root, p, q);
    }
    private TreeNode aux(TreeNode root, TreeNode p, TreeNode q){
        int min = p.val<q.val?p.val:q.val;
        int max = p.val>q.val?p.val:q.val;

        if(root.val>=min && root.val<=max)
            return root;
        if(root.val>=min && root.val>=max)
            return aux(root.left, p, q);
        else
            return aux(root.right, p, q);
    }
}

/*
235. Lowest Common Ancestor of a Binary Search Tree

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the 
lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
*/
