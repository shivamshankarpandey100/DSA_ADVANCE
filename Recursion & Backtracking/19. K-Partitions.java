import java.util.*;
class Main {

    static int counter = 0;
	
    public static void solution(int i, int n, int rssf, ArrayList<ArrayList<Integer>> ans) {
		
        if(i == n + 1){
            if(rssf == 0){
                    counter++;
                    System.out.print(counter + ". ");

                        for(ArrayList<Integer> set : ans){
                            System.out.print(set + " ");
                        }
                    System.out.println();
            }

            return;
        }
		
        for(int ii = 0; ii < ans.size(); ii++){
            ArrayList<Integer> ithList = ans.get(ii);
            
                if(ithList.size() == 0){
                    ithList.add(i);
                    solution(i + 1, n, rssf - 1, ans);
                    ithList.remove(ithList.size() - 1);
                    break;
                }else{
                    ithList.add(i);
                    solution(i + 1, n, rssf, ans);
                    ithList.remove(ithList.size() - 1);
                }
        }
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int k = scn.nextInt();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
                for(int i  = 0; i < k; i++) {
                    ans.add(new ArrayList<>());
                }
		solution(1, n, k, ans);

        scn.close();

	}

}