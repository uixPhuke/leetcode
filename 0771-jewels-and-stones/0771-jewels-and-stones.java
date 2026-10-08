class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] checker=new boolean[256];
        int count=0;
        for(char ch: jewels.toCharArray()){
            checker[ch]=true;
        }
        for(char ch: stones.toCharArray()){
            if(checker[ch]){
                count ++;
            }
        }
        return count;
        
    }
}