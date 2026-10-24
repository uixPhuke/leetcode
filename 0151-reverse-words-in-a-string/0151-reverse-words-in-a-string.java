class Solution {
    public String reverseWords(String s) {
        String[] chunk=s.trim().split("\\s+");
        StringBuilder sb=new StringBuilder();
        for(int i=chunk.length-1;i>=0;i--){
            sb.append(chunk[i]);
            if(i>0){
                sb.append(" ");
            }
        }
        return sb.toString();

    }
}