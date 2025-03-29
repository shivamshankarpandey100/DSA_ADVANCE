//https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int[] sorted = new int[profit.length];
        boolean[] job = new boolean[profit.length];

        // Copy and sort profits in descending order
        System.arraycopy(profit, 0, sorted, 0, profit.length);
        Arrays.sort(sorted);
        reverseArray(sorted);

        int[] maxProfit = {0};
        int jobs = 0;

        for (int i = 0; i < profit.length; i++) {
            int curr = sorted[i];
            int index = findJob(profit, curr);
            jobs += DoneOrNot(deadline[index], job, maxProfit, curr);
        }

        result.add(jobs);
        result.add(maxProfit[0]);
        return result;
    }

    public static int DoneOrNot(int d, boolean[] j, int[] m, int c) {
        while (d > 0) {
            if (!j[d - 1]) { // If job slot is available
                m[0] += c;
                j[d - 1] = true;
                return 1;
            }
            d--; // Try earlier deadline slots
        }
        return 0;
    }

    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            // Swap elements
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static int findJob(int[] profit, int n) {
        int ind = 0;
        for (int i = 0; i < profit.length; i++) {
            if (profit[i] == n) {
                ind = i;
                profit[i] = 0; // Mark job as taken
                break;
            }
        }
        return ind;
    }
}

