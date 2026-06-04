class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character>lower = new HashSet<>();
        HashSet<Character>upper = new HashSet<>();
        int ans=0;
        for(char ch : word.toCharArray()){
            if(Character.isLowerCase(ch)){
                lower.add(ch);
            }else{
                upper.add(ch);
            }
        }
        for(char ch : lower){
            if(upper.contains(Character.toUpperCase(ch))){
                ans++;
            }
        }
        return ans;
    }
}