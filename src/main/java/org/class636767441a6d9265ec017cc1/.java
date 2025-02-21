package org.class636767441a6d9265ec017cc1;

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

private TreeNode<T> rotateRight(TreeNode<T> node) {
    if (node == null || node.left == null) {
        return node; // No rotation needed
    }

    TreeNode<T> newRoot = node.left; // New root will be the left child
    node.left = newRoot.right; // Right child of new root becomes left child of node
    newRoot.right = node; // Node becomes the right child of new root

    return newRoot; // Return the new root
}