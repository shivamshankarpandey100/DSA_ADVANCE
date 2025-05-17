//https://www.geeksforgeeks.org/problems/sort-the-given-array-after-applying-the-given-equation0304/1


class Solution {
    // Function to apply quadratic transformation
    public static int evaluate(int x, int A, int B, int C) {
        return A * x * x + B * x + C;
    }

    // Function to transform and sort the array
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        int n = arr.length;
        int[] newArr = new int[n];

        int left = 0, right = n - 1;
        int index = (A >= 0) ? n - 1 : 0;

        // Two-pointer approach to fill newArr
        // from end or start
        while (left <= right) {
            int leftVal = evaluate(arr[left], A, B, C);
            int rightVal = evaluate(arr[right], A, B, C);

            if (A >= 0) {
                // Fill from end
                if (leftVal > rightVal) {
                    newArr[index--] = leftVal;
                    left++;
                } else {
                    newArr[index--] = rightVal;
                    right--;
                }
            } else {
                // Fill from start
                if (leftVal < rightVal) {
                    newArr[index++] = leftVal;
                    left++;
                } else {
                    newArr[index++] = rightVal;
                    right--;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int value : newArr) {
            result.add(value);
        }

        return result;
    }
}