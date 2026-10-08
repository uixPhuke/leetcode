class Solution {
    public String defangIPaddr(String address) {
        StringBuilder result=new StringBuilder();
        //int left=0;
        for(int i=0;i<address.length();i++){
            if(address.charAt(i)!='.'){
                result.append(address.charAt(i));

            }
            else{
                result.append("[.]");
            }
        }
        return result.toString();
    }
}