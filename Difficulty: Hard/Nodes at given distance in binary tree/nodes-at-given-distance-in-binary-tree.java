class Solution {
    public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Step 1: Map child -> parent
        Map<Node, Node> parentMap = new HashMap<>();
        Node targetNode = buildParentMap(root, target, parentMap);

        // Step 2: BFS from target node
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        queue.add(targetNode);
        visited.add(targetNode);

        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (distance == k) {
                for (Node node : queue) {
                    result.add(node.data);
                }
                break;
            }

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                // Left child
                if (current.left != null && !visited.contains(current.left)) {
                    visited.add(current.left);
                    queue.add(current.left);
                }

                // Right child
                if (current.right != null && !visited.contains(current.right)) {
                    visited.add(current.right);
                    queue.add(current.right);
                }

                // Parent
                Node parent = parentMap.get(current);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.add(parent);
                }
            }

            distance++;
        }

        Collections.sort(result);
        return result;
    }

    private static Node buildParentMap(Node root, int target, Map<Node, Node> parentMap) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node targetNode = null;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.data == target) {
                targetNode = current;
            }

            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.add(current.left);
            }

            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.add(current.right);
            }
        }

        return targetNode;
    }
}
