class CountIntervals {
    TreeMap<Integer,Integer> m = new TreeMap<>();
    int c = 0;
    public void add(int l,int r){
        var e = m.floorEntry(r);
        while(e != null && e.getValue() >= l){
            int L = e.getKey() , R = e.getValue();
            c -= R - L + 1;
            l = Math.min(l , L);
            r = Math.max(r , R);
            m.remove(L);
            e = m.floorEntry(r);
        }
        m.put(l , r);
        c += r - l + 1;
    }
    public int count(){
        return c;
    }
}