package BinaryTree;

import java.util.Hashtable;

public class SplayTree {
    class Node {
        private int key;
        private Node right;
        private Node left;

        public Node(int key) {
            this.key = key;
            this.right = null;
            this.left = null;
        }

        public int getKey() {
            return key;
        }

        public Node getRight() {
            return right;
        }

        public Node getLeft() {
            return left;
        }
    }

    private Node root;

    private Node rightRotation(Node oldNode) {
        Node newNode = oldNode.left;
        oldNode.left = newNode.right;
        newNode.right = oldNode;
        return newNode;
    }

    private Node leftRotation(Node oldNode) {
        Node newNode = oldNode.right;
        oldNode.right = newNode.left;
        newNode.left = oldNode;

        return newNode;
    }


    private Node splay(Node root, int key) {

        if (root == null || root.key == key)
            return root;

        if (key < root.key)
        {
            if (root.left == null)
                return root;

            if (root.left.key > key)
            {
                root.left.left = splay(root.left.left, key);

                root = rightRotation(root);
            }
            else if (root.left.key < key)
            {

                root.left.right = splay(root.left.right, key);


                if (root.left.right != null)
                    root.left = leftRotation(root.left);
            }
            if (root.left != null)
                return rightRotation(root);
            else
                return root;

        }

        if (key > root.key)
        {

            if (root.right == null) return root;


            if (root.right.key > key)
            {

                root.right.left = splay(root.right.left, key);


                if (root.right.left != null)
                    root.right = rightRotation(root.right);
            }
            else if (root.right.key < key)
            {

                root.right.right = splay(root.right.right, key);
                root = leftRotation(root);
            }

            if (root.right != null)
                return leftRotation(root);
            else
                return root;
        }
        return root;
    }


    public void insert(int key) {
        root = insertRec(root, key);
    }

    public void inorder() {
        inorderRec(root);
    }

    public void inorderRec(Node root) {

        if (root == null)
            return;

        inorderRec(root.left);
        System.out.print(root.key + " ");
        inorderRec(root.right);
    }

    Node insertRec(Node root, Integer key) {

        int comp;
        Node node;

        if (root == null) return new Node(key);

        root = splay(root, key);
        comp = key.compareTo(root.key);

        node = new Node(key);

        if (comp != 0) {
            if (comp > 0) {
                node.left = root;
                node.right = root.right;
                root.right = null;
                root = node;
            } else if (comp < 0) {
                node.right = root;
                node.left = root.left;
                node.left = null;
                root = node;
            }
        }

        return root;
    }

    public void delete(Integer key) {
        deleteRec(this.root, key);
    }

    private Node deleteRec(Node root, Integer key) {

        if (root == null) return null;
        root = splay(root, key);
        int check = key.compareTo(root.key);
        if (check == 0) {
            if (root.left == null) {
                root = root.right;
            } else {
                Node temp = root.right;
                root = root.left;
                splay(root, key);
                root.right = temp;
            }
        }
        return root;
    }

    public Node searchByKey(Integer key){
        return splay(root, key);
    }

    public Node searchByKeyRec(Node root, Integer key){

        Node temp= splay(root,key);
        int check=0;
        if(key.compareTo(root.key)==0) check=1;
        root=temp;

        return root;
        }

    }

