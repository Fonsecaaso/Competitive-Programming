// Letter Combinations of a Phone Number

class Solution {
    List<String> ans;
    HashMap<Character, List<String>> map;

    private HashMap<Character, List<String>> buildMap(){
        return new HashMap<>(){{
           put('1', new ArrayList<String>(Arrays.asList(""))); 
           put('2', new ArrayList<String>(Arrays.asList("a","b","c"))); 
           put('3', new ArrayList<String>(Arrays.asList("d","e","f"))); 
           put('4', new ArrayList<String>(Arrays.asList("g","h","i"))); 
           put('5', new ArrayList<String>(Arrays.asList("j","k","l"))); 
           put('6', new ArrayList<String>(Arrays.asList("m","n","o"))); 
           put('7', new ArrayList<String>(Arrays.asList("p","q","r","s"))); 
           put('8', new ArrayList<String>(Arrays.asList("t","u","v"))); 
           put('9', new ArrayList<String>(Arrays.asList("w","x","y","z"))); 
           put('0', new ArrayList<String>(Arrays.asList(" "))); 
        }};
    }

    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        map = buildMap();
        if(digits.length()==0) return ans;
        
        helper(digits,0,"");
        
        return ans;
    }

    void helper(String digits, int index, String str){
        if(index == digits.length()){
            ans.add(str);
            return;
        }
        
        for(String possibility:map.get(digits.charAt(index))){
            str = str+possibility;
            helper(digits,index+1,str);
            str = str.substring(0,str.length()-1);
        }
    }
}
