//{ Driver Code Starts
//Initial Template for Java
//https://www.geeksforgeeks.org/problems/equal-0-1-and-23208/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        long ans=0;
        // code here
        int c0=0, c1=0, c2=0;
        
        String key="0#0";
        HashMap<String, Integer> map=new HashMap<>();
        
        map.put(key,1);
        
        for(int i=0;i<str.length();i++){
            
            char ch=str.charAt(i);
            
            if(ch=='0'){
                c0++;
            }
            else if(ch =='1'){
                c1++;
            }else{
                c2++;
            }
            key=(c1-c0)+"#"+(c2-c1);
            
            if(map.containsKey(key)){
                int val=map.get(key);
                ans+=val;
                map.put(key,+val+1);
            }else{
                map.put(key,1);
            }
        }
        
        return ans;
    }
} 