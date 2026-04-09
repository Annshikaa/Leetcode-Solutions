class Solution {
    public boolean judgeCircle(String moves) {
        int curr=0;
        int curr2=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='U') curr+=1;
            if(moves.charAt(i)=='D') curr-=1;
            if(moves.charAt(i)=='R') curr2+=1;
            if(moves.charAt(i)=='L') curr2-=1;
        }
        return curr==0 && curr2==0;
    }
}