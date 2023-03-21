//  Convert Sorted Array to Binary Search Tree

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = build(nums, 0, nums.length-1);        
        return root;        
    }

    private TreeNode build(int[] nums, int min, int max){
        if(min>max) return null;

        TreeNode node = new TreeNode();
        int index = (max+min)/2;
        node.val = nums[index];
        node.left = build(nums, min, index-1);
        node.right = build(nums, index+1, max);

        return node;
    }
}
