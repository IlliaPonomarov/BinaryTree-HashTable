import BinaryTree.BinarySearchTree;
import BinaryTree.DAO.BinarySearchTreeDAO;
import BinaryTree.DAO.User;

import java.util.Map;

public class Main {

    public static Map<Integer, User> users;
    public static BinarySearchTree binarySearchTree = new BinarySearchTree();

    public static void main(String[] args) {

        System.out.println("Binary Search Tree: ");
        System.out.println("BST Insert:");
        System.out.println(getTestInsertForBST());


        System.out.println("BST Search:");
        System.out.println(searchByKeyTestBST());

        System.out.println("BST Delete:");
        System.out.println(getTestIDeleteForBST());
    }

    //***************************
    //
    //  BINARY SEARCH TREE TEST
    //
    //***************************

    //Insert Test
    public static BinarySearchTree inserBST() {

        users = BinarySearchTreeDAO.getData();

        for (Map.Entry<Integer, User> userss : users.entrySet())
            binarySearchTree.insert(userss.getKey());

        return binarySearchTree;
    }

    public static double getTestInsertForBST() {


        for (int i = 0; i < 20; i++)
            inserBST();

        int count = 1000;

        while (true) {
            long begin = System.nanoTime();

            for (int i = 0; i < count; i++)
                inserBST();

            long end = System.nanoTime();

            if ((end - begin) < 1000000000) {
                count *= 1000;
                continue;
            }
            return (double) (end - begin) / count;
        }

    }

    //Delete Test
    public static void deleteBST() {

        BinarySearchTree bst = new BinarySearchTree();

        Map<Integer, User> user = BinarySearchTreeDAO.getData();

        for (Map.Entry<Integer, User> users : user.entrySet())
            bst.deleteKey(users.getKey());

    }

    public static double getTestIDeleteForBST() {
        for (int i = 0; i < 20; i++)
            deleteBST();

        int count = 1000;

        while (true) {
            long begin = System.nanoTime();

            for (int i = 0; i < count; i++)
                deleteBST();

            long end = System.nanoTime();

            if ((end - begin) < 1000000000) {
                count *= 1000;
                continue;
            }
            return (double) (end - begin) / count;
        }

    }

    //Search Test
    public static double searchByKeyTestBST() {

        for (int i = 0; i < 20; i++)
            binarySearchTree.searchByKey((int) Math.random() * 1000);

        int count = 1000;

        while (true) {
            long begin = System.nanoTime();

            for (int i = 0; i < count; i++)
                binarySearchTree.searchByKey((int) Math.random() * 1000);

            long end = System.nanoTime();

            if ((end - begin) < 1000000000) {
                count *= 1000;
                continue;
            }
            return (double) (end - begin) / count;
        }
    }


}
