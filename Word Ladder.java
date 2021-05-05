class Solution {
    
    HashSet<String> set = new HashSet<>();
    Queue<String> Q = new LinkedList<>();
    int depth = 0;
    int retu = 0;
    
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {

      for(int i=0; i<wordList.size(); i++){
          set.add(wordList.get(i));
      }
      
      int lsize=0, L=beginWord.length();
      
      String word = beginWord;
      Q.add(word);
      
      while(!Q.isEmpty()){          
          lsize = Q.size();
          depth++;
          for(int foo=0; foo<lsize; foo++){
              bruteForceSearch(Q.poll(), endWord);
          }   
      }     

    return retu;
  }
    
        
        
    private void bruteForceSearch(String word, String endWord){
        
        for(int i=0; i<word.length(); i++){
            for(int j=0; j<26; j++){
                if(set.contains(generateSimilarWord(word, j, i))){
                    if(generateSimilarWord(word, j, i).equals(endWord))
                        retu = depth+1;
                    Q.add(generateSimilarWord(word, j, i));
                    set.remove(generateSimilarWord(word, j, i));
                }                  
            }
        }
    }
    
    private String generateSimilarWord(String word, int j, int i){
        String ret = "";
        int ch = j+97;
        if(i==0){
            ret = (char)ch + word.substring(1,word.length());
        }
        if(i!=0 && i!=word.length()-1){
            ret = word.substring(0,i) + (char)ch + word.substring(i+1,word.length());
        }
        if(i==word.length()-1){
            ret = word.substring(0,word.length()-1) + (char)ch;
        }
        //System.out.println(ret);
        return ret;
    }
}



