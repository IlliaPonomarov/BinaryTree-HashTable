package BinaryTree;

public class RedBlackTree {

    static class Node{

        private Node left;
        private Node right;
        private int key;
        private int color;

        public Node(int key) {
            this.key = key;
            this.left = right = null;
            this.color = 1;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public int getKey() {
            return key;
        }

        public int getColor() {
            return color;
        }
    }

    //Default null node for current nodes
    private static Node nullNode;

    //Parent node
    private Node parent;

    //Current node
    private Node current;

    private Node head;
    private Node great;
    private Node grand;


    private static int RED = 0;
    private static int BLACK = 0;



    public static Node getNullNode() {
        return nullNode;
    }

    public Node getParent() {
        return parent;
    }

    public Node getCurrent() {
        return current;
    }

    public Node getHead() {
        return head;
    }

    public Node getGreat() {
        return great;
    }

    public Node getGrand() {
        return grand;
    }

    public static int getRED() {
        return RED;
    }

    public static int getBLACK() {
        return BLACK;
    }
}
