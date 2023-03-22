//994. Rotting Oranges

class Solution {
    public int orangesRotting(int[][] grid) {

        // 1. build rottenGraph and healthyGraph
        Map<List<Integer>,List<List<Integer>>> rotten = new HashMap<>();
        Map<List<Integer>,List<List<Integer>>> healthy = new HashMap<>();

        int m = grid.length, n = grid[0].length; 

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    List<List<Integer>> list = new ArrayList<>();
                    if(i>0) list.add(Arrays.asList(i-1,j));
                    if(j>0) list.add(Arrays.asList(i,j-1));
                    if(i!=m-1) list.add(Arrays.asList(i+1,j));
                    if(j!=n-1) list.add(Arrays.asList(i,j+1));
                    rotten.put(Arrays.asList(i,j), list);
                }
                
                if(grid[i][j]==1){
                    List<List<Integer>> list = new ArrayList<>();
                    if(i>0) list.add(Arrays.asList(i-1,j));
                    if(j>0) list.add(Arrays.asList(i,j-1));
                    if(i!=m-1) list.add(Arrays.asList(i+1,j));
                    if(j!=n-1) list.add(Arrays.asList(i,j+1));
                    healthy.put(Arrays.asList(i,j), list);
                }
            }
        }

        if(healthy.size()==0) return 0;

        //2. create counter var, each orange that is in rottenGraph becomes rotten, for each round increase counter
        int count = 0;
        List<List<Integer>> willRot = new ArrayList<>();
        for(List<Integer> key:rotten.keySet())
            willRot.addAll(rotten.get(key));

        while(willRot.size() >= 1){
            count++;
            List<List<Integer>> temp = new ArrayList<>();
            for(List<Integer> orange:willRot){
                if(rotten.containsKey(orange)) continue;
                List<List<Integer>> healthyList = healthy.get(orange);
                rotten.put(orange,healthyList);
                if(healthyList!=null)
                    temp.addAll(healthyList);
                healthy.remove(orange);
            }
            willRot = new ArrayList<>();
            willRot.addAll(temp);
        }

        //3. if any orang leaf healthy reaturn -1, else return counter 
        if(healthy.isEmpty()) return count-1;
        else return -1;
    }
}
