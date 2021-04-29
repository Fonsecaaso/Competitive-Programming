class Solution {
    public int firstMissingPositive(int[] arr) {
        int max = 0;
        HashSet<Integer> s0 = new HashSet<>();
        
        for(int i=0; i<arr.length; i++){
          s0.add(arr[i]);
          max = Math.max(max,arr[i]); 
        }

        HashSet<Integer> s = new HashSet<>();

        for(int i=1; i<=max; i++){
          if(!s0.contains(i)) return i;
          s.add(i);
        }

        for(int i=0; i<arr.length; i++){
          s.remove(arr[i]);
        }

        if(s.isEmpty()) return max+1;

        for(int i=0; i<arr.length; i++){
          if(s.contains(i)){
              return i;
          }
        }
        
        return arr.length;
    }
}
