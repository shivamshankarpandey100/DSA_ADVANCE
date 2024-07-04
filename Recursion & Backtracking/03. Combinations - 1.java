

import java.io.*;
class Main {

  public static void combinations(int cb, int tb, int ssf, int ts, String asf){
    
    if(cb > tb){
        if(ssf == ts){
            System.out.println(asf);
        }
        return;
    }

    combinations(cb + 1, tb, ssf + 1, ts, asf + "i");
    combinations(cb + 1, tb, ssf + 0, ts, asf + "-");
  }
}