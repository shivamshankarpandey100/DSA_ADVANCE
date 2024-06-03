



class Main {
    public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target, int n) {

        HashSet<ArrayList<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])) {
                        int left = j + 1;
                        int right = nums.length - 1;

                        while (left < right) {
                            int sum = nums[i] + nums[j] + nums[left] + nums[right];
                            if (sum == target) {
                                ArrayList<Integer> tmp = new ArrayList<>();
                                tmp.add(nums[i]);
                                tmp.add(nums[j]);
                                tmp.add(nums[left]);
                                tmp.add(nums[right]);
                                set.add(tmp);

                                while(left < right && nums[left] == nums[left + 1]) left++;
                                while(left < right && nums[right] == nums[right - 1]) right --;
                                
                                left++;
                                right--;
                            } else if (sum < target) {
                                left++;
                            } else {
                                right--;
                            }
                        }
                    }
                }
            }
        }

        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        for (ArrayList<Integer> i : set) {
            ret.add(i);
        }

        return ret;
    }
}