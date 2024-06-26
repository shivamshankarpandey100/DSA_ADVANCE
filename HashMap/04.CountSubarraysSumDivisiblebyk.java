//{ Driver Code Starts
//Initial Template for Java
//https://leetcode.com/problems/subarray-sums-divisible-by-k/submissions/1235521681/
//https://www.geeksforgeeks.org/problems/sub-array-sum-divisible-by-k2617/1


//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



class Solution
{
    long subCount(long arr[] ,int n,int k)
    {
        int ans=0;
        
        HashMap<Integer, Integer> map=new HashMap<>();
        int sum=0;
        int rem=0;
        
        map.put(0,1);
        
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            
            rem=sum%k;
            
            if(rem<0){
                rem=rem+k;
            }
            
            if(map.containsKey(rem)){
                ans=ans+map.get(rem);
                map.put(rem,map.get(rem)+1);
                
            }else{
                map.put(rem,1);
            }
        }
    
        
        return ans;
        
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
    //        int n=Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] a2 = line.trim().split("\\s+");
            int n =Integer.parseInt(a2[0]);
            int k =Integer.parseInt(a2[1]);
            //int y =Integer.parseInt(a2[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[]=new long[n];
            for(int i=0;i<n;i++)
            {
                a[i]=Long.parseLong(a1[i]);
            }
            Solution ob=new Solution();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans=ob.subCount(a,n,k);
            System.out.println(ans);
        }
    }
}






// } Driver Code Ends