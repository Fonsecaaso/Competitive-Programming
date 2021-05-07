class Solution {
    
    int diameter = 0;
    
    private Pair<Integer, Integer> calculate(TreeNode root){
                
        if(root.left == null && root.right == null)        
            return new Pair(0,0);
     
        Pair<Integer, Integer> pairLeft = new Pair(Integer.MIN_VALUE,Integer.MIN_VALUE);
        Pair<Integer, Integer> pairRight = new Pair(Integer.MIN_VALUE,Integer.MIN_VALUE);
            
            
        if(root.left!=null)                                                 
            pairLeft = calculate(root.left); 
        if(root.right!=null)                                                
            pairRight = calculate(root.right);        
        
        
        int first=2, second = Math.max(pairLeft.getValue(), pairRight.getValue()) + 1;
        
        first += pairLeft.getValue()+pairRight.getValue();
        
        if(first>diameter || second>diameter)                               
            diameter=Math.max(first,second);
            
        return new Pair(first,second);       
        
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        calculate(root);            
        return diameter;
    }
}
