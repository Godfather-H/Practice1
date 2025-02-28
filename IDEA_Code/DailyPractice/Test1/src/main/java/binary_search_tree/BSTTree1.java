package binary_search_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BSTTree1{

    static class BSTNode {
        int key;
        Object value;
        BSTNode left;
        BSTNode right;

        public BSTNode(int key) {
            this.key = key;
        }

        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

    BSTNode root;

    public Object get(int key) {
       BSTNode current = root;
       while (current != null) {
           if (current.key > key){
               current = current.left;
           } else if (current.key < key){
               current = current.right;
           } else {
               return current.value;
           }
       }
       return null;
    }

    /*public Object doGet(BSTNode root, int key){
        if(root == null){
            return null;
        }
        if(root.key > key){
            return doGet(root.left, key);
        } else if(root.key < key){
            return doGet(root.right, key);
        } else {
            return root.value;
        }
    }*/

    public Object min(){
        return min(root);
    }

    public Object min(BSTNode node){
        if (node == null){
            return null;
        }
        BSTNode current = node;
        while(current.left != null){
            current = current.left;
        }
        return current.value;
    }

    public Object max(){
        return max(root);
    }

    public Object max(BSTNode node){
        if (node == null) {
            return null;
        }
        BSTNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }

    public void put(int key, Object value) {
        BSTNode current = root;
        BSTNode parent = root;
        while (current != null) {
            if( key > current.key ){
                parent = current;
                current = current.right;
            } else if ( key < current.key ){
                parent = current;
                current = current.left;
            } else {
                current.value = value;
                return;
            }
        }

        if (parent == null) {
            root = new BSTNode(key, value);
            return;
        }

        if(key < parent.key){
            parent.left = new BSTNode(key, value);
        } else {
            parent.right = new BSTNode(key, value);
        }
    }

    //查找前驱者
    public Object successor(int key) {
        BSTNode node = root;
        BSTNode ancestorFromLeft = null;

        while (node != null) {
            if (key < node.key){
                node = node.left;
            } else if (key > node.key){
                ancestorFromLeft = node;
                node = node.right;
            } else {
                break;
            }
        }

        if (node == null) {
            return null;
        }

        if (node.left != null) {
            return max(node.left);
        }

        return ancestorFromLeft == null ? null : ancestorFromLeft.value;
    }

    public Object predecessor(int key) {
        BSTNode node = root;
        BSTNode ancestorFromRight = null;
        while (node != null) {
            if (key < node.key){
                ancestorFromRight = node;
                node = node.left;
            } else if (key > node.key){
                node = node.right;
            } else {
                break;
            }
        }

        if (node == null) {
            return null;
        }

        if (node.right != null) {
            return min(node.right);
        }

        return ancestorFromRight == null ? null : ancestorFromRight.value;
    }

    public Object delete(int key) {
        BSTNode node = root;
        BSTNode parent = null;
        while(node != null){
            if (key < node.key){
                parent = node;
                node = node.left;
            } else if (key > node.key){
                parent = node;
                node = node.right;
            } else {
                break;
            }
        }

        if (node == null) {
            return null;
        }

        if(node.right == null){
            shift(parent, node, parent.left);
        } else if (node.left == null){
            shift(parent, node, node.right);
        } else {
            BSTNode current = node.right;
            BSTNode cParent = node;
            while (current.left != null) {
                cParent = current;
                current = current.left;
            }
            if(cParent != node){
                shift(cParent, current, current.right);
                current.right = node.right;
            }
            current.left = node.left;
            shift(parent, node, current);
        }
        return node.value;
    }

    public void shift(BSTNode parent, BSTNode deleted, BSTNode child){
        if(parent == null){
            root = child;
        } else if(deleted == parent.left){
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    public List<Object> less(int key){
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while(p != null || !stack.isEmpty()){
            if(p != null ){
                stack.push(p);
                p = p.left;
            } else {
                BSTNode pop = stack.pop();
                if(pop.key < key){
                    result.add(pop.value);
                } else {
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }
}
