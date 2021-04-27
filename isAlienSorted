class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> m = new HashMap<>();
        
        for(int i=0; i<order.length(); i++)
            m.put(order.charAt(i), i);
                
        for(int i=0; i< words.length-1; i++){
            int j=0;
            while(true){
                if(j==words[i].length())
                    break;
                if(j==words[i+1].length())
                    return false;
                if(m.get(words[i].charAt(j))>m.get(words[i+1].charAt(j)))
                    return false;
                if(m.get(words[i].charAt(j))<m.get(words[i+1].charAt(j)))
                    break;
                j++;
            }
        }
       
        
        return true;
    }
}



        
