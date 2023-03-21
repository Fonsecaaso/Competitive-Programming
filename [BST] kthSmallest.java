// Kth Smallest Element in a BST

class Solution {
    List<Integer> array;
    public int kthSmallest(TreeNode root, int k) {
        array = new ArrayList<>();
        inOrder(root);
        return array.get(k-1);
    }

    private void inOrder(TreeNode node){
        if(node==null) return;
        inOrder(node.left);
        array.add(node.val);
        inOrder(node.right);
    }
}
