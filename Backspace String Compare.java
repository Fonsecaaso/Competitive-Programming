class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> S = new Stack<>();
        Stack<Character> T = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='#' && S.size()>0)
                S.pop();
            else if(s.charAt(i)!='#')
                S.push(s.charAt(i));
        }        
        
        for(int i=0; i<t.length(); i++){
            if(t.charAt(i)=='#' && T.size()>0)
                T.pop();
            else if(t.charAt(i)!='#')
                T.push(t.charAt(i));
        } 
       
        return S.toString().equals(T.toString());
    }
}
