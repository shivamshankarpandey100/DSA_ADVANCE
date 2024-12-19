//https://www.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1

class Solution {
    public ArrayList<Integer> spirallyTraverse(int a[][]) {
        ArrayList<Integer> al = new ArrayList<>();
        if(a.length ==0 || a[0].length ==0) return al;
        
        int left = 0, right = a[0].length-1;
        int top = 0, bottom = a.length-1;
        
        while(left <= right && top <= bottom){
            for(int i=left; i<= right; i++)
                al.add(a[top][i]);
            top++;
            
            for(int i=top; i<=bottom; i++)
                al.add(a[i][right]);
            right--;
            
            if(top <= bottom){
                for(int i=right; i>=left; i--)
                    al.add(a[bottom][i]);
                bottom--;
            }
            
            if(left <= right){
                for(int i=bottom; i>=top; i--)
                    al.add(a[i][left]);
                left++;
            }
        }
        return al;
    }
}