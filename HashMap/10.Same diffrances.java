import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int j = 0; j < t; j++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < arr.length; i++){
                arr[i] = sc.nextInt();
            }

            HashMap<Integer, Integer> map = new HashMap<>();

            for(int i = 0; i < arr.length; i++){
                int diff = arr[i] - i;
                map.put(diff, map.getOrDefault(diff, 0)  + 1);
            }

            long ans = 0;
            for(int key : map.keySet()){
                long freq = (long)map.get(key);
                long val = (freq * (freq - 1) / 2);
                ans += val; 
            }

            System.out.println(ans);
        }

        sc.close();
    }
}