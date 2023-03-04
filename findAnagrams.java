class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(p.length()>s.length()) return ans;

        int len = p.length();
        Map<Character,Integer> S = buildMap(s.substring(0,len));
        Map<Character,Integer> P = buildMap(p);
        
        if(S.equals(P))   
            ans.add(0);

        for(int i=1; i<=s.length()-len; i++){
            S.put(s.charAt(i-1),S.get(s.charAt(i-1))-1);
            S.put(s.charAt(len+i-1),S.getOrDefault(s.charAt(len+i-1),0)+1);
            if(S.get(s.charAt(i-1))==0) 
                S.remove(s.charAt(i-1));
            
            if(S.equals(P))
                ans.add(i);
        }

        return ans;
    }

    private Map<Character,Integer> buildMap(String p){
        Map<Character,Integer> P = new HashMap<>();
        
        for(char ch:p.toCharArray()){
            P.put(ch,P.getOrDefault(ch,0)+1);
        }

        return P;
    }
}

/*
438. Find All Anagrams in a String

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/
