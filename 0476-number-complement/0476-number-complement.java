class Solution {
    public int findComplement(int num) {
     int count=0;
     int temp=num;
     while(temp!=0){
        temp=temp>>1;
        count++;
     }  
     temp=num ^ (int)(Math.pow(2,count)-1); 
    return temp;


    }
}