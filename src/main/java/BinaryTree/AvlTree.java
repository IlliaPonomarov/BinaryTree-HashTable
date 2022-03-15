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
    Node minValueNode(Node node)
    {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;

        return current;
    }
    public void deleteNode(int key){
        root = deleteNodeRec(root, key);
    }
    Node deleteNodeRec(Node root, int key)
    {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;

        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if (key < root.key)
            root.left = deleteNodeRec(root.left, key);

            // If the key to be deleted is greater than the
            // root's key, then it lies in right subtree
        else if (key > root.key)
            root.right = deleteNodeRec(root.right, key);

            // if key is same as root's key, then this is the node
            // to be deleted
        else
        {

            // node with only one child or no child
            if ((root.left == null) || (root.right == null))
            {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                // No child case
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else // One child case
                    root = temp; // Copy the contents of
                // the non-empty child
            }
            else
            {

                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                Node temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.key = temp.key;

                // Delete the inorder successor
                root.right = deleteNodeRec(root.right, temp.key);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = max(height(root.left), height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
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

    void inorderRec(Node root){
        if (root == null)
            return;

        inorderRec(root.left);
        System.out.print(" " + root.key + " (" + root.height + ")\t");
        inorderRec(root.right);
    }
}
