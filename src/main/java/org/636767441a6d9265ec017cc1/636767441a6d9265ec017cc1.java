import java.util.Objects;

public class BinarySearchTree<T extends Comparable<T>> {

    private class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;
        
        TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /** 
     * Realiza una rotación a la derecha de un nodo.
     * @param node un nodo a rotar
     * @return un nuevo padre del {@code node}
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