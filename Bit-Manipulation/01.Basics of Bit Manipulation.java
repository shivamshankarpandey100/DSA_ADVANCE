
import java.util.*;

class Main{

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int i = scn.nextInt();
    int j = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();

    int bmforONi = 1 << i; // bm = bit map
    System.out.println(n | bmforONi);

    int tbm = 1 << j;
    int bmforOFFj = ~tbm;//~ for toggleing
    System.out.println(n & bmforOFFj);

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

