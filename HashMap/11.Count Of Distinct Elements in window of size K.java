public static void main(Strin[]args){
    HashMap<Character, Integer> map = new HashMap<>();

    for(int i=0;i<k;i++){
        map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0)+1);
    }
    System.out.println(map.size());

    int j=0;
    for(int i=k;i<str.length();i++){
        map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0)+1);

        if(map.get(str.charAt(j))==1){
            map.remove(str.charAt(j));
        }
        else{
            map.put(str.charAt(j), map.get(str.charAt(j))-1); 
        }
        System.out.println(map.size());
    }
}