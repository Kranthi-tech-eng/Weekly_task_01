import java.util.*;
public class Q9 {
    public static int solve(int ind,int[] coins,int amt,int[][] dp){
       if(ind==0){
    if(amt%coins[ind]==0){
        return amt/coins[ind];
    }
    return Integer.MAX_VALUE;
}
if(dp[ind][amt]!=-1){
    return dp[ind][amt];
}
        int npic=solve(ind-1,coins,amt,dp);
        int pic=Integer.MAX_VALUE;
        if(coins[ind]<=amt){
             pic=1+solve(ind,coins,amt-coins[ind],dp);
            
        }
        return dp[ind][amt]=Math.min(npic,pic);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int coins[]=new int[n];
        for(int i=0;i<n;i++){
            coins[i]=sc.nextInt();
        }
        int amt=sc.nextInt();
        int[][] dp=new int[n][amt+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int res=solve(n-1,coins,amt,dp);
        System.out.print(res);
    }
}
