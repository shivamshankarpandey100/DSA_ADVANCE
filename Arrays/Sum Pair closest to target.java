//https://www.geeksforgeeks.org/problems/pair-in-array-whose-sum-is-closest-to-x1124/1

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length-1;
        int minDiff =  Integer.MAX_VALUE;
        while(i < j){
            int sum = arr[i]+arr[j];
            int diff = Math.abs(target-sum);
            if(diff < minDiff){
            minDiff = diff;
            list = Arrays.asList(arr[i], arr[j]);
            }
            if(sum > target){
                j--;
            } else if(sum < target){
                i++;
            } else {
                return Arrays.asList(arr[i],arr[j]);
            }
        }
        return list;
    }
}