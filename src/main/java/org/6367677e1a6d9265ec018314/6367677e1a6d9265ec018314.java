import java.util.*;

class CategoryTree {
    private Node root;

    private class Node {
        String name;
        boolean isActive;
        List<Node> children;

        Node(String name, boolean isActive) {
            this.name = name;
            this.isActive = isActive;
            this.children = new ArrayList<>();
        }
    }

    protected int removeUnusedNodes() {
        if (root == null) {
            return 0;
        }
        return removeUnusedNodesHelper(root);
    }

    private int removeUnusedNodesHelper(Node node) {
        if (node == null) {
            return 0;
        }

        int removedCount = 0;
        Iterator<Node> iterator = node.children.iterator();
        while (iterator.hasNext()) {
            Node child = iterator.next();
            if (!child.isActive) {
                iterator.remove();
                removedCount++;
            } else {
                removedCount += removeUnusedNodesHelper(child);
            }
        }

        return removedCount;
    }

    // Example usage
    public static void main(String[] args) {
        CategoryTree tree = new CategoryTree();
        // Populate the tree with nodes
        // tree.root = new Node("Root", true);
        // tree.root.children.add(new Node("Child1", false));
        // tree.root.children.add(new Node("Child2", true));
        // ...

        int removedNodes = tree.removeUnusedNodes();
        System.out.println("Removed " + removedNodes + " unused nodes.");
    }
}