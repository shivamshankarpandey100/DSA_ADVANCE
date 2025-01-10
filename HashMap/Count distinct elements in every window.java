//https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1
class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        int i =0;
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer , Integer> hm = new HashMap<>();
        int n = arr.length;
        while(j<n){
            hm.put(arr[j], hm.getOrDefault(arr[j] ,0)+1);

            while(j-i+1 >k){
                hm.put(arr[i], hm.get(arr[i])-1);
                if(hm.get(arr[i]) ==0){
                    hm.remove(arr[i]);
                }
                i++;
            }
            if(j-i+1 ==k){
                ans.add(hm.size());
            }

            j++;
        }
        return ans;
    }
}