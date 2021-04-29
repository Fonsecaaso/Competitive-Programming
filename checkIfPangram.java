/*
A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
*/

class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length()<26) return false;
        
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<='z'-'a';i++){
            int a = i + 97;
            set.add((char)a);
        }
        for (char ch: sentence.toCharArray()) {
            if(set.isEmpty()) return true;
            set.remove(ch);
        }
        if(set.isEmpty()) return true;
        return false;
    }
}
