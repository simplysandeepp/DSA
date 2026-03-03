class Solution {
    public boolean isIdentical(Node r1, Node r2) {
        // If both are null
        if (r1 == null && r2 == null) return true;

        // If one is null
        if (r1 == null || r2 == null) return false;

        // Check current node + left subtree + right subtree
        return (r1.data == r2.data) &&
               isIdentical(r1.left, r2.left) &&
               isIdentical(r1.right, r2.right);
    }
}