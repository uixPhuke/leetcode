class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result=new int[m+n];
        int i=0,k=0,j=0;

        while(i<m && j<n){
                if(nums1[i]<nums2[j]){
                   result[k]=nums1[i];
                    i++;

                }
                 else{
                     result[k]=nums2[j];
                    j++;

                }
                k++;
            }
            while(i<m ){
                
                   result[k]=nums1[i];
                    k++;
                    i++;

                }
                while(j<n){
                
                   result[k]=nums2[j];
                    k++;
                    j++;

                }
                for(int x=0;x<m+n;x++){
                    nums1[x]=result[x];
                }

        }

    }
