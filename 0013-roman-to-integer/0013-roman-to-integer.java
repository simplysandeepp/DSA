class Solution {
    public int romanToInt(String s) {
        int[] arr = new int[128];

        arr['I']=1; 
        arr['V']=5; 
        arr['X']=10;
        arr['L']=50; 
        arr['C']=100;
        arr['D']=500; 
        arr['M']=1000;

        int ans = 0;
        int n = s.length()-1;

        for (int i=n; i >= 0; i--) {
            int temp = arr[s.charAt(i)];
            if (i < s.length() - 1 && temp < arr[s.charAt(i + 1)]) {
                ans -= temp;
            } else {
                ans += temp;    
            }
        }
        return ans;
    }
}