class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];   
        int index = 0;
        while(index<s1.length() && index<s2.length()){
            if(s1.charAt(index)==s2.charAt(index)) index++;
            else break;
        }
        return s1.substring(0,index);
    }
}
/*
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Input: strs = ["flower","flow","flight"]
Output: "fl"
*/
