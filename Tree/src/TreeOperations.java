import com.sun.source.tree.Tree;

public class TreeOperations {

    public static void main(String[] args) {
        TreeOperations to = new TreeOperations();
        TreeNode tree = null;
        tree = to.insertBST(tree, 4);
        tree = to.insertBST(tree, 3);
        tree = to.insertBST(tree, 2);
        tree = to.insertBST(tree, 14);
        tree = to.insertBST(tree, 9);
        tree = to.insertBST(tree, 6);
        to.inorderTraversal(tree);
        int sum = to.rangeSumBST(tree,3,14);
        System.out.println("range sum:"+sum);
        tree = null;
        tree = new TreeNode(10);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(6);
        int check = to.checkTree(tree);
        System.out.println(check);

        System.out.println("########################");
        tree = to.insertBST(null,4);
        tree = to.insertBST(tree,2);
        tree = to.insertBST(tree,1);
        tree = to.insertBST(tree,3);
        tree = to.insertBST(tree,6);
        tree = to.insertBST(tree,5);
        tree = to.insertBST(tree,7);
        to.inorderTraversal(tree);

        TreeNode[] split  = to.splitBST(tree,2);
        System.out.println("tree split after the it.");
        to.inorderTraversal(split[0]);
        System.out.println("tree to traversal:");
        to.inorderTraversal(split[1]);
    }
    TreeNode[] splitBST(TreeNode tree,int target){
        if(tree == null) return new TreeNode[] {null,null};
        if(tree.val <= target){
            TreeNode[] rightSplit = splitBST(tree.right, target);
            tree.right = null;
            return new TreeNode[]{tree, rightSplit[1]};
        }else{
            TreeNode[] leftSplit = splitBST(tree.left,target);
            tree.left = null;
            return new TreeNode[] {leftSplit[0],tree};
        }
    }
    int checkTree(TreeNode tree){
        if(tree != null){
            int left = checkTree(tree.left);
            int right = checkTree(tree.right);
            if(tree.val == (left + right))
                return tree.val;
            else
                return -1;
        }
        return -1;
    }
    public int rangeSumBST(TreeNode tree, int low, int high) {
        if(tree != null){
            int leftSum = rangeSumBST(tree.left,low,high);
            int rightSum = rangeSumBST(tree.right,low,high);
            if(tree.val >= low && tree.val <= high)
                return leftSum+tree.val+rightSum;
            return  rightSum;
        }
        return 0;
    }

    void inorderTraversal(TreeNode tree) {
        if (tree == null)
            return;
        inorderTraversal(tree.left);
        System.out.println(tree.val);
        inorderTraversal(tree.right);
    }

    TreeNode insertBST(TreeNode tree, int val) {
        TreeNode newNode =   new TreeNode(val);
        TreeNode head = tree;
        if (tree == null) {
            return newNode;
        } else {
            tree = correctInsertNode(tree,val);
            System.out.println("tree data:"+tree.val);
            if(tree != null && tree.val > val){
                tree.left = newNode;
            }else if(tree != null && tree.val < val)
                tree.right = newNode;
        }
        return head;
    }

    TreeNode correctInsertNode(TreeNode tree, int val) {
        if(tree != null) {
            if (tree.left == null && tree.right == null) return tree;
            if (tree.val > val) {
                if(tree.left!= null)
                     return correctInsertNode(tree.left, val);
                else
                    return tree;
            } else{
                if(tree.right !=null)
                    return correctInsertNode(tree.right, val);
                else
                    return tree;
            }

        }
        return null;
    }
}
