class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int check = x;
        int r = 0;
        while (x>0) {
            r= (r*10) + (x%10);
            x/=10;
        }
        if(r==check) return true;
        else return false;        
    }
}