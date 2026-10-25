import java.util.*;
class Q8 {
    public boolean canFinish(int nc, int[][] pre) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        for(int i=0;i<nc;i++){
            arr.add(new ArrayList<>());
        }
        int ind[]=new int[nc];
        for(int i=0;i<pre.length;i++){
            int u=pre[i][0];
            int v=pre[i][1];
            ind[v]++;
            arr.get(u).add(v);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<nc;i++){
            if(ind[i]==0){
                q.add(i);
            }
        }
        int k=0;
        while(!q.isEmpty()){
            k++;
            int curr=q.poll();
            for(int nei:arr.get(curr)){
                ind[nei]--;
                if(ind[nei]==0){
                    q.add(nei);
                }
            } 
        }
        if(k!=nc){
            return false;
        }
        return true;
    }
}