class MyHashSet {
    boolean[] result;

    public MyHashSet() {
     result=new boolean[1000001];

        
    }
    
    public void add(int key) {

        result[key]=true;
    }
    
    public void remove(int key) {
        result[key]=false;
    }
    
    public boolean contains(int key) {
        return result[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */