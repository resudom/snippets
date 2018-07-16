package snippet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IVANMO on 26/7/2017.
 */
public class AverageTreeLevel {


    public static void main(String[] args) {

    }

    public static List<Double> averageOfLevels(TreeNode root) {

        ArrayList<Double> result = new ArrayList<>();
        if (root == null) return result;

        int count = 0;
        double accum = 0;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addFirst(root);
        q.addFirst(null);
        while (!q.isEmpty()) {


            TreeNode node = q.removeLast();
            if (node == null) {
                result.add(Double.valueOf(accum / count));
                count = 0;
                accum = 0;
                if (!q.isEmpty()) q.addFirst(null);
            } else {
                count++;
                accum += node.val;
                if (node.left != null) q.addFirst(node.left);
                if (node.right != null) q.addFirst(node.right);
            }
        }
        return result;
    }

    public static List<Double> averageOfLevelsItr(TreeNode node) {

        int level = 0;
        ArrayList<Double> sum = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();
        ArrayList<Double> res = new ArrayList<>();
        processTree(node, sum, count, 0);

        int levelNum = count.size();
        for(int i=0; i<levelNum; i++){
            res.add(sum.get(i)/count.get(i));
        }
        return res;
    }

    public static void processTree(TreeNode node, List<Double> sum, List<Integer> count, int level) {

        if (node == null) return;

        if (level == count.size()) {
            count.add(1);
            sum.add(Double.valueOf(node.val));
        } else {
            count.set(level, count.get(level) + 1);
            sum.set(level, sum.get(level) + node.val);
        }
        processTree(node.left, sum, count, level+1);
        processTree(node.right, sum, count, level+1);
    }
}
