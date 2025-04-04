//https://www.geeksforgeeks.org/problems/union-of-two-arrays3538/1

class Solution {
    public static int findUnion(int a[], int b[]) {
        // code here
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<a.length;i++){
            hs.add(a[i]);
        }
        
        for(int i=0;i<b.length;i++){
            if(!hs.contains(b[i])){
                hs.add(b[i]);
            }
        }
        
        return hs.size();
    }
}