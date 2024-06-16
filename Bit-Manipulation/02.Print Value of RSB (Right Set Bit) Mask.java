public class Main{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int fcom=~n;
        int fcom2s=fcom+1;
        int rsbm=n&fcom2s;

        System.out.println(Integer.toBinaryString(rsb));
        scn.close();
    }
}