class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] left = new int[m];
        int[] right = new int[n];

      
        for (int i = 0; i < m; i++) {
            left[i] = nums1[i];
        }

      
        for (int j = 0; j < n; j++) {
            right[j] = nums2[j];
        }

        int i = 0;
        int j = 0;
        int k = 0;

      
        while (i < m && j < n) {

            if (left[i] <= right[j]) {
                nums1[k++] = left[i++];
            } 
            else {
                nums1[k++] = right[j++];
            }
        }

        
        while (i < m) {
            nums1[k++] = left[i++];
        }

        while (j < n) {
            nums1[k++] = right[j++];
        }
    }
}