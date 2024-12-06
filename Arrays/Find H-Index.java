//https://www.geeksforgeeks.org/problems/find-h-index--165609/1

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int Hcount = 0;
        while(Hcount < n && citations[n-1-Hcount]>Hcount){
            Hcount++;
        }
        return Hcount;
    }
    
}