import java.util.*;
import java.io.*;

public class Main{
    public static void genrateSelection(int j,String ustr,HashMap<Character,Integer> unique,int ssf, int ts){
        if(j==ustr.length()){
           if(ssf==ts){
            System.out.println(asf);
           }
           return; 
        }
        
        char ch=ustr.charAt(j);
        for(int count=unique.get(ch);count>=0;count--){
            String toadd="";
            for(int i=0;i<count;i++){
                toadd+=ch;
            }
            genrateSelection(j+1,ustr,unique,ssf+count,ts,asf+toadd);
        }
        genrateSelection(j+1,ustr,unique,ssf+count,ts,asf+toadd);
    }

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());


        HashMap<Character,Integer> unique=new HashMap<>();
        String ustr="";
        for(char ch:str,toCharArray()){
            if(unique.containsKey(ch)==false){
                unique.put(ch,1);
                ustr+=ch;
            }else{
                unique.put(ch,unique.get(ch)+1);
            }
        }
        genrateSelection(0,ustr,unique,0,k,"");
    }
}