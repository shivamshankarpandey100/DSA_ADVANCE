//https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1

class Solution {
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        // code here
        Deque<Integer> dq = new ArrayDeque<>();
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i =0; i < n; i++) {
            while(dq.size() != 0 && arr[dq.getLast()] < arr[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
            if(i - dq.getFirst() == k) dq.removeFirst();
            if(i >= k -1) {
                ans.add(arr[dq.getFirst()]);
            }
        }
        return ans;
    }
}

