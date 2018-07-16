package snippet;

import java.util.*;

public class HuffmanDecoding {

    // input is an array of frequencies, indexed by character code
    public static Nod buildTree(int[] charFreqs) {

        PriorityQueue<Nod> trees = new PriorityQueue<Nod>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], (char) i));

        assert trees.size() > 0;

        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
            Nod a = trees.poll();
            Nod b = trees.poll();

            // put into new node and re-insert into queue
            trees.offer(new HuffmanNode(a, b));
        }

        return trees.poll();
    }

    public static Map<Character, String> mapA = new HashMap<Character, String>();

    public static void printCodes(Nod tree, StringBuffer prefix) {

        assert tree != null;

        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf) tree;

            // print out character, frequency, and code for this leaf (which is just the prefix)
            //System.out.println(leaf.data + "\t" + leaf.frequency + "\t" + prefix);
            mapA.put(leaf.data, prefix.toString());

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode) tree;

            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);

            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner("ABACA");

        String test = input.next();

        // we will assume that all our characters will have
        // code less than 256, for simplicity
        int[] charFreqs = new int[256];

        // read each character and record the frequencies
        for (char c : test.toCharArray())
            charFreqs[c]++;

        // build tree
        Nod tree = buildTree(charFreqs);

        // print out results
        printCodes(tree, new StringBuffer());
        StringBuffer s = new StringBuffer();

        for (int i = 0; i < test.length(); i++) {
            char c = test.charAt(i);
            s.append(mapA.get(c));
        }

        //System.out.println(s);
        Decoding d = new Decoding();
        d.decode(s.toString(), tree);

    }
}

abstract class Nod implements Comparable<Nod> {
    public int frequency; // the frequency of this tree
    public char data;
    public Nod left, right;

    public Nod(int freq) {
        frequency = freq;
    }

    // compares on the frequency
    public int compareTo(Nod tree) {
        return frequency - tree.frequency;
    }
}

class HuffmanLeaf extends Nod {


    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
}

class HuffmanNode extends Nod {

    public HuffmanNode(Nod l, Nod r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }

}

class Decoding {

    void decode(String s, Nod root) {

        assert root != null;
        if (s.isEmpty()) return;
        for(int i=0;i<s.length();){
            Nod curr = root;
            while(!(curr instanceof HuffmanLeaf) ){
                char c = s.charAt(i++);
                if(c=='0') curr = curr.left;
                else if (c=='1') curr = curr.right;
            }
            System.out.print(curr.data);
        }
    }
}