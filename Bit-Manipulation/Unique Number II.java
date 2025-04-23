//https://www.geeksforgeeks.org/problems/finding-the-numbers0215/1

public int[] singleNum(int[] arr) {
        int xor=0;
        for(int i:arr) xor^=i;
        int bitMask= xor & -xor;
        int x=0,y=0;
        for(int i:arr){
            if((i&bitMask)==0) x^=i;
            else y^=i;
        }
        
        return new int[]{Math.min(x,y),Math.max(x,y)};
    }