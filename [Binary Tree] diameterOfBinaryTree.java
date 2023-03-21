//Diameter of Binary Tree

class Solution {
    private int maxDiameter;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        aux(root);
        return maxDiameter;
    }

    private int aux(TreeNode node){
        if(node==null) return 0;

        int left = aux(node.left);
        int right = aux(node.right);
        int diameter = left+right;

        if(diameter>maxDiameter) maxDiameter = diameter;

        return Math.max(left,right)+1;

    }
}
