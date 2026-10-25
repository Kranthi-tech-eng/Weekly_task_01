import java.util.*;
public class Q4 {
   public static void main(String[] args) {
       int[] arr={3,2,5,9,7,6};
      PriorityQueue<Integer> pq=new PriorityQueue<>();
      int k=3;
      ArrayList<Integer> res=new ArrayList<>();
      for(int i=0;i<arr.length;i++){
        pq.add(arr[i]);
        while(pq.size()>k){
            pq.poll();
        }
        if(pq.size()==k){
            res.add(pq.peek());
        }
      }
      System.out.print(res);

   }
}
