import java.util.*;
class Main{

    public static void generateSelection(int cs, int ts, String ustr, int ls, String asf){
        
            if(cs > ts){
                System.out.println(asf);
                return;
            }

        for(int i = ls + 1; i < ustr.length(); i++){
                char ch = ustr.charAt(i);
                generateSelection(cs + 1, ts, ustr, i, asf + ch);
        }
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
            String str = scn.nextLine();
            int k = scn.nextInt();

        HashSet<Character> unique = new HashSet<>();
            String ustr = "";
            for (char ch : str.toCharArray()) {
                if (unique.contains(ch) == false) {
                    unique.add(ch);
                    ustr += ch;
                }
            }

        generateSelection(1, k, ustr, -1, "");

            scn.close();
    }

}