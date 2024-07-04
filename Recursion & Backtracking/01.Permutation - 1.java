
class main{

  public static void permutations(int[] boxes, int ci, int ti){
    
    if(ci > ti){
        for(int val : boxes){
            System.out.print(val + "");
        }
        System.out.println();
        return;
    }

    for(int i = 0 ; i < boxes.length; i++){
        if(boxes[i] == 0){
            boxes[i] = ci;
            permutations(boxes, ci + 1, ti);
            boxes[i] = 0;
        }
    }
  }

}