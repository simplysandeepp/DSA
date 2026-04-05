class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long c =mass;
        for(int i:asteroids){
            if(i>c) return false;
            c+=i;
        }
        return true;
    }
}