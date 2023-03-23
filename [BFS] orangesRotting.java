//994. Rotting Oranges
class Solution {
    public int orangesRotting(int[][] grid) {
        int seconds = 0;
		int lengthY = grid.length;
		int lengthX = grid[0].length;
		List<List<Integer>> toRot = new ArrayList<>();
		boolean anyFresh;
		do {
			anyFresh = false;
			toRot = new ArrayList<>();
			for (int y = 0; y < lengthY; y++) {
				for(int x = 0; x < lengthX; x++) {
					if (grid[y][x] == 2) 
						rotSurroundingOranges(grid, x, y, lengthX, lengthY, toRot);
					else if (grid[y][x] == 1) 
						anyFresh = true;
				}
			}
			// Rot oranges
			for (List<Integer> rot: toRot) 
				grid[rot.get(0)][rot.get(1)] = 2;

			if (!toRot.isEmpty()) 
				seconds++;
			
		} while (!toRot.isEmpty());

		return anyFresh ? -1 : seconds;
    }

	private static void rotSurroundingOranges(int[][] grid, int x, int y, int lengthX, int lengthY, List<List<Integer>> toRot) {
		// to left
		if (x > 0 && grid[y][x-1] == 1) 
            toRot.add(Arrays.asList(y, x-1));
		// to right
		if (x < lengthX-1 && grid[y][x+1] == 1) 
            toRot.add(Arrays.asList(y, x+1));		
		// above
		if (y > 0 && grid[y-1][x] == 1) 
            toRot.add(Arrays.asList(y-1, x));
		// below
		if (y < lengthY-1 && grid[y+1][x] == 1) 
            toRot.add(Arrays.asList(y+1, x));	
	}
}

// class Solution {
//     public int orangesRotting(int[][] grid) {

//         // 1. build rottenGraph and healthyGraph
//         Map<List<Integer>,List<List<Integer>>> rotten = new HashMap<>();
//         Map<List<Integer>,List<List<Integer>>> healthy = new HashMap<>();

//         int m = grid.length, n = grid[0].length; 

//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 if(grid[i][j]==2){
//                     List<List<Integer>> list = new ArrayList<>();
//                     if(i>0) list.add(Arrays.asList(i-1,j));
//                     if(j>0) list.add(Arrays.asList(i,j-1));
//                     if(i!=m-1) list.add(Arrays.asList(i+1,j));
//                     if(j!=n-1) list.add(Arrays.asList(i,j+1));
//                     rotten.put(Arrays.asList(i,j), list);
//                 }
                
//                 if(grid[i][j]==1){
//                     List<List<Integer>> list = new ArrayList<>();
//                     if(i>0) list.add(Arrays.asList(i-1,j));
//                     if(j>0) list.add(Arrays.asList(i,j-1));
//                     if(i!=m-1) list.add(Arrays.asList(i+1,j));
//                     if(j!=n-1) list.add(Arrays.asList(i,j+1));
//                     healthy.put(Arrays.asList(i,j), list);
//                 }
//             }
//         }

//         if(healthy.size()==0) return 0;

//         //2. create counter var, each orange that is in rottenGraph becomes rotten, for each round increase counter
//         int count = 0;
//         List<List<Integer>> willRot = new ArrayList<>();
//         for(List<Integer> key:rotten.keySet())
//             willRot.addAll(rotten.get(key));

//         while(willRot.size() >= 1){
//             count++;
//             List<List<Integer>> temp = new ArrayList<>();
//             for(List<Integer> orange:willRot){
//                 if(rotten.containsKey(orange)) continue;
//                 List<List<Integer>> healthyList = healthy.get(orange);
//                 rotten.put(orange,healthyList);
//                 if(healthyList!=null)
//                     temp.addAll(healthyList);
//                 healthy.remove(orange);
//             }
//             willRot = new ArrayList<>();
//             willRot.addAll(temp);
//         }

//         //3. if any orang leaf healthy reaturn -1, else return counter 
//         if(healthy.isEmpty()) return count-1;
//         else return -1;
//     }
// }
