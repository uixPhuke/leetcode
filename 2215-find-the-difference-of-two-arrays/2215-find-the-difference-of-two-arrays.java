class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer=new ArrayList<>();
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();

        List<Integer> r1=new ArrayList<>();
        List<Integer> r2=new ArrayList<>();

        for(int num:nums1){
            set1.add(num);
        }
        for(int num:nums2){
            set2.add(num);
        }

        for(int num: set1){
            if(!set2.contains(num)){
                r1.add(num);
            }
        }
        for(int num: set2){
            if(!set1.contains(num)){
                r2.add(num);
            }
        }

        answer.add(r1);
        answer.add(r2);
        return answer;


   


    }
}