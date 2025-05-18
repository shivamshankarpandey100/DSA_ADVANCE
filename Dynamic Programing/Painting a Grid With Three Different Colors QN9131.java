//https://leetcode.com/problems/painting-a-grid-with-three-different-colors/

import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        List<int[]> validStates = new ArrayList<>();
        Map<String, Integer> stateToIndex = new HashMap<>();

        // Generate all valid states for a single column of height m
        generateStates(m, 0, new int[m], validStates, stateToIndex);

        int numStates = validStates.size();
        List<Integer>[] transitions = new List[numStates];

        // Precompute valid transitions between states
        for (int i = 0; i < numStates; i++) {
            transitions[i] = new ArrayList<>();
            for (int j = 0; j < numStates; j++) {
                if (areCompatible(validStates.get(i), validStates.get(j))) {
                    transitions[i].add(j);
                }
            }
        }

        // Initialize dp array
        int[] dp = new int[numStates];
        Arrays.fill(dp, 1); // Base case: all states are valid for column 0

        for (int col = 1; col < n; col++) {
            int[] newDp = new int[numStates];
            for (int i = 0; i < numStates; i++) {
                for (int prev : transitions[i]) {
                    newDp[i] = (newDp[i] + dp[prev]) % MOD;
                }
            }
            dp = newDp;
        }

        // Sum up all possible ways for the last column
        int result = 0;
        for (int val : dp) {
            result = (result + val) % MOD;
        }

        return result;
    }

    private void generateStates(int m, int row, int[] current, List<int[]> states, Map<String, Integer> stateToIndex) {
        if (row == m) {
            int[] newState = Arrays.copyOf(current, m);
            states.add(newState);
            stateToIndex.put(Arrays.toString(newState), states.size() - 1);
            return;
        }

        for (int color = 0; color < 3; color++) {
            if (row == 0 || current[row - 1] != color) {
                current[row] = color;
                generateStates(m, row + 1, current, states, stateToIndex);
            }
        }
    }

    private boolean areCompatible(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) return false;
        }
        return true;
    }
}
