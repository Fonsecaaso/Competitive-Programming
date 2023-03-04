//iterative optimazed O(n) O(1)
class Solution {
    public int fib(int n) {
        if(n<2) return n;
        int t1 = 1, t2 = 1, temp;

        for(int i=2; i<n; i++){
            temp = t2;
            t2 += t1;
            t1 = temp;
        }

        return t2;
    }
}

//iterative DP O(n) O(n)
class Solution {
    public int fib(int n) {
        if(n<2) return n;
        int arr[] = new int[n];
        arr[0] = 1;
        arr[1] = 1;

        for(int i=2; i<n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n-1];
    }
}

//recursive with memoization O(n) O(n)
class Solution {
    int[] memo;
    public int fib(int n) {
        if(n<2) return n;
        memo = new int[n];
        return aux(n-1);
    }

    private int aux(int n){
        if(n==1 || n==0) return 1;
        if(memo[n]!=0) return memo[n];
        memo[n] = aux(n-1) + aux(n-2);

        return memo[n];
    }
}

//recursive O(n²) O(n)
class Solution {
    public int fib(int n) {
        if(n<2) return n;
        
        return aux(n-1);
    }

    private int aux(int n){
        if(n==1 || n==0) return 1;

        return aux(n-1) + aux(n-2);
    }
}
