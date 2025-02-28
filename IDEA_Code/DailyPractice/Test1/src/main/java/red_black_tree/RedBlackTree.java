package red_black_tree;

public class RedBlackTree {
    enum Color{
        RED, BLACK;
    }

    private Node root;

    private static class Node{
        int key;
        Object value;
        Node left;
        Node right;
        Node parent;
        Color color = Color.RED;

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        boolean isLeftChild(){
            return parent != null && parent.left == this;
        }

        Node uncle() {
            if(parent == null || parent.parent == null){
                return null;
            }
            if(parent.isLeftChild()){
                return parent.parent.right;
            } else {
                return parent.parent.left;
            }
        }

        Node sibLing() {
            if(parent == null){
                return null;
            } else if(this.isLeftChild()){
                return parent.right;
            } else {
                return parent.left;
            }
        }
    }

    boolean isRed(Node node){
        return node != null && node.color == Color.RED;
    }

    boolean isBlack(Node node){
        return node == null || node.color == Color.BLACK;
    }

    private void rightRotate(Node node){
        Node parent = node.parent;
        Node yellow = node.left;
        Node green = yellow.right;

        //处理左孩子的右孩子与根节点的关系
        node.left = green;
        if(green != null){
            green.parent = node;
        }

        //处理左孩子与根节点的关系
        yellow.right = node;
        node.parent = yellow;

        //处理左孩子与根节点父亲的关系
        yellow.parent = parent;
        if(parent == null){
           root = yellow;
        } else if(node.isLeftChild()){
            parent.left = yellow;
        } else {
            parent.right = yellow;
        }
    }

    private void leftRotate(Node node){

    }

    private void put(int key, Object value){
        Node p = root;
        Node parent = null;
        while(p != null){
            parent = p;
            if(key < p.key){
                p = p.left;
            } else if(key > p.key){
                p = p.right;
            } else {
                p.value = value;
                return;
            }
        }

        Node inserted = new Node(key, value);
        if(parent == null){
            root = inserted;
        } else if(key > parent.key){
            parent.right = inserted;
            inserted.parent = parent;
        } else {
            parent.left = inserted;
            inserted.parent = parent;
        }
        fixRedRed(inserted);
    }

    void fixRedRed(Node x){
        //case1 插入节点是根节点， 变黑即可
        if (x == root){
            x.color = Color.BLACK;
            return;
        }

        //case2 插入节点父亲是黑色， 无需调整
        if (isBlack(x.parent)){
            return;
        }

        //case3 当红红相邻，叔叔为红时
        //需要将父亲，叔叔变成黑色，祖父变成红色
        //然后再递归祖父，判断祖父是否为红红
        Node parent = x.parent;
        Node uncle = x.uncle();
        Node grandparent = x.parent.parent;
        if(isRed(uncle)){
            parent.color = Color.BLACK;
            uncle.color = Color.BLACK;
            grandparent.color = Color.RED;
            fixRedRed(grandparent);
            return;
        }

        //case4 当红红相邻，叔叔为黑色时
        //
        if(parent.isLeftChild() && x.isLeftChild()){
            parent.color = Color.BLACK;
            grandparent.color = Color.RED;
            rightRotate(grandparent);
        } else if(parent.isLeftChild()){
            leftRotate(parent);
            x.color = Color.BLACK;
            grandparent.color = Color.RED;
            rightRotate(grandparent);
        } else if(!x.isLeftChild()){
            parent.color = Color.BLACK;
            grandparent.color = Color.RED;
            leftRotate(grandparent);
        } else {
            rightRotate(parent);
            x.color = Color.BLACK;
            grandparent.color = Color.RED;
            leftRotate(grandparent);
        }
    }

    Node find(int key){
        Node p = root;
        while(p != null){
            if(key < p.key){
                p = p.left;
            } else if(key > p.key){
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    Node findReplaced(Node deleted) {
        if (deleted.left == null && deleted.right == null){
            return null;
        }
        if(deleted.left == null){
            return  deleted.right;
        }
        if(deleted.right == null){
            return  deleted.left;
        }
        
        Node s = deleted.right;
        while(s.left != null){
            s = s.left;
        }
        return s;
    }

    private void doRemove(Node deleted){
        Node replaced = findReplaced(deleted);
        Node parent = replaced.parent;
        //没有孩子
        if(replaced == null){
            if(deleted == root){
                root = null;
            } else {
                if(isBlack(deleted)){
                    //复杂处理
                } else {
                    //匹配的是红色，无需处理
                }

                if(deleted.isLeftChild()){
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                deleted.parent = null;
            }
        }

        //有一个孩子
        if(deleted.left == null || deleted.right == null){
            if(deleted == root){
                deleted.key = replaced.key;
                deleted.value = replaced.value;
                deleted.left = deleted.right = null;
            } else {
                if(deleted.isLeftChild()){
                    parent.left = replaced;
                } else {
                    parent.right = replaced;
                }
                replaced.parent = parent;
                deleted.left = deleted.right = deleted.parent = null;

                if(isBlack(deleted) && isBlack(replaced)){
                    //复杂处理
                } else {
                    replaced.color = Color.BLACK;
                }
            }

        }

        //有两个孩子
        int k = deleted.key;
        deleted.key = replaced.key;
        replaced.key = k;

        Object v = deleted.value;
        deleted.value = replaced.value;
        replaced.value = v;
        doRemove(replaced);
    }
}
