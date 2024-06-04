

import java.util.*;
class Main{
	
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		
        int n = A.length;
        if(n == 0){
            return 0;
        }

        int res = 0;
        HashMap<Integer, Integer> map= new HashMap<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                res += map.getOrDefault(-1 * (C[i] + D[j]), 0);
            }
        }

		return res;
	}
}