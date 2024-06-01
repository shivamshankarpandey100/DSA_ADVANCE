


import java.util.*;
class Pair {
    int freq;
    int fi;
    int li;

    Pair(int freq, int fi, int li) {
        this.freq = freq;
        this.fi = fi;
        this.li = li;
    }
}

class Main {
    public static void solution(int[] arr) {
        
        HashMap<Integer, Pair> map = new HashMap<>();
        int mfi = arr[0];     // Max. Frequency Item
        int mfikiFreq = 1;    // Max. Frequency Item ki frequency
        int mfikiSi = 0;      // Max. Frequency Item Starting Index
        int mfikiLen = 1;     // Max. Frequency Item ki Length

        map.put(arr[0], new Pair(1, 0, 0));

        for(int i = 0; i < arr.length; i++){
            int val = arr[i];
            if(map.containsKey(val)){
                Pair p = map.get(val);
                p.freq++;
                p.li = i;

                int len = i - p.fi + 1;

                if(p.freq > mfikiFreq){
                    mfi = val;
                    mfikiFreq = p.freq;
                    mfikiSi = p.fi;
                    mfikiLen = len;
                }else if(p.freq == mfikiFreq && len < mfikiLen){
                    mfi = val;
                    mfikiFreq = p.freq;
                    mfikiSi = p.fi;
                    mfikiLen = len;
                }else if(p.freq == mfikiFreq && len == mfikiLen && p.fi < mfikiSi){
                    mfi = val;
                    mfikiFreq = p.freq;
                    mfikiSi = p.fi;
                    mfikiLen = len;
                }else{
                    map.put(val, new Pair(1, i, i));

                }
            }
        }

        System.out.println(mfi);
        System.out.println(mfikiSi);
        System.out.println(mfikiSi + mfikiLen - 1); 
    }
}