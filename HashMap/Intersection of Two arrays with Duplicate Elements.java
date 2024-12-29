//https://www.geeksforgeeks.org/problems/intersection-of-two-arrays-with-duplicate-elements/1

class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        HashSet<Integer> arr =new HashSet<Integer>();
        HashSet<Integer> set= new HashSet<>();
        ArrayList<Integer> ans =new ArrayList<Integer>();
        for(int i=0;i<a.length;i++){
            set.add(a[i]);
            
        }
        for(int i=0;i<b.length;i++){
            if(set.contains(b[i])){
                arr.add(b[i]);
            }
        }
        ans.addAll(arr);
        return  ans;
    }
}