// 2405. Optimal Partition of String

class Solution {
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int count=0;

        for(char ch:s.toCharArray()){
            if(set.contains(ch)){
                count++;
                set.clear();
            }
            set.add(ch);
        }

        return count+1;
    }
}
