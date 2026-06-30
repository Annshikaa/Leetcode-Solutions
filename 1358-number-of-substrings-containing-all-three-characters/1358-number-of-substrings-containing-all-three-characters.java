class Solution {
    public int numberOfSubstrings(String s) {
        int len = s.length();
        int [] arr = new int[3];
        int left = 0;
        int count = 0;

        for(int right = 0;right<s.length();right++){
            int ch = s.charAt(right) - 'a';
            arr[ch]++;

            while(arr[0] != 0 && arr[1] != 0 && arr[2] != 0){
               count += len - right;
               arr[s.charAt(left) - 'a']--;
               left++;
                 }

        }
        return count;
    }
}