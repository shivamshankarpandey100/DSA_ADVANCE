//https://www.geeksforgeeks.org/problems/activity-selection-1587115620/1

class Pair{
    int s,e;
    Pair(int s,int e){
        this.s=s;
        this.e=e;
    }
}
class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here.
        int n=start.length;
        Pair[] arr= new Pair[n];
        int x=0;
        for(int i=0;i<start.length;i++){
            arr[x++]=new Pair(start[i],finish[i]);
        }
        Arrays.sort(arr, (a,b)->Integer.compare(a.e,b.e));
        
        int c=0;
        List<Pair> li=new ArrayList<>();
        li.add(new Pair(arr[0].s, arr[0].e));
        for(int i=1;i<n;i++){
            Pair peek=li.get(li.size()-1);
            Pair curr=arr[i];
            
            if(curr.s>peek.e){
                li.add(new Pair(curr.s,curr.e));
                c++;
            }
        }
        return c+1;
    }
}