class Solution {
    public int rotatedDigits(int n) {
        int div=(int)Math.floor((Math.log(n)/Math.log(10)));
        int dp[][][]=new int[5][2][2];
        for(int i[][]:dp) for(int[] j:i) Arrays.fill(j,-1);
        return compute(n,div,1,0,dp);
    }
    public int compute(int n,int div,int isTight,int isValid,int[][][] dp){
        if(div==-1) return (isValid==1)?1:0;
        int ans=0;
        int digit=(n/(int)Math.pow(10,div))%10;
        if(dp[div][isTight][isValid]!=-1) return dp[div][isTight][isValid];
        if(isTight==1){
            for(int i=0;i<=digit;i++){
                if(i==digit){
                    if(i==0||i==1||i==8){
                        ans+=compute(n,div-1,isTight,isValid,dp);
                    }else if(i==2||i==5||i==6||i==9){
                        ans+=compute(n,div-1,isTight,1,dp);
                    }
                }else{
                    if(i==0||i==1||i==8){
                        ans+=compute(n,div-1,0,isValid,dp);
                    }else if(i==2||i==5||i==6||i==9){
                        ans+=compute(n,div-1,0,1,dp);
                    }
                }
            }
        }else{
            for(int i=0;i<=9;i++){
                if(i==0||i==1||i==8){
                    ans+=compute(n,div-1,0,isValid,dp);
                }else if(i==2||i==5||i==6||i==9){
                    ans+=compute(n,div-1,0,1,dp);
                }
            }
        }
        return dp[div][isTight][isValid]=ans;
    }
}