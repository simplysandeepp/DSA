class Solution {
    static int seg[];
    public void build(int idx,int left,int right,int heights[]){
        if(left==right){
            seg[idx]=heights[left];
            return;
        }
        int mid=left+(right-left)/2;
        build(2*idx+1,left,mid,heights);
        build(2*idx+2,mid+1,right,heights);
        seg[idx]=Math.max(seg[2*idx+1],seg[2*idx+2]);
    }
    
    public int queryfind(int idx,int left,int right,int qs,int target){
        if(right<qs || seg[idx]<=target) return -1;
        if(left==right) return left;
        int mid=left+(right-left)/2;
        int ans=-1;
        int leftchild=2*idx+1;
        int rightchild=2*idx+2;
        if(qs<=mid){
            ans=queryfind(leftchild,left,mid,qs,target);
        }
        if(ans==-1){
            ans=queryfind(rightchild,mid+1,right,qs,target);
        }
        return ans;
    }

    public int[] leftmostBuildingQueries(int[] heights,int[][] queries){
        int n=heights.length;
        seg=new int[4*n];
        build(0,0,n-1,heights);
        int q=queries.length;
        int res[]=new int[q];
        for(int i=0;i<q;i++){
            int a=queries[i][0];
            int b=queries[i][1];
            if(a>b){
                int temp=a;
                a=b;
                b=temp;
            }
            if(a==b || heights[b]>heights[a]){
                res[i]=b;
            }
            else{
                int target=Math.max(heights[a],heights[b]);
                res[i]=queryfind(0,0,n-1,b+1,target);
            }
        }
        return res;
    }
}

