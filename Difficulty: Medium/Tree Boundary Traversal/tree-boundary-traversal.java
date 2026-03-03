class Solution {
    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        if (!isLeaf(root)) {
            ans.add(root.data);
        }

        addLeftBoundary(root, ans);
        addLeafNodes(root, ans);
        addRightBoundary(root, ans);

        return ans;
    }

    boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    void addLeftBoundary(Node root, ArrayList<Integer> ans) {
        Node curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                ans.add(curr.data);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    void addRightBoundary(Node root, ArrayList<Integer> ans) {
        Node curr = root.right;
        Stack<Integer> stack = new Stack<>();

        while (curr != null) {
            if (!isLeaf(curr)) {
                stack.push(curr.data);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
    }

    void addLeafNodes(Node root, ArrayList<Integer> ans) {
        if (root == null) return;

        if (isLeaf(root)) {
            ans.add(root.data);
            return;
        }

        addLeafNodes(root.left, ans);
        addLeafNodes(root.right, ans);
    }
}