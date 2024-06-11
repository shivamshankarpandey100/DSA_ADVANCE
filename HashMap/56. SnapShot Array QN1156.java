

//  https://leetcode.com/problems/snapshot-array/ 


import java.util.*;
class SnapshotArray {

    private HashMap<Integer, Integer> [] ssHistoryMap;
    private Integer snapId;

    public SnapshotArray(int length) {
        snapId = 0;
        ssHistoryMap = new HashMap[length]; 
        
        for(int  i = 0; i < length; i++){
            ssHistoryMap[i] = new HashMap<>();
        }
    }
    
    public void set(int index, int val) {
        ssHistoryMap[index].put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        while(snap_id >= 0){
            if(ssHistoryMap[index].containsKey(snap_id)){
                return ssHistoryMap[index].get(snap_id);
            }
            snap_id--;
        }
        return 0;
    }
}