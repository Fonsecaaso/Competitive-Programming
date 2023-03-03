class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();

        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int count = 0, odd = 0;

        for(char ch:map.keySet()){
            count += 2*(map.get(ch)/2);
            if(map.get(ch)%2==1) odd=1;
        }

        return count + odd;
    }
}

/*
409. Longest Palindrome

Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 
*/
