import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class WordStats {
    private static final String[] stopWords = {"the", "a", "an", "and", "of", "to", "in", "it", "is", "that"};

    private static Scanner stdin;
    private static ArrayList<String> tokens;
    private static ArrayList<String> uniqueTokens;
    private static int[] count;

    private static String normalizeString(String input) 
    {
        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++)
        {
            if (!(Character.isLetter(input.charAt(i)) || input.charAt(i) == ' ')) {
                input = input.substring(0, i) + ' ' + input.substring(i + 1);
            }
        }
        return input;
    }

    private static void tokenizeString(String input)
    {
        tokens = new ArrayList<String>(Arrays.asList(input.split(" ")));
    }

    private static void uniqueTokens() {
        uniqueTokens = new ArrayList<>();

        for (int i = 0; i < tokens.size(); i++) {
            if (!uniqueTokens.contains(tokens.get(i))) {
                uniqueTokens.add(tokens.get(i));
            }
        }
    }

    private static void countTokens() {
        count = new int[uniqueTokens.size()];

        for (int i = 0; i < tokens.size(); i ++) {
            count[uniqueTokens.indexOf(tokens.get(i))]++;
        }
    }

    private static void sortTokens() {
        for (int i = 0; i < uniqueTokens.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < uniqueTokens.size(); j++) {
                if (count[j] > count[maxIndex] ||
                    (count[j] == count[maxIndex] && uniqueTokens.get(j).compareTo(uniqueTokens.get(maxIndex)) < 0)) {
                    maxIndex = j;
                }
            }

            int tempCount = count[i];
            count[i] = count[maxIndex];
            count[maxIndex] = tempCount;

            Collections.swap(uniqueTokens, i, maxIndex);
        }

        for (int i = 0; i < Math.min(uniqueTokens.size(), 10); i++) {
            System.out.println("key: " + uniqueTokens.get(i) + ", value: " + count[i]);
        }
    }

    public static void main(String[] args) {
        stdin = new Scanner(System.in);

        String input = stdin.nextLine();
        
        input = normalizeString(input);
        tokenizeString(input);
        uniqueTokens();
        countTokens();
        sortTokens();

        int nonStopCount = 0;
        for (int i = 0; i < uniqueTokens.size(); i++) {
            for (int j = 0; j < stopWords.length; j++) {
                if (uniqueTokens.get(i).equalsIgnoreCase(stopWords[j])) {
                    continue;
                }
                nonStopCount++;
            }
        }

        System.out.println("type-token ratio: " + String.format("%.2f", (double)nonStopCount / tokens.size()));
    }
}
