import java.util.*;
class Main13 {
	
	public static void solution(int[] arr, int k){
		
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : arr){
            int rem = val % k;
            if(map.containsKey(rem)){
                map.put(rem, map.get(rem) + 1);
            }else{
                map.put(rem, 1);
            }
        }
 
        for(int val : arr){
            int rem = val % k;
            if(2 * rem == k){
                if(map.get(rem) % 2 != 0){
                    System.out.println("false");
                    return;
                }
            }else if(rem == 0){
                if(map.get(rem) % 2 != 0){
                    System.out.println("false");
                    return;
                }
            }else{
                if(map.get(rem) != map.get(k - rem)){
                    System.out.println("false");
                    return;
                }
            }
        }
        System.out.println("true");

	}
}