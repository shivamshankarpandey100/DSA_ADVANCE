import java.io.*;
class Main{

  public static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf){

    if(cb > tb){
        if(ssf == ts){
            System.out.println(asf);
        }
        return;

    }

    for(int i = 0; i < items.length; i++){
        if(items[i] == 0){
            items[i] = cb;
            permutations(cb + 1, tb, items, ssf + 1, ts, asf + "" + (i + 1));
            items[i] = 0;
        }
    }
    permutations(cb + 1, tb, items, ssf, ts, asf + "0");
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(1, nboxes, new int[ritems], 0, ritems, "");
  }

}