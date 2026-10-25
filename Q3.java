import java.util.*;
class Q3 {
    public int[][] merge(int[][] inter) {
        Arrays.sort(inter,(a,b)->Integer.compare(a[0],b[0]));
        int[][] ans=new int[inter.length][2];
        int k=0;
        for(int i=0;i<inter.length-1;i++){
           int currend=inter[i][1];
           int nextst=inter[i+1][0];
        if(nextst<=currend){
            currend=Math.max(currend,inter[i+1][1]);
            inter[i+1][0]=inter[i][0];
            inter[i+1][1]=currend;
        }else{
            ans[k][0]=inter[i][0];
            ans[k][1]=inter[i][1];
            k++;
        }
        }
        ans[k][0]=inter[inter.length-1][0];
        ans[k][1]=inter[inter.length-1][1];
        k++;
        return Arrays.copyOf(ans,k);
    }
}