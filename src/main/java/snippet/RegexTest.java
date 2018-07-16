package snippet;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {

        String PAT1 = "(.+)\\[(.*?)\\]\\.(.+)";
        String PAT2 = "(.+)\\[(.+?)\\]\\[(.+?)\\]\\.(.+)";

        String testString = "TableName[index].AttributeName";

        Pattern pattern = Pattern.compile(PAT2);
        Matcher matcher = pattern.matcher(testString);

        System.out.println((matcher.groupCount()));

        if (matcher.matches()) {
            System.out.println("Group 0: " + matcher.group(0));
            System.out.println("Group 1: " + matcher.group(1));
            System.out.println("Group 2: " + matcher.group(2));
            System.out.println("Group 3: " + matcher.group(3));
//            System.out.println("Group 4: " + matcher.group(4));
        }

        String requestId = "MASS_562662678772";
        String transactionId = requestId.substring(requestId.indexOf("_") + 1);
        System.out.println(transactionId);

        String tnmInfo = "name1:value1|name2:value2|name3:value3";
        String[] chars = tnmInfo.split("\\|");
        System.out.println(Arrays.toString(chars));

        String[] charNameValue = chars[0].split(":");
        System.out.println(Arrays.toString(charNameValue));


        final int mostNegative = Integer.MAX_VALUE+1;
        final int number = 0x7FFFFFFF;
        final int negated = Math.abs(mostNegative);
        if (negated > 0) {
            System.out.println("No positive equivalent of Integer.MIN_VALUE");
        }
    }
}

