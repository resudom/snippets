package snippet;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;

/**
 * Created by IVANMO on 25/7/2017.
 */
public class RowAlphabetCheck {

    static HashMap<Integer,Set<? extends Character>> rowMap = new HashMap<>();
    static {
        Character[] arrayRow1 = new Character[]{'q','w','e','r','t','y','u','i','o','p'};
        Character[] arrayRow2 = new Character[]{'a','s','d','f','g','h','j','k','l'};
        Character[] arrayRow3 = new Character[]{'z','x','c','v','b','n','m'};
        HashSet<Character> setRow1 = new HashSet<>(Arrays.asList(arrayRow1));
        HashSet<Character> setRow2 = new HashSet<>(Arrays.asList(arrayRow2));
        HashSet<Character> setRow3 = new HashSet<>(Arrays.asList(arrayRow3));

        rowMap.put(1, setRow1);
        rowMap.put(2, setRow2);
        rowMap.put(3, setRow3);
    }

    private static HashMap<String,Set<? extends Character>> createWordMap(String[] words) {
        HashMap<String,Set<? extends Character>> wordMap = new HashMap<>();
        for(int i=0; i<words.length; i++){
            HashSet<Character> wordChars = new HashSet<Character>(Arrays.asList(words[i].toLowerCase()
                    .chars().mapToObj(c -> (char)c).toArray(Character[]::new)));
            wordMap.put(words[i], wordChars);
        }
        return wordMap;
    }

    static public String[] findWords(String[] words) {
        HashMap<String,Set<? extends Character>> wordMap = createWordMap(words);
        ArrayList<String> result = new ArrayList<>();

        for(Map.Entry<String,Set<? extends Character>> wordEntry: wordMap.entrySet()){

            for(Set rowSet: rowMap.values()){

                if(rowSet.containsAll(wordEntry.getValue())){
                    result.add(wordEntry.getKey());
                }
            }
        }

        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {
        String s = new String ();
        char[] chars = s.toCharArray();
        int length = chars.length;
        String [] words = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(findWords(words)));
        int[] intArr = new int[10];
        for(int num: intArr){
            System.out.println(num);
        }

        int n = 15;
        String fizz = "Fizz";
        String buzz = "Buzz";
        ArrayList<String> result = new ArrayList<>();
        for(int i=1; i<=n; i++){
            String element = null;
            if(i%3==0) element = fizz;
            if(i%5==0) element += buzz;
            if(null==element) element = String.valueOf(i);
            element.isEmpty();
            result.add(element);
        }
        System.out.println(result.toString());
    }
}
