//Generate Parentheses

class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        f(n, "",0,0);

        return ans;
    }

    private void f(int n, String str, int open, int close){
        if(str.length()==n*2){
            ans.add(str);
            return;
        }
        
        if(close<open)
            f(n, str+")",open,close+1);
        if(open<n)
            f(n, str+"(",open+1,close);
    }
}

/*
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
*/
