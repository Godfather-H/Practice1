package binary_search_tree;

public class BSTTree2 <T extends Comparable<T>>{

    static class BSTNode<T> {
        T key;
        Object value;
        BSTNode<T> left;
        BSTNode<T> right;

        public BSTNode(T key) {
            this.key = key;
        }

        public BSTNode(T key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(T key, Object value, BSTNode<T> left, BSTNode<T> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    BSTNode<T> root;

    public Object get(T key){
        BSTNode<T> node = root;
        while (node != null){
            int result = key.compareTo(node.key);
            if (result < 0) {
                node = node.left;
            } else if (result > 0) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }
}
