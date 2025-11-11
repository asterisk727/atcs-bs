import java.util.ArrayList;
import java.util.Scanner;

public class Roster {
    private static Scanner stdin;
    private static final int studentCount = 6;
    private static ArrayList<String> roster = new ArrayList<>(studentCount); // you fill it out
    private static int[] scores = new int[studentCount];

    private static int indexOf(ArrayList<String> list, String target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) {
                return i;
            }
        }
        return -1;
    }

    private static int maxScore(int[] arr) {
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    private static int maxIndex(int[] arr) {
        int max = -1;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    private static double average(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return (double) sum / arr.length;
    }

    private static void addCurve(int[] arr, int amount) {
        // how am I expected to add in place? int[] doesnt extend Object, its passed by value not reference

        for (int i = 0; i < scores.length; i++) {
            scores[i] = Math.min(100, scores[i] + amount);
        }
    }

    public static void main(String[] args) {
        stdin = new Scanner(System.in);

        while (true) {
            System.out.println("1) Print roster");
            System.out.println("2) Print scores as index:name -> score");
            System.out.println("3) Show best score and student");
            System.out.println("4) Show average score (double)");
            System.out.println("5) Apply a +5 curve (cap at 100)");
            System.out.println("6) Replace student name at index");
            System.out.println("7) Quit");
            
            int input = stdin.nextInt();

            switch(input){
                case 1:
                    for (int i = 0; i < roster.size(); i++) {
                        System.out.println(i + ":" + roster.get(i));
                    }
                case 2:
                    for (int i = 0; i < roster.size(); i++) {
                        System.out.println(i + ":" + roster.get(i) + " -> " + scores[i]);
                    }
                case 3:
                    System.out.println(maxIndex(scores) + ":" + roster.get(maxIndex(scores)) + " -> " + scores[maxIndex(scores)]);
                case 4:
                    System.out.println("Average score: " + average(scores));
                case 5:
                    addCurve(scores, 5);
                    System.out.println("Done!");
                case 6:
                    int index = stdin.nextInt();
                    String newName = stdin.nextLine();
                    roster.set(index, newName);
                    System.out.println("Done!");
                case 7:
                    System.out.println("Done!");
                    return;
            }
        }
    }
}
