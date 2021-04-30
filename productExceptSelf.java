class Solution {
    public int[] productExceptSelf(int[] arr) {
        int[] r2l = new int[arr.length];  
        Arrays.fill(r2l, 1);
        int aux = 1;

        for(int i=arr.length-2; i>=0; i--){
          r2l[i] = arr[i+1]*r2l[i+1];
        }

        aux = 1;

        for(int i=1; i<=arr.length-1; i++){
          aux = aux*arr[i-1];
          r2l[i] = r2l[i]*aux;
        }  

        return r2l;
    }
}

//leetcode.com/problems/product-of-array-except-self
