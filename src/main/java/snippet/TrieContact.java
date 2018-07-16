package snippet;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TrieContact {

    private static final Scanner scanner = new Scanner(System.in);
    private static Trie trie = new Trie();

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];

            String contact = opContact[1];

            if(op.equals("add")) trie.add(contact);
            else if(op.equals("find")) System.out.println(trie.find(contact));
        }

        scanner.close();
    }




}

class Trie {

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.add("hack");
        trie.add("hackerrank");
        trie.add("fuck");
        trie.find("hack");
        trie.find("hak");
        trie.find("hacker");
    }

    private HashMap <Character, Trie> children = new HashMap<>();
    private boolean termFlag;
    private int wordCount;

    public void add(String key) {

        int length = key.length();
        Trie currTrie = this;
        HashMap<Character, Trie> currChildren = children;
        for(int level=0; level<length; level++){

            Character currChar = key.charAt(level);
            currTrie = currChildren.get(currChar);
            if(currTrie==null){
                currTrie = new Trie();
                currChildren.put(currChar, currTrie);
            }
            currTrie.wordCount++;
            currChildren = currTrie.children;
        }

        currTrie.termFlag = true;
    }

    public int find(String key){

        int findRes = 0;
        int length = key.length();
        HashMap<Character, Trie> currChildren = children;
        for(int level=0; level< length; level++){

            Character currChar = key.charAt(level);
            Trie currTrie = currChildren.get(currChar);
            if(currTrie==null) {
                findRes = 0;
                break;
            }
            findRes = currTrie.wordCount;
            currChildren = currTrie.children;
        }
        return findRes;
    }


}
