public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return mirror(root.left,root.right);
    }

    boolean mirror(TreeNode tree1,TreeNode tree2){
        boolean flag = false;
        if(tree1 == null && tree2 == null) return true;
        if(tree1 != null && tree2 != null && tree1.val == tree2.val)
            flag = true;
        else if(tree1 == null || tree2 == null)
            return false;
        flag =  flag && mirror(tree1.left,tree2.right);
        return flag && mirror(tree1.right,tree2.left);

    }
    public static void main(String[] args){
        TreeNode tree = new TreeNode(1);
        TreeNode root = tree;
        tree.left = new TreeNode(2,null, new TreeNode(3));
        tree.right = new TreeNode(2,null,new TreeNode(3));

        SymmetricTree mirror = new SymmetricTree();
        boolean flag = mirror.isSymmetric(tree);
        System.out.println("flag:"+flag);
    }
}
