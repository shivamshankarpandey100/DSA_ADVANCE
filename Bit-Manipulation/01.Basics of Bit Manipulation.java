
import java.util.*;

class Main{

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int i = scn.nextInt();
    int j = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();

    int bmforON = 1 << i; // bm = bit map
    System.out.println(n | bmforON);

    int tbm = 1 << j;
    int bmforOFF = ~tbm;
    System.out.println(n & bmforOFF);

    int bmforToggle = 1 << k;
    System.out.println(n ^ bmforToggle);

    int bmforCheck = 1 << m;
    if ((n & bmforCheck) == 0) {
      System.out.println(false);
    } else {
      System.out.println(true);
    }

    scn.close();
  }

}