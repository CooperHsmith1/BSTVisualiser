package main.bst;


public class BST {
    TreeNode root;

    public TreeNode insertRecursion(TreeNode current, int value)
    {
        if (current == null){
            current = new TreeNode(value);
        }
        else if (value < current.value)
        {
            current.left = insertRecursion(current.left, value);

        }
        else if (value > current.value)
        {
            current.right = insertRecursion(current.right, value);
        }
        return current;
    }
    public void insert(int value){
        root = insertRecursion(root, value);
    }
    public int find(TreeNode node){
        while (node.left != null){
            node = node.left;
        }
        return node.value;
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
            int smallest_value = find(node.right);
            node.value = smallest_value;
            node.right = deleterecursion(node.right, smallest_value);
        }
        return node;
    }
    public void delete(int value){
        root = deleterecursion(root, value);
    }

}
