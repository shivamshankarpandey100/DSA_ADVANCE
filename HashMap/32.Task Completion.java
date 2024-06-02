


import java.util.*;
class Main{
	
    public static void completeTask(int n, int m, int[] arr) {
		
        HashSet<Integer> completed = new HashSet<>();
        for(int val : arr){
            completed.add(val);
        }

        boolean flag = true;
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            if(completed.contains(i) == false){
                if(flag){
                    one.add(i);
                }else{
                    two.add(i);
                }
                flag = !flag;
            }
        }

        for(int val : one){
            System.out.print(val + " ");
        }
        System.out.println();

        for(int val : two){
            System.out.print(val + " ");
        }
        System.out.println();

	}
}