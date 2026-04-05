class Solution {
    public boolean judgeCircle(String moves) {
        int i=0; int j=0;
        for(char ch:moves.toCharArray()){
            if(ch=='D') i++;
            if(ch=='U') i--;
            if(ch=='R') j++;
            if(ch=='L') j--;
        }
        return (i==0 && j==0);
    }
}