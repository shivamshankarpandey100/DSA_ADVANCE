


// 04.Combinations - 2
class Main {

  public static void combinations(int[] boxes, int ci, int ti, int lb){
    
    if(ci > ti){
        for(int val : boxes){
            if(val != 0){
                System.out.print("i");
            }else{
                System.out.print("-");
            }
        }
        System.out.println();
        return;
    }

    for(int i = lb + 1; i < boxes.length; i++){
       if(boxes[i] == 0){
            boxes[i] = ci;
            combinations(boxes, ci + 1, ti, i);
            boxes[i] = 0;
       }
    }
  }



}
