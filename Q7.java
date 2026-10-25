import java.util.*;
public class Q7 {
    public static void main(String[] args) {
        int mat[][]={{1,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,1,1}};
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,1});
        int  dist[][]=new int[mat.length][mat.length];
        for(int i=0;i<mat.length;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
        dist[0][0]=1;
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int row=curr[0];
            int col=curr[1];
            int currcost=curr[2];
            for(int d[]:dir){
                int nr=row+d[0];
                int nc=col+d[1];
                if(nr>=0 && nc>=0 && nr<mat.length && nc<mat.length && mat[nr][nc]==1){
                    if(currcost+1<dist[nr][nc]){
                        dist[nr][nc]=currcost+1;
                        pq.add(new int[]{nr,nc,currcost+1});
                    }
                }
            }
        }
        System.out.print(dist[mat.length-1][mat.length-1]);
    }
}
