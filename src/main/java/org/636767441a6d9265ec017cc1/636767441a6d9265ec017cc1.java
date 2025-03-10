class TreeNode<T> {
    T value;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class TreeRotation<T> {
    /**
     * Performs a right node rotation.
     * @param node a node to rotate
     * @return a new parent of the {@code node}
     */
    private TreeNode<T> rotateRight(TreeNode<T> node) {
        if (node == null || node.left == null) {
            return node;
        }

        TreeNode<T> newParent = node.left;
        node.left = newParent.right;
        newParent.right = node;

        return newParent;
    }
}