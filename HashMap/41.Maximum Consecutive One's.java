


class Main{

    public static int solution(int[] arr){
        
        int len = 0;
        int i = 0;
        int j = -1;
        int zc = 0;

        while(i < arr.length && j < i){
            while(i < arr.length){
                if(arr[i] == 1){

                }else if(arr[i] == 0){
                    zc++;
                }

                if(zc <= 1){
                    int tlen = i - j;
                    len = Math.max(len, tlen);
                    i++;
                }else{
                    i++;
                    break;
                }
            }

            while(j < i){
                j++;
                if(arr[j] == 0){
                    zc--;
                }

                if(zc <= 1){
                    break;
                }
            }
        }

        return len;
    }
}