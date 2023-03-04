class Solution {
        
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;

        ans.add(Arrays.asList(root.val));

        List<List<TreeNode>> queue = new ArrayList<>();
        queue.add(Arrays.asList(root));

        while(!queue.isEmpty()){
            List<TreeNode> list = queue.get(0); queue.remove(0);
            if(list==null || list.size()==0) break;
            List<Integer> temp = new ArrayList<>();
            List<TreeNode> l = new ArrayList<>();

            for(TreeNode curr:list){
                if(curr.left!=null){
                    temp.add(curr.left.val);
                    l.add(curr.left);
                }
                if(curr.right!=null){
                    temp.add(curr.right.val);
                    l.add(curr.right);
                }
            }
            if(temp.size()>0) ans.add(temp);  
            queue.add(l);
        }

        return ans;
    }
}





/*
102. Binary Tree Level Order Traversal

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
Input: root = [3,9,20,1,2,15,7]
Output: [[3],[9,20],[1,2,15,7]]
*/
