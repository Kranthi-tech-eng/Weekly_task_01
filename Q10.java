class Solution {
    class SegmentTree{
        int[] tree;
        int n;
        SegmentTree(int[] arr){
            n=arr.length;
            tree=new int[4*n];
            build(arr,0,0,n-1);
        }
        public void build(int[] arr,int node,int start,int end){
            if(start==end){
                tree[node]=arr[start];
                return;
            }
            int mid=(start+end)/2;
            build(arr,node*2+1,start,mid);
            build(arr,node*2+2,mid+1,end);
            tree[node]=gcd(tree[2 * node + 1] , tree[2 * node + 2]);
        }
        public int gcd(int a, int b) {
                   while(b != 0) {
                       int temp = a % b;
                       a = b;
                       b = temp;
                   }
                   return a;
               }
        public void update(int node,int start,int end,int index,int value){
            if(start==end){
                tree[node]=value;
                return;
            }
            int mid=(start+end)/2;
            if(index<=mid){
                update(2*node+1,start,mid,index,value);
            }else{
                update(2*node+2,mid+1,end,index,value);
            }
            tree[node]=gcd(tree[2 * node + 1] , tree[2 * node + 2]);
        }
       public int query(int node, int start, int end, int l, int r) {
                if(r < start || end < l) {
                    return 0;
                }
                if(l <= start && end <= r) {
                    return tree[node];
                }
                int mid = (start + end) / 2;

                int left = query(2 * node + 1, start, mid, l, r);
                int right = query(2 * node + 2, mid + 1, end, l, r);

                return gcd(left, right);
            }
    }
    public ArrayList<Integer> processQueries(int[] arr, int[][] queries) {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        SegmentTree st=new SegmentTree(arr);
        for(int[] q:queries){
            int t=q[0];
            int l=q[1];
            int r=q[2];
            if(t==1){
                st.update(0,0,arr.length-1,l,r);
            }else{
                res.add(st.query(0,0,arr.length-1,l,r));
            }
        }
        return res;
    }
}