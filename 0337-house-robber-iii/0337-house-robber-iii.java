class Solution {
    public int rob(TreeNode root) {
        int choice[] = helper(root);
        return Math.max(choice[0], choice[1]);
    }
    public int[] helper(TreeNode root) {
        if(root == null) {
            return new int[2];
        }
        int[] lc = helper(root.left);
        int[] rc = helper(root.right);
        int[] choice = new int[2];
        //rob
        choice[0] = root.val + lc[1]+rc[1];
        // notRob
        choice[1] = Math.max(lc[0],lc[1]) + Math.max(rc[0],rc[1]);
        return choice;
    }
}