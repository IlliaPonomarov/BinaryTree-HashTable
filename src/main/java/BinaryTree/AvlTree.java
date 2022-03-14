package BinaryTree;

public class AvlTree {

    Node root;
    class Node{
        int key;
        Node right;
        Node left;
        int height;

        public Node(int key) {
            this.key = key;
            this.right = null;
            this.left = null;
            this.height = 1;
        }
    }

    int height(Node node){
        if (node == null)
            return 0;

        return node.height;
    }

    int max(int a, int b){
        return (a > b) ? a : b;
    }

    Node rightRotate(Node y){
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right) + 1);
        x.height = max(height(x.left), height(x.right) + 1);

        return x;
    }

    Node leftRotate(Node x){
        Node y = x.left;
        Node T2 = y.right;

        y.right = x;
        x.left = T2;

        x.height = max(height(x.left), height(x.right) + 1);
        y.height = max(height(y.left), height(y.right) + 1);

        return y;
    }

    int getBalance(Node node){
        if (node == null)
            return 0;
       return height(node.left) - height(node.right);
    }


    public void insert(int key){
        root = insertRec(root, key);
    }

    Node insertRec(Node node, int key) {
        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insertRec(node.left, key);
        else if (key > node.key)
            node.right = insertRec(node.right, key);
        else
            return node;

        node.height = max(height(root.left), height(root.right));

        int balance = getBalance(node);


        //left left case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        //right right case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        //left right case
        if (balance > 1 && key > node.left.key){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //right left case
        if (balance < -1 && key < node.left.key){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        return node;
    }

    public void inorder(){
        inorderRec(root);
    }

    void inorderRec(Node root){
        if (root == null)
            return;

        inorderRec(root.left);
        System.out.print(" " + root.key + " (" + root.height + ")\t");
        inorderRec(root.right);
    }
}
