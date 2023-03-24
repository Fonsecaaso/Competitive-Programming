//Bus Routes (Hard)

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        Map<Integer,List<Integer>> map1 = buildMap1(routes);
 
        Map<Integer,Set<Integer>> map2 = buildMap2(map1);

        for(int key:map1.keySet()) System.out.println(key+":"+map1.get(key));
        System.out.println();
        for(int key:map2.keySet()) System.out.println(key+":"+map2.get(key));

        List<Integer> sourceList = map1.get(source); 
        List<Integer> targetList = map1.get(target); 

        if(sourceList == null || targetList == null) return -1;

        int count = Integer.MAX_VALUE;

        for(int origin:sourceList){
            for(int destination:targetList){
                int result = BFS(origin,destination,map2);
                if(result != -1 && result<count) count = result;
            }
        }

        return count!=Integer.MAX_VALUE?count:-1;
    }

    private Map<Integer,List<Integer>> buildMap1(int[][] routes){
        Map<Integer,List<Integer>> map1 = new HashMap<>();

        for(int i=0; i<routes.length; i++){
            for(int j=0; j<routes[i].length; j++){
                List<Integer> temp = map1.getOrDefault(routes[i][j], new ArrayList<>());
                temp.add(i);
                map1.put(routes[i][j],temp);
            }
        }

        return map1;
    }

    private Map<Integer,Set<Integer>> buildMap2( Map<Integer,List<Integer>> map1){
        Map<Integer,Set<Integer>> map2 = new HashMap<>();

        for(int key:map1.keySet()){
            List<Integer> stops = map1.get(key);

            for(int stop:stops){
                Set<Integer> set = map2.getOrDefault(stop, new HashSet<>());
                set.addAll(stops);
                set.remove(stop);
                map2.put(stop,set);        
            }    
        }

        return map2;
    }

    public int BFS(int origin, int destination, Map<Integer,Set<Integer>> map2){
        int depth = 1;
        
        if(origin==destination) return 1;

        List<Integer> toVisit = new ArrayList<>(map2.get(origin));
        Set<Integer> visited = new HashSet<>(origin);

        while(!toVisit.isEmpty()){
            depth++;
            List<Integer> temp = new ArrayList<>();
            while(!toVisit.isEmpty()){
                int curr = toVisit.get(0); toVisit.remove(0);
                if(visited.contains(curr)) continue;
                visited.add(curr);
                if(curr == destination) return depth;
                temp.addAll(map2.get(curr));
            }
            toVisit.addAll(temp);
            
        }

        return -1;
    }
}
