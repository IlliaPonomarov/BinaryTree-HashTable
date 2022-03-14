package BinaryTree;

import java.util.*;
import java.util.LinkedList;

class Node{
    public int key;
    public Node left, right;

    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
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

    public void postorder(){
        postorderRec(root);
    }

    void postorderRec(Node head) {

       Node temp = head;
       List<Node> visited = new LinkedList<Node>();

       while (temp != null && !visited.contains(temp)){

           if (temp.left != null && !visited.contains(temp.left))
               temp = temp.left;

           else if (temp.right != null && !visited.contains(temp.right))
               temp = temp.right;

           else {
               visited.add(temp);
               System.out.print(temp.key + " \t");
               temp = head;
           }
       }
    }


    public void preorder(){
        preorderRec(root);
    }

    void preorderRec(Node root){
        Node tmp = root;
        ArrayList<Node> visited = new ArrayList<>();

        while (tmp != null && !visited.contains(tmp)) {
            while (tmp.left != null) {
                if (tmp.left != null && !visited.contains(tmp.left))
                    tmp = tmp.left;
            }
            visited.add(tmp);
            System.out.print(" " + root.key + "\t");
            tmp = root;

            while (tmp.right != null) {
                if (tmp.right != null && !visited.contains(tmp.right))
                    tmp = tmp.right;
            }
        }

        for (tmp = root; tmp != null && !visited.contains(tmp); ) {

        }


    }


    public void insert(int key){
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key){

        Node node = root;

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

                    //left node
                    if (key < node.key) {
                        if (node.left != null)
                            node = node.left;

                        if (node.left == null) {
                            node.left = new Node(key);
                            return root;
                        }
                    }
                } else
                    return root;
            }
        }
        return root;
    }

    public int searchByKey(int key){
       return searchByKeyRec(root, key);
    }

    private int searchByKeyRec(Node root, int key){

        if (root.key == key || root == null)
            return root.key;
        else {

            if (key > root.key)
                return searchByKeyRec(root.right, key);
        }
        return searchByKeyRec(root.left, key);

    }

    //DELETE TEST

    public void deleteALL(){
       root =  deleteRec(root);
    }

    Node deleteRec(Node root){
        while (root != null){
            if (root.left != null)
                return root = root.left = null;

            if (root.right != null)
                return root = root.right = null;

        }
        return root;
    }


    public void deleteKey(int key){
        Node ckr1 = null, ckrParent = null;
        root = deleteKeyRec(root, key, ckr1, ckrParent);
    }


    private int min(Node root){

        int minv = root.key;
        while (root.left != null){
            minv = root.left.key;
            min(root.left);
        }

        return minv;
    }

    // Переделать
   private Node deleteKeyRec(Node root, int key, Node ckr1, Node ckrParent) {

       while (root != null) {
           if (root.key > key && root.left != null) {
               root.left = deleteKeyRec(root.left, key, null, null);
               return root;
           } else if (root.key < key && root.right != null) {
               root.right = deleteKeyRec(root.right, key, null, null);
               return root;
           }

           // We reach here when root is the node
           // to be deleted.

           // If one of the children is empty
           if (root.left == null)
               return root.right;

            else if (root.right == null)
               return root.left;


           // If both children exist
           else if (root.left != null && root.right != null){
               ckrParent = root;

               // Find successor
               ckr1 = root.right;

               while (ckr1.left != null) {

                   ckrParent = ckr1;
                   ckr1 = ckr1.left;
               }

               // Delete successor. Since successor
               // is always left child of its parent
               // we can safely make successor's right
               // right child as left of its parent.
               // If there is no succ, then assign
               // succ->right to succParent->right
               if (ckrParent != root)
                   ckrParent.left = ckr1.right;
               else
                   ckrParent.right = ckr1.right;

               // Copy Successor Data to root
               root.key = ckr1.key;

               return root;
           }
       }
       return root;
   }
}
