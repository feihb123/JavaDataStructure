package DateStructure.tree;

/**
 * 求树最高最低深度
 * @author datacharm.cn
 */
public class TreeDepth {

    /**
     * 求二叉树最大深度
     * @param treeNode
     * @return 最大深度
     */
    public int maxDepth(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        if(treeNode.left == null && treeNode.right == null){
            return 1;
        }
        int left = maxDepth(treeNode.left);
        int right = maxDepth(treeNode.right);

        return Math.max(left,right)+1;
    }
    /**
     * 求二叉树最小深度
     * @param treeNode
     * @return 最小深度
     */
    public int minDepth(TreeNode treeNode){
        if(treeNode == null){
            return Integer.MAX_VALUE;
        }
        if(treeNode.left == null && treeNode.right == null){
            return 1;
        }
        int left = minDepth(treeNode.left);
        int right = minDepth(treeNode.right);

        return Math.min(left,right)+1;
    }

    /**
     * 判断是否是平衡二叉树
     * @param treeNode
     * @return  -1 不是平衡二叉树,其他是
     */
    public int balanceTree(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        if(treeNode.left == null && treeNode.right == null){
            return 1;
        }
        int left = balanceTree(treeNode.left);
        int right = balanceTree(treeNode.right);
        //左右子树不平衡或本节点不平衡返回-1
        if(left == -1 || right == -1 ||Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        TreeDepth treeDepth = new TreeDepth();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t2.left = t3;
        t3.left = t4;
        t1.right = t5;
        t5.right = t6;
        int max = treeDepth.maxDepth(t1);
        System.out.println(max);
        int min = treeDepth.minDepth(t1);
        System.out.println(min);
        boolean balance = treeDepth.balanceTree(t1) != -1;
        System.out.println("是否平衡："+balance);
    }


}
