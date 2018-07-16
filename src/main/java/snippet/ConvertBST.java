package snippet;

import java.util.*;

public class ConvertBST {

    /*Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed
     to the original key plus sum of all keys greater than the original key in BST.*/
    static int sum;


    static public TreeNode convertBST(TreeNode root) {

        if (root == null) return null;

        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }

    public static int getMinimumDifference(TreeNode root) {

        int minDiff = Integer.MAX_VALUE;
        int prev = 0;
        int currDiff;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;

        while(true){
            if(curr!=null){
                stack.addLast(curr);
                curr = curr.left;
            }
            else{
                if(stack.isEmpty())
                    break;
                curr = stack.removeLast();
                if (curr!=null) {

                    currDiff = curr.val - prev;
                    if(currDiff<minDiff){
                        minDiff = currDiff;
                    }
                    prev = curr.val;
                    curr = curr.right;
                }


            }
        }
        return minDiff;
    }

    public static void main(String[] args) {

        int a = 7;
        int b = 9;

        a = a^b;
        b = a^b;
        a = a^b;

        int x = 9;
        int y = 10;

        while (y != 0)
        {
            // carry now contains common set bits of x and y
            int carry = x & y;

            // Sum of bits of x and y where at least one of the bits is not set
            x = x ^ y;

            // Carry is shifted by one so that adding it to x gives the required sum
            y = carry << 1;
        }
        System.out.println(x);


        int num = 38;
        while (num>=10) {
            int sum = 0;
            while(num>0){
                sum += num%10;
                num /= 10;
            }
            num = sum;
        }

        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};

        HashSet<Integer> setNums1 = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for(int num1: nums1){
            setNums1.add(Integer.valueOf(num1));
        }
        for(int num2: nums2){
            if(setNums1.contains(num2))
                result.add(num2);
        }
        result.toArray(new Integer[result.size()]);

        HashMap<String, Integer> map = new HashMap<>();
        map.putIfAbsent("",0);


        String ransomNote = "aa";
        String magazine = "ab";

        boolean res = true;

        HashMap<Character, Integer> letterMap = new HashMap<>();
        for(char c: magazine.toCharArray()){
            Integer number = letterMap.putIfAbsent(c, 1);
            if(number!=null)
                letterMap.put(c, letterMap.get(c) +1 );
        }

        for(char c: ransomNote.toCharArray()){

            if(!letterMap.containsKey(c)) {
                res = false;
                break;
            }
            Integer number = letterMap.get(c);
            number--;
            if(number==0)
                letterMap.remove(c);
            else
                letterMap.put(c, number);
        }

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n1.right = n3;
        n1.left = null;
        n3.left = n2;

        getMinimumDifference(n1);
    }
}
