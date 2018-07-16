package snippet;


import java.util.LinkedList;

/**
 * Created by IVANMO on 25/7/2017.
 */
public class TreeMerge {


    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {

        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees1(t1.left, t2.left);
        t2.right = mergeTrees1(t1.right, t2.right);
        return t1;
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null) return t2;
        LinkedList<TreeNode[]> stack = new LinkedList<>();
        stack.addLast(new TreeNode[]{t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] currPair = stack.removeLast();
            if (currPair[0] == null || currPair[1] == null)
                continue;
            currPair[0].val += currPair[1].val;
            if (currPair[0].left == null) {
                currPair[0].left = currPair[1].left;
            } else {
                stack.addLast(new TreeNode[]{currPair[0].left, currPair[1].left});
            }
            if (currPair[0].right == null) {
                currPair[0].right = currPair[1].right;
            } else {
                stack.addLast(new TreeNode[]{currPair[0].right, currPair[1].right});
            }
        }
        return t1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}