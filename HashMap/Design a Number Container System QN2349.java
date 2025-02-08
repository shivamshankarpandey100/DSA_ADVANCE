//https://leetcode.com/problems/design-a-number-container-system

class NumberContainers {

    private Map<Integer, Integer> mp; 
    private TreeMap<Integer, TreeSet<Integer>> pos; 

    public NumberContainers() {
        mp = new HashMap<>();
        pos = new TreeMap<>();
    }

    public void change(int index, int number) {
        if (mp.containsKey(index)) {
            int oldNumber = mp.get(index); 

            pos.get(oldNumber).remove(index);

            if (pos.get(oldNumber).isEmpty()) {
                pos.remove(oldNumber);
            }
        }

        mp.put(index, number);

        pos.putIfAbsent(number, new TreeSet<>());
        pos.get(number).add(index);
    }

    public int find(int number) {
        if (!pos.containsKey(number) || pos.get(number).isEmpty()) {
            return -1;
        }
        return pos.get(number).first(); 
    }
}