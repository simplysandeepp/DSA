class Solution {
    static class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int minIndex = q.peekFirst().index;  // normalization
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {

                Pair curr = q.poll();
                TreeNode node = curr.node;
                int idx = curr.index - minIndex;

                if (i == 0) first = idx;
                if (i == size - 1) last = idx;

                if (node.left != null) {
                    q.offer(new Pair(node.left, 2 * idx + 1));
                }

                if (node.right != null) {
                    q.offer(new Pair(node.right, 2 * idx + 2));
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
            
        }

        return maxWidth;
    }
}