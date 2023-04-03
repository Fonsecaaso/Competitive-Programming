// Boats to Save People

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0, start = 0;
        for(int i=people.length-1; i>=0 && i>=start; i--){
            if(people[i]>=limit){
                count++;
                continue;
            }
            if(people[i]+people[start]<=limit)
                start++;
            count++;
        }

        return count;
    }
}
