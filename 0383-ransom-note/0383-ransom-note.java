class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq=new int[256];
       // int[] freq2=new int[256];
        for(char ch:magazine.toCharArray()){
            freq[ch]++;
        }
        for(char ch:ransomNote.toCharArray()){
        
            if(freq[ch]==0){
                return false;
            }
            freq[ch]--;
        }
        return true;

    }
}