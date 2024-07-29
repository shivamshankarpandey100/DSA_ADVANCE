import java.io.*;
import java.util.*;

class Main{

    public static void generateWords(int i, String ustr, Character [] spots, int ssf){

        if(i == ustr.length()){
            if(ssf == spots.length){
                for(char ch : spots){
                    System.out.print(ch);
                }
                System.out.println();
            }
            return;
        }

        char ch = ustr.charAt(i);
        for(int j = 0; j < spots.length; j++){
            if(spots[j] == null){
                spots[j] = ch;
                generateWords(i + 1, ustr, spots, ssf + 1);
                spots[j] = null;
            }
        }

        generateWords( i + 1, ustr, spots, ssf);
    }
 

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }

    Character [] spots = new Character[k];
    generateWords(0, ustr, spots, 0);
    
  }

}