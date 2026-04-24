// class Solution {
//     public int furthestDistanceFromOrigin(String m) {
//         int sum =0,l=0, r=0, d=0;
//         for(char i =0; i<m.length(); i++){
//             if(m.charAt(i) == 'L') l++;
//             if(m.charAt(i) == 'R') r++;
//             if(m.chartAt(i) == " ") d++;
//         }
//         if(l>r) sum = Math.abs(l-r);
//         if(l<r) sum = Math.abs(r-l);

//         sum += d;
//         return sum;
//     }
// }

class Solution {
    public int furthestDistanceFromOrigin(String m) {
        int l=0, r=0, d=0;
        for (int i=0; i<m.length(); i++) {
            if (m.charAt(i) == 'L') l++;
            else if (m.charAt(i) == 'R') r++;
            else d++; 
        }

        return Math.abs(l-r)+d;
    }
}