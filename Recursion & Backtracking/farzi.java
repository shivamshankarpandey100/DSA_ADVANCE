import java.util.*;
public class Main{
public static void main(String[]args){
Scanner sc=new Scanner(System.in);

System.out.print("Enter the length of the string array :");
int n=sc.nextInt();

String[] strArr = new String[n];

for(int i=0;i<n;i++){
        System.out.println("Enter element " + (i + 1) + ": ");
        strArr[i]=sc.next();
}

System.out.print("Enter the Range count to check the element");
int r=sc.nextInt();
int [] arr1=new int[r];
int [] arr2=new int[r];

for(int i=0;i<r;i++){
        System.out.print("Enter star range and end renge ");
        arr1[i]=sc.nextInt();
        arr2[i]=sc.nextInt();
}

for(int i=0;i<r;i++){
    int count=0;
    int a=arr1[i];
    int b=arr2[i];
    for(int j=a;j<=b;j++){
        String str=strArr[j];
        
        int f=0;
        int l=str.length()-1;
        if( isVowel(str.charAt(f)) || isVowel(str.charAt(l))){
            count++;
        }
        
    }
    System.out.println(count);
}

System.out.println();


}
private static boolean isVowel(char c) {
        c = Character.toUpperCase(c);
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}


















import java.util.*;
public class Main{
public static void main(String[]args){
Scanner sc=new Scanner(System.in);

System.out.print("Enter the length of the string array :");
int n=sc.nextInt();

String[] strArr = new String[n];

for(int i=0;i<n;i++){
        System.out.println("Enter element " + (i + 1) + ": ");
        strArr[i]=sc.next();
}

System.out.print("Enter the Range count to check the element");
int r=sc.nextInt();
int [] arr1=new int[r];
int [] arr2=new int[r];

for(int i=0;i<r;i++){
        System.out.print("Enter star range and end renge ");
        arr1[i]=sc.nextInt();
        arr2[i]=sc.nextInt();
}

for(int i=0;i<r;i++){
    int count=0;
    int a=arr1[i];
    int b=arr2[i];
    for(int j=a;j<b;j++){
        String str=strArr[j];
        
        int f=0;
        int l=str.length()-1;
        if( isVowel(str.charAt(f)) || isVowel(str.charAt(l))){
            count++;
        }
        
    }
    System.out.println(count);
}

System.out.println();


}
private static boolean isVowel(char c) {
        c = Character.toUpperCase(c);
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}