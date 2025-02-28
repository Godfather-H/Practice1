package avl_tree;

public class AVLTree {

    static class AVLNode {
        int key;
        Object value;
        AVLNode left;
        AVLNode right;
        int height;

        public AVLNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public AVLNode(int key) {
            this.key = key;
        }
    }

    private int height(AVLNode root) {
        return root == null ? 0 : root.height;
    }

    //更新节点高度
    private void updateHeight(AVLNode root) {
        root.height = Integer.max(height(root.left), height(root.right)) + 1;
    }

    private int bf(AVLNode root) {
        return height(root.left) - height(root.right);
    }

    private AVLNode rightRotate(AVLNode red){
        AVLNode yellow = red.left;
        red.left = yellow.right;
        yellow.right = red;
        updateHeight(red);
        updateHeight(yellow);
        return yellow;
    }

    private AVLNode leftRotate(AVLNode red){
        AVLNode yellow = red.right;
        red.right = yellow.left;
        yellow.left = red;
        //先更新底层节点的高度
        updateHeight(red);
        //再更新高层节点的高度
        updateHeight(yellow);
        return yellow;
    }

    private AVLNode leftRightRotate(AVLNode node){
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    private AVLNode rightLeftRotate(AVLNode node){
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    private AVLNode balance(AVLNode node){
        if(node == null){
            return null;
        }

        int bf = bf(node);
        if(bf > 0 && bf(node.left) >= 0){
            return leftRotate(node);
        } else if(bf > 0 && bf(node.left) < 0){
            return rightLeftRotate(node);
        } else if(bf < 0 && bf(node.right) >= 0){
            return rightRotate(node);
        } else if(bf < 0 && bf(node.right) < 0){
            return leftRightRotate(node);
        }
        return node;
    }

    AVLNode root;

    private AVLNode put(int key, Object value) {
        return doPut(root,key,value);
    }

    private AVLNode doPut(AVLNode root, int key, Object value) {
        if(root == null){
            return new AVLNode(key,value);
        }
        if(root.key == key){
            root.value = value;
            return root;
        }

        if(key < root.key){
            root.left = doPut(root.left,key,value);
        } else if(key > root.key){
            root.right = doPut(root.right,key,value);
        }

        updateHeight(root);
        return balance(root);
    }


}
