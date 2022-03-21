import BinaryTree.BinarySearchTree;
import BinaryTree.SplayTree;
import DAO.HashDao;
import DAO.TreeDAO;
import HashTables.ChainHash;
import HashTables.LinearHash;

import java.util.Date;
import java.util.Map;

public class Main {

    protected static Map<Integer, String> check;

    
    protected static BinarySearchTree binarySearchTree = new BinarySearchTree();
    protected static SplayTree splayTree = new SplayTree();
    protected static ChainHash chainHash = new ChainHash(1000, 0.75);
    protected static LinearHash linearHash = new LinearHash(2001, 0.75);


    public static void main(String[] args) throws InterruptedException {


        treeTest();
        hashTablesTest();
       // chainHash.getAll();

    }


    public static void treeTest(){

        System.out.println("Binary Search Tree 1000 elements");
        long start = System.currentTimeMillis();
        System.out.println("BST Insert: " + getTestOfInsertForBST(1000) + "  " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println("BST Search by Key: " + searchByKeyTestBST(1000)+ "  " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println("BST Delete: " + getTestIDeleteForBST(1000) + "  " + (System.currentTimeMillis() - start));

        System.out.println();
        System.out.println();

        System.out.println("Splay Tree: " );

        start = System.currentTimeMillis();
        System.out.println("Insert: " + getTestOfInsertForSplay(1000) + "  " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println("Search: " + searchByKeyTestSplay(1000) + "  " + (System.currentTimeMillis() - start));

        System.out.println();
        System.out.println();


        // 1 000 000

        System.out.println("Binary Search Tree 1 000 000 elements");
        start = System.currentTimeMillis();
        System.out.println("BST Insert: " + getTestOfInsertForBST(1000000) + "  " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println("BST Search by Key: " + searchByKeyTestBST(1000000)+ "  " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println("BST Delete: " + getTestIDeleteForBST(1000000) + "  " + (System.currentTimeMillis() - start));

        System.out.println();
        System.out.println();

        System.out.println("Splay Tree: " );

        start = System.currentTimeMillis();
        System.out.println("Insert: " + getTestOfInsertForSplay(1000000) + "  " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println("Search: " + searchByKeyTestSplay(1000000) + "  " + (System.currentTimeMillis() - start));

        System.out.println();
        System.out.println();

        // 10 000 000

        System.out.println("Binary Search Tree 10 000 000 elements");
        start = System.currentTimeMillis();
        System.out.println("BST Insert: " + getTestOfInsertForBST(10000000) + "  " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println("BST Search by Key: " + searchByKeyTestBST(10000000)+ "  " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println("BST Delete: " + getTestIDeleteForBST(10000000) + "  " + (System.currentTimeMillis() - start));

        System.out.println();
        System.out.println();

        System.out.println("Splay Tree: " );

        start = System.currentTimeMillis();
        System.out.println("Insert: " + getTestOfInsertForSplay(10000000) + "  " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println("Search: " + searchByKeyTestSplay(10000000) + "  " + (System.currentTimeMillis() - start));

        System.out.println();
        System.out.println();

    }


    public static void hashTablesTest() throws InterruptedException {
        Date date = new Date();
        System.out.println();

        // 1000
        long sart1 = System.currentTimeMillis();
        System.out.println("Chain Hash Test (1000 elements):");
        System.out.println("Insert: " + getTimeInsertChainHash(1000) + "   " + (System.currentTimeMillis() - sart1)  + "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Search by key: " + getTimeSearchByKeyChainHash(1000) + "   " + (System.currentTimeMillis() - sart1) + "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Delete by key: " + getTimeDeleteByKeyChainHash(1000) + "  " + (System.currentTimeMillis() - sart1) + "m/s");

        System.out.println();
        Thread.sleep(2000);
        System.out.println("Linear Hash Test: (1000 elements) ");

        sart1 = System.currentTimeMillis();
        System.out.println("Insert: " + getTimeInsertLinearHash(1000)  + "  " + (System.currentTimeMillis() - sart1) +  "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Search by key: " + getTimeSearchByKeyLinearHash(1000)  + "  " + (System.currentTimeMillis() - sart1) + "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Delete by key: " + getTimeDeleteByKeyLinearHash(1000)  +  "  " + (System.currentTimeMillis() - sart1) + "m/s");




        // 1 000 000
        sart1 = System.currentTimeMillis();
        System.out.println();
        System.out.println();
        System.out.println("Chain Hash Test (1 000 000 elements):");
        System.out.println("Insert: " + getTimeInsertChainHash(1000000)  + "  " + (System.currentTimeMillis() - sart1) + "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Search by key: " + getTimeSearchByKeyChainHash(1000000)  + "  " + (System.currentTimeMillis() - sart1) + "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Delete by key: " + getTimeDeleteByKeyChainHash(1000000)  + "  " + (System.currentTimeMillis() - sart1) + "m/s");

        System.out.println();
        Thread.sleep(2000);
        System.out.println("Linear Hash Test: (1 000 000 elements) ");

        sart1 = System.currentTimeMillis();
        System.out.println("Insert: " + getTimeInsertLinearHash(1000000)   + "  " + (System.currentTimeMillis() - sart1) + "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Search by key: " + getTimeSearchByKeyLinearHash(1000000)  + "  "   + (System.currentTimeMillis() - sart1) + "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Delete by key: " + getTimeDeleteByKeyLinearHash(1000000)  + "  "  + "  " + (System.currentTimeMillis() - sart1) + "m/s");


        // 10 000 000

        sart1 = System.currentTimeMillis();
        System.out.println("Chain Hash Test (10 000 000 elements):");
        System.out.println("Insert: " + getTimeInsertChainHash(10000000)  + "  " + (System.currentTimeMillis() - sart1) + "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Search by key: " + getTimeSearchByKeyChainHash(10000000)  + "  " + (System.currentTimeMillis() - sart1) + "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Delete by key: " + getTimeDeleteByKeyChainHash(10000000)  + "  " + (System.currentTimeMillis() - sart1) + "m/s");

        System.out.println();
        Thread.sleep(2000);
        System.out.println("Linear Hash Test: (10 000 000 elements) ");

        sart1 = System.currentTimeMillis();
        System.out.println("Insert: " + getTimeInsertLinearHash(1000000)   + "  " + (System.currentTimeMillis() - sart1) + "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Search by key: " + getTimeSearchByKeyLinearHash(1000000)  + "  "   + (System.currentTimeMillis() - sart1) + "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Delete by key: " + getTimeDeleteByKeyLinearHash(1000000)  + "  "  + "  " + (System.currentTimeMillis() - sart1) + "m/s");

    }

    //***************************************************
    //
    //  BINARY SEARCH TREE TEST , FIRST IMPLEMENTATION
    //
    //**************************************************


    //Insert Test
    public static BinarySearchTree insertBST() {

        check = TreeDAO.getData();

        for (Map.Entry<Integer, String> userss : check.entrySet())
            binarySearchTree.insert(userss.getKey());

        return binarySearchTree;
    }

    public static String getTestOfInsertForBST(int count) {

        for (int i = 0; i < 20; i++)
            insertBST();


        for (int i = 0; i < count; i++)
                insertBST();

            return " ";
    }

    //Delete Test
    public static void deleteBST() {

        BinarySearchTree bst = new BinarySearchTree();

        Map<Integer, String> user = TreeDAO.getData();

        for (Map.Entry<Integer, String> users : user.entrySet())
            bst.deleteByKey(users.getKey());

    }

    public static String getTestIDeleteForBST(int count) {
        for (int i = 0; i < 20; i++)
            deleteBST();

            for (int i = 0; i < count; i++)
                deleteBST();


            return " ";

    }

    //Search Test
    public static String searchByKeyTestBST(int count) {

        for (int i = 0; i < 20; i++)
            binarySearchTree.searchByKey((int) Math.random() * 1000);

            for (int i = 0; i < count; i++)
                binarySearchTree.searchByKey((int) Math.random() * 1000);

            return " ";
    }

    //*************************************
    //
    //     Splay TREE TEST
    //
    //*************************************


    //Insert Test
    public static SplayTree insertSplayTree() {

        check = TreeDAO.getData();

        for (Map.Entry<Integer, String> userss : check.entrySet())
            splayTree.insert(userss.getKey());

        return splayTree;
    }

    public static String getTestOfInsertForSplay(int count) {

        for (int i = 0; i < 20; i++)
            insertSplayTree();


        for (int i = 0; i < count; i++)
            insertSplayTree();

        return " ";
    }

   //Search Test
   //Search Test
   public static String searchByKeyTestSplay(int count) {

       for (int i = 0; i < 20; i++)
           splayTree.searchByKey((int) Math.random() * 1000);

       for (int i = 0; i < count; i++)
           splayTree.searchByKey((int) Math.random() * 1000);

       return " ";
   }


    //**************************************
    //
    //             Linear Hash
    //
    //**************************************


    //insert chainhash
    public static LinearHash insertLinearHashTest(){

        String[] test = HashDao.getDataHash();


        for (int i = 0; i < test.length; i++)
            linearHash.insert(test[(int) Math.floor(Math.random() * 400)], (int) Math.floor(Math.random() * 500));

        return linearHash;

    }

    public static String getTimeInsertChainHash(int count){

        for (int i = 0; i < 20; i++)
            insertChainHashTest();


        for (int i = 0; i < count; i++) {
            insertChainHashTest();
        }



        return "";
    }


    //search
    public static LinearHash searchByKeyTestLinearHash(){

        String[] test = HashDao.getDataHash();


        for (int i = 0; i < test.length; i++)
            linearHash.searchByKey(test[(int) Math.random() * 500]);

        return linearHash;

    }

    public static String getTimeSearchByKeyLinearHash(int count){
        for (int i = 0; i < 20; i++)
            searchByKeyTestLinearHash();


        for (int i = 0; i < count; i++) {
            searchByKeyTestLinearHash();
        }

        return "";
    }

    //delete

    public static LinearHash deleteByKeyTestLinearHash(){

        String[] test = HashDao.getDataHash();


        for (int i = 0; i < test.length; i++)
            linearHash.deleteByKey(test[(int) Math.random() * 500]);

        return linearHash;

    }

    public static String getTimeDeleteByKeyLinearHash(int count){
        for (int i = 0; i < 20; i++)
           deleteByKeyTestLinearHash();



        for (int i = 0; i < count; i++) {
            deleteByKeyTestLinearHash();
        }


        return "";
    }

    //resize
//    public static Double resizeLinearHash(){
//        for (int i = 0; i < 20; i++)
//           linearHash.resize();
//
//        int count = 1000;
//
//        while (true) {
//            long begin = System.nanoTime();
//
//            for (int i = 0; i < count; i++)
//                linearHash.resize();
//
//            long end = System.nanoTime();
//
//            if ((end - begin) < 1000000000) {
//                count *= 1000;
//                continue;
//            }
//            return (double) (end - begin) / count;
//        }
//    }


    //***********************************
    //
    //          Chain Hash
    //
    //***********************************

    //insert linearHash
    public static ChainHash insertChainHashTest(){

        String[] test = HashDao.getDataHash();


        for (int i = 0; i < test.length; i++)
            chainHash.insertHash(test[(int) Math.random() * 500], (int) Math.random() * 1000);

        return chainHash;

    }

    public static String getTimeInsertLinearHash(int count){

        for (int i = 0; i < 20; i++)
            insertLinearHashTest();


        for (int i = 0; i < count; i++) {
            insertLinearHashTest();
        }


        return " ";
    }

    //search
    public static ChainHash searchByKeyTestChainHash(){

        String[] test = HashDao.getDataHash();


        for (int i = 0; i < test.length; i++)
            chainHash.getValueByKey(test[(int) Math.random() * 500]);

        return chainHash;

    }

    public static String getTimeSearchByKeyChainHash(int count){
        for (int i = 0; i < 20; i++)
            searchByKeyTestChainHash();



            for (int i = 0; i < count; i++)
                searchByKeyTestChainHash();

           return "";
    }

    //delete
    public static ChainHash deleteByKeyTestChainHash(){

        String[] test = HashDao.getDataHash();


        for (int i = 0; i < test.length; i++)
            chainHash.deleteByKey(test[(int) Math.random() * 500]);

        return chainHash;

    }

    public static String getTimeDeleteByKeyChainHash(int count){
        for (int i = 0; i < 20; i++)
            deleteByKeyTestChainHash();



            for (int i = 0; i < count; i++)
                deleteByKeyTestChainHash();

          return "";
    }

    //resize
//    public static Double resizeChainHash(){
//        for (int i = 0; i < 20; i++)
//            chainHash.resize();
//
//        int count = 1000;
//
//        while (true) {
//            long begin = System.nanoTime();
//
//            for (int i = 0; i < count; i++)
//                chainHash.resize();
//
//            long end = System.nanoTime();
//
//            if ((end - begin) < 1000000000) {
//                count *= 1000;
//                continue;
//            }
//            return (double) (end - begin) / count;
//        }
//    }

}
