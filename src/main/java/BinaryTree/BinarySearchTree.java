package BinaryTree;

class Node{
    public int key;
    public Node left, right;
    public int height;

    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    //Inorder
    public void inorder(){
        inorderRec(root);
    }
    void inorderRec(Node root){

        if (root == null)
            return;

        Node tmp = root, pre;

        while (tmp != null){

            if (tmp.left == null){
                System.out.print(" " + tmp.key);
                tmp = tmp.right;
            }
            else{
              pre = tmp.left;

              while (pre.right != null && pre.right != tmp)
                  pre = pre.right;

              if (pre.right == null){
                  pre.right = tmp;
                  tmp =tmp.left;
              }
              else {
                  pre.right = null;
                  System.out.print(" " + tmp.key);
                  tmp = tmp.right;
              }
            }
        }
    }

    public void insert(int key){
        root = insertRec(root, key);
    }


    Node rightRotation(Node oldRoot){
        Node newRoot = oldRoot.left;
        Node finishChain = newRoot.right;


        newRoot.right = oldRoot;
        oldRoot.left = finishChain;

        oldRoot.height = setHeight(oldRoot) + 1;
        newRoot.height = setHeight(newRoot) + 1;

        return newRoot;
    }

    Node leftRotation(Node oldRoot){
        Node newRoot = oldRoot.right;
        Node finishChain = newRoot.left;


        newRoot.left = oldRoot;
        oldRoot.right = finishChain;

        oldRoot.height = setHeight(oldRoot) + 1;
        newRoot.height = setHeight(newRoot) + 1;

        return newRoot;
    }


    int setHeight(Node head){
        int right_height = -1;
        int left_height = -1;

        if (head.right == null)
            right_height = 0;

        if (head.left == null)
            left_height = 0;

        if (head.right != null)
            right_height = head.right.height;

        else if (head.left != null)
            left_height = head.left.height;

        if (left_height > right_height || left_height == right_height)
            return left_height;
        else
            return right_height;

    }

    int getBalance(Node head){
        int right_height = -1;
        int left_height = -1;

        if (head.right == null)
            right_height = 0;

        if (head.left == null)
            left_height = 0;

        if (head.right != null)
            right_height = head.right.height;

        else if (head.left != null)
            left_height = head.left.height;


            return left_height - right_height;
    }


    private Node insertRec(Node root, int key){

        Node node = root;
        int balance = 0;

        if (root == null)
            return new Node(key);

        else {
            while (root != null) {

                if (node.key != key) {

                    if (key > node.key) {
                        if (node.right != null)
                            node = node.right;

                        if (node.right == null) {
                            node.right = new Node(key);
                            return root;
                        }
                    }

                    if (key < node.key) {
                        if (node.left != null)
                            node = node.left;

                        if (node.left == null) {
                            node.left = new Node(key);
                            return root;
                        }
                    }
                }
                else
                    return root;
            }
        }

        node.height = setHeight(node) + 1;
        balance = getBalance(node);


       if (balance < -1){
           if (key > node.right.key)
               return leftRotation(node);

           if (key < node.right.key){
               node.right = rightRotation(node.right);
               return leftRotation(node);
           }
       }

       if (balance > 1){
           if (key < node.left.key)
               return rightRotation(node);

           if (key > node.left.key){
               node.left = leftRotation(node.right);
               return leftRotation(node);
           }
       }


        return root;
    }

    public int searchByKey(int key){
       return searchByKeyRec(root, key);
    }

    private int searchByKeyRec(Node root, int key) {

        if (root.key == key || root == null)
            return root.key;
        else {

            if (key > root.key)
                return searchByKeyRec(root.right, key);
        }
        return searchByKeyRec(root.left, key);

    }

    Node min(Node node){
        Node lastElements = node;

        while (lastElements.left != null)
            lastElements = lastElements.left;

        return lastElements;
    }

    public void deleteByKey(int key){
       root =  deleteRec(root, key);
    }

    Node deleteRec(Node root, int key){
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);

        else if (key > root.key)
            root.right = deleteRec(root.right, key);

        else
        {

            if ((root.left == null) || (root.right == null))
            {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else
                    root = temp;
            }
            else
            {
                Node temp = min(root.right);
                root.key = temp.key;
                root.right = deleteRec(root.right, temp.key);
            }
        }


        root.height = setHeight(root) + 1;

        int balance = getBalance(root);


        if (balance > 1){
            if (getBalance(root.left) >= 0)
                return rightRotation(root);

            if (getBalance(root.left) < 0){
                root.left = leftRotation(root.right);
                return leftRotation(root);
            }
        }

        if (balance < -1){
            if (getBalance(root.right) <= 0)
                return rightRotation(root);

            if (getBalance(root.right) > 0){
                root.right = rightRotation(root.right);
                return leftRotation(root);
            }
        }


        return root;
    }
}
