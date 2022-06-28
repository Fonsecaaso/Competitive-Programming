class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        //convert 'pairs' list to hashmap structure - O(n) time and space
        HashMap<Integer,List<Integer>> pairsM = toHashMap(pairs, s.length());
        
        printGraph(pairsM);
        
        //discover disjoint sets - O(n*m) time | n=s.length() & m=pairs.size()
        List<List<Integer>> disjointSets = discoverDisjointSets(pairsM, s.length());
      
        printDisjointSets(disjointSets);
        
        //sort each substring related to each disjoint set - O(nlogn) time & O(n) space
        List<String> strings = new ArrayList<>();      
        Map<Integer,Character> map = new HashMap<>();
      
        for(List disjointSet:disjointSets){
            char[] substring = new char[disjointSet.size()];
            for(int index=0; index<disjointSet.size(); index++){
                substring[index] = s.charAt((int)disjointSet.get(index));
            }
            Arrays.sort(substring);
            Collections.sort(disjointSet);
            for(int index=0; index<disjointSet.size(); index++){
                map.put((Integer)disjointSet.get(index),substring[index]);
            }  
        }
        
        //create output string, merging each substring
        char[] output = new char[s.length()];
        for(int i=0; i<s.length(); i++){
            output[i] = map.get(i);
        }
       
        return new String(output);
    }
  
    private void printGraph(HashMap<Integer,List<Integer>> graph){
      System.out.println("Graph: ");
        for(Integer key:graph.keySet())
            System.out.println(key+": "+graph.get(key));
    }
  
    private void printDisjointSets(List<List<Integer>> disjointSets){
       System.out.println("Disjoint sets:");
        for(List set:disjointSets)
            System.out.println(set);
    }
  

    
    private  List<List<Integer>> discoverDisjointSets(HashMap<Integer,List<Integer>> map, int strLen){
        Set<Integer> visited = new HashSet<>();        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> queue = new ArrayList<>();
        
        for(int i=0; i<strLen; i++){ // O(n) n=strLen
            if(visited.contains(i))
                continue;
            
            Set<Integer> temp = new HashSet<>();
          
            visited.add(i);
            queue.add(i);
            
            while(!queue.isEmpty()){
                int target = queue.get(0); queue.remove(0);
                
                if(!temp.contains(target)) // O(1)
                    temp.add(target);              
                
                visited.add(target);
                
                if(map.containsKey(target)){
                    for(Integer el:map.get(target)){   //O(m) m=connections of one single node,related with pairs.size()
                        if(!visited.contains(el))
                            queue.add(el);
                    }
                }
                
            }
            
            list.add(temp);
        }
        
        return list;
    }
    
    //study to implement discoverDisjointSets method using the list of lists
    // but the version using hash map proved to be more effective and easier to implement
    private  List<List<Integer>> discoverDisjointSets(List<List<Integer>> pairs, int strLen){
        Set<Integer> visited = new HashSet<>();        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> queue = new ArrayList<>();
        
        for(int i=0; i<strLen; i++){
            if(!visited.contains(i))
                queue.add(i);
            else
                continue;
            
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            visited.add(i);
            
            while(!queue.isEmpty()){
                int target = queue.get(0); queue.remove(0);
                for(int j=0; j<pairs.size(); j++){
                    List<Integer> pair = pairs.get(j);
                    int val = (int)pair.get(0)!=target?(int)pair.get(0):(int)pair.get(1);
                    if(pair.contains(target) && !visited.contains(val)){     
                        pairs.remove(j);
                        queue.add(val);
                        visited.add(val);
                        temp.add(val);
                        j--;
                    }
                }
            }
            
            list.add(temp);
        }
        
        return list;
    }
    
    private HashMap<Integer,List<Integer>> toHashMap(List<List<Integer>> pairs, int len){
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(List pair:pairs){
            if(pair.get(0)!=pair.get(1)){
                if(!map.containsKey(pair.get(0))){
                    map.put((Integer)pair.get(0),new ArrayList(){{add(pair.get(1));}});
                }else{                
                    map.get((Integer)pair.get(0)).add((Integer)pair.get(1));
                }
                if(!map.containsKey(pair.get(1))){
                    map.put((Integer)pair.get(1),new ArrayList(){{add(pair.get(0));}});
                }else{                
                    map.get((Integer)pair.get(1)).add((Integer)pair.get(0));
                }
            }
        }        
        return map;
    }
}
