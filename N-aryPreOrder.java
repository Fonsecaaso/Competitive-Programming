//recursive
class Solution {
    List<Integer> ans;
    public List<Integer> preorder(Node root) {
        ans = new ArrayList<>();
        aux(root);
        return ans;
    }
    private void aux(Node node){
        if(node==null) return;
        ans.add(node.val);
        for(Node child:node.children)
            aux(child);
    }
}

//or
class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root==null) return ans;
        ans.add(root.val);
        for(Node child:root.children)
            preorder(child);
        return ans;
    }
}

//iterative
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--) {
                if (root.children.get(i) != null) stack.push(root.children.get(i));
            }
        }
        return res;
    }
}

/*
589. N-ary Tree Preorder Traversal

Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)
*/
