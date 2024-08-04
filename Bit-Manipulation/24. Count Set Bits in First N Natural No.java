//https://www.geeksforgeeks.org/problems/count-total-set-bits-1587115620/1


//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n){
    
        if(n == 0){
        return 0;
    }

    int x = biggest2Kapower(n);
    int bitstill2x = x * (1 << (x - 1));
    int countofMSBfrom2xToN = n - (1 << x) + 1;
    int rob = countSetBits(n - (1 << x)); 

    return bitstill2x + countofMSBfrom2xToN + rob ;
  }

  public static int biggest2Kapower(int n){
    int x = 0;

    while((1 << x) <= n){
        x++;
    }

    return x - 1;
        
    }
}

//{ Driver Code Starts.

// Driver code
class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//testcases
		int x, n;
		while(t-->0) {
	        n = sc.nextInt();//input n

		    Solution obj = new Solution();

		    System.out.println(obj.countSetBits(n));//calling countSetBits() method
		}
	}
}

// } Driver Code Ends




//---------------------------------------------------------2nd----------------------------------------------------------------------------
import java.util.*;

class Main{

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(solution(n));


    scn.close();
  }

  public static int solution(int n){
    
    if(n == 0){
        return 0;
    }

    int x = biggest2Kapower(n);
    int bitstill2x = x * (1 << (x - 1));
    int countofMSBfrom2xToN = n - (1 << x) + 1;
    int rob = solution(n - (1 << x)); 

    return bitstill2x + countofMSBfrom2xToN + rob;
  }

  public static int biggest2Kapower(int n){
    int x = 0;

    while((1 << x) <= n){
        x++;
    }

    return x - 1;
  }

}