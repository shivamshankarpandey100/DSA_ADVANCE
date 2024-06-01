class Pair{
    int freq;
    int ind;
    Pair(int freq, int ind){
        this.freq = freq;
        this.ind = ind;
    }
}

public static int solutation(String s){
    HashMap<Character, Pair> map=new HashMap<>();
    for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        if(map.containsKey(ch)){
            Pair p=map.get(ch);
            p.freq++;
            map.put(ch,p);
        }else{
            map.put(ch,new Pair(1,i));
        }
    }
    int min=Integer.MAX_VALUE;
    for(char ch:map.keySet()){
        Pair p=map.get(ch);
        if(p.freq==1){
            min=Math.min(min,p.ind);
        }
    }
    return min;
}

// <<<<<<<<<<<<<<<<<<<<<<2nd method>>>>>>>>>>>>>>>>>>>>>>>
public static int solutation(String s){
    HashMap<Character, Pair> map=new HashMap<>();
    for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        if(map.containsKey(ch)){
            Pair p=map.get(ch);
            p.freq++;
            map.put(ch,p);
        }else{
            map.put(ch,new Pair(1,i));
        }
    }
    int min=Integer.MAX_VALUE;
    for(char ch:map.keySet()){
        Pair p=map.get(ch);
        if(p.freq==1){
            min=Math.min(min,p.ind);
        }
    }
    return min;

}


// <<<<<<<<<<<<<3nd method >>>>>>>>>>>>>>>>>>>>




class Main{
	public static int solution(String s) {
		int []arr = new int[256];
        for(int i = 0 ; i <s.length(); i++){
            arr[s.charAt(i)]++;
        }

        for(int i = 0; i < s.length(); i++){
            if(arr[s.charAt(i)] == 1){
                return i;
            }
        }

        return -1;
	 }
}


