class Solution {
    public String multiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();

        int[] ans = new int[l1 + l2];

        for(int i=l1-1; i>=0; i--){
            for(int j=l2-1; j>=0; j--){
                int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                mul += ans[i+j+1];

                ans[i+j] += mul/10;
                ans[i+j+1] = mul%10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int p:ans) if(!(sb.length() == 0 && p == 0)) sb.append(p);

        return sb.length()==0?"0":new String(sb);
    }
}


            //     1 1 1
            //     1 1 1

            //     1 1 1
            //   1 1 1
            // 1 1 1

            // 1 2 3 2 1   

/*
43. Multiply Strings

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

 

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
*/
