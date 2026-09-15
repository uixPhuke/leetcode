class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        Set<Integer> resultSet=new HashSet<>();
      

       for(int num:nums1){
        set.add(num);
       }
       for(int num:nums2){
        if(set.contains(num)){
            resultSet.add(num);
        }
       }
       
        int[] result=new int[resultSet.size()];
        int i=0;
       for(int num:resultSet){
        result[i++]=num;

       }

        return result;
    }
}