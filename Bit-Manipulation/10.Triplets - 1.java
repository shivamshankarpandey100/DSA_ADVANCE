class Main {

	public static void solution(int[] arr){
		
        int n = arr.length; 
        int count = 0;

        for(int i = 0; i < n ; i++){
            int xor = arr[i];
            for(int k = i + 1; k < n; k++){
                xor = xor ^ arr[k];
                if(xor == 0){
                    count += k - i;
                }
            }
        }

        System.out.println(count);
	
    }
}