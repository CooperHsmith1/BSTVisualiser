package main.bst;


public class BST {
    TreeNode root;

    public TreeNode insertRecursion(TreeNode current, int value)
    {
        if (root == null){
            root = new TreeNode(value);
        }
        else if (value < root.value)
        {
            current.left = insertRecursion(current.left, value);

        }
        else if (value > root.value)
        {
            current.right = insertRecursion(current.right, value);
        }
        return current;
    }
    public void insert(int value){
        root = insertRecursion(root, value);
    }

    public TreeNode deleterecursion(TreeNode node, int value)
    {
        if(node == null) {
            return null;
        }
        if (value < node.value) {
            node.left = deleterecursion(node.left, value);
        }
        else if (value > node.value) {
            node.right = deleterecursion(node.right, value);
        }
        else{
            if(node.left == null && node.right == null){
                return null;
            }
            if (node.left == null){
                return node.right;

            }
            if (node.right == null){
                return node.left;
            }
        }
        return node;
    }

}
