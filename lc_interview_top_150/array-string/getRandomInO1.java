class RandomizedSet {

    List<Integer> vals;
    HashMap<Integer, Integer> indexer;
    Random rnd;

    public RandomizedSet() {
        vals = new ArrayList<>();
        indexer = new HashMap<>();
        rnd = new Random();
    }
    
    public boolean insert(int val) {
        if(indexer.containsKey(val))
            return false;
        vals.add(val);
        indexer.put(val, vals.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(indexer.containsKey(val)){
            int index = indexer.remove(val);
            int lastIndex = vals.size()-1;
            if (index != lastIndex) {
                int lastElement = vals.get(lastIndex);
                vals.set(index, lastElement);
                indexer.put(lastElement, index);
            }
            vals.remove(vals.size()-1);
            return true;
        }
        return false;
        
    }
    
    public int getRandom() {
        return vals.get(rnd.nextInt(vals.size()));
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
