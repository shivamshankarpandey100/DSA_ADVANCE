//https://www.geeksforgeeks.org/problems/majority-element-1587115620/1

class Solution {
    static int majorityElement(int arr[]) {
        int cnt=0;
        int ele=-1;
        for(int a:arr){
            if(cnt==0){
                ele=a;
                cnt++;
            }else if(a==ele){
                cnt++;
            }else{
                cnt--;
            }
            
        }
        
        int count=0;
        for(int num: arr){
            if(num==ele){
                count++;
            }
        }
        if(count>arr.length/2) return ele;
        return -1;
        
    }
}