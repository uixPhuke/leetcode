class Solution {
    public int maxDepth(String s) {
        int i=0;
        
        int max=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                i++;
               
            }else if(ch==')'){
                i--;
            }
            max=Math.max(max,i);
        }
        return max;
    }
}