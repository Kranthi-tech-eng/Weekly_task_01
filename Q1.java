import java.util.*;
class Q1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        int l=0;
        int sum=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int ans=Integer.MIN_VALUE;
        for(int r=0;r<n;r++){
            sum+=arr[r];
            while(sum>k){
                sum-=arr[l];
                l++;
            }
            if(hm.containsKey(sum-k)){
                ans=Math.max(r-l+1,ans);
            }
            hm.put(sum-k,hm.getOrDefault(sum-k,0)+1);
        }
        System.out.print("Length of the longest subarray equals to k is "+ans);
    }
}