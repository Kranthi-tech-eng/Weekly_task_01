import java.util.*;
public class Q2 {
    public static  boolean fun(HashMap<Character,Integer> hm1,HashMap<Character,Integer> hm2){
        for(char freq:hm2.keySet()){
            if(!hm1.containsKey(freq)){
                return false;
            }
            if(hm1.get(freq)<hm2.get(freq)){
                return false;
            }
        }
        return true;
    }
     public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s="ADOBECODEBANC";
        String t="ABC";
        HashMap<Character,Integer> hm2=new HashMap<>();
        HashMap<Character,Integer> hm1=new HashMap<>();
        for(int i=0;i<t.length();i++){
            hm2.put(t.charAt(i),hm2.getOrDefault(t.charAt(i),0)+1);
        }
        int l=0;
        int ans=Integer.MAX_VALUE;
        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            hm1.put(ch,hm1.getOrDefault(ch,0)+1);
            while(fun(hm1,hm2)){
                if(r-l+1 < ans){
                    ans=Math.min(r-l+1,ans);
                }
                char tch=s.charAt(l);
                hm1.put(tch,hm1.get(tch)-1);
                if(hm1.get(tch)==0){
                    hm1.remove(tch);
                }
                l++;
            }
        }
        System.out.print(ans);
     }
}
