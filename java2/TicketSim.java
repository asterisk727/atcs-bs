import java.util.ArrayList;
import java.util.Scanner;

public class TicketSim {
    
    private static Scanner stdin;
    private static ArrayList<String> line = new ArrayList<>();
    private static ArrayList<String> waitlist = new ArrayList<>();

    private static int firstEmpty(String[] seats) {
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private static boolean sellSeat(String[] seats, ArrayList<String> line, ArrayList<String> waitlist) {
        if (firstEmpty(seats) == -1) {
            waitlist.add(line.remove(0));
            return false;
        }
        else {
            seats[firstEmpty(seats)] = line.remove(0);
            return true;
        }
    }

    private static boolean cancelSeat(String[] seats, int idx, ArrayList<String> waitlist) {
        seats[idx] = null;
        if (!waitlist.isEmpty()) {
            seats[idx] = waitlist.remove(0);
            return true;
        }
        return false;
    }

    private static void printSeatMap(String[] seats) {
        for (int i = 0; i < seats.length; i++) {
            System.out.println("i:" + (seats[i] != null ? seats[i] : "[empty]"));
        }
    }

    private static double seatFillPercent(String[] seats) {
        int taken = 0;

        for (int i = 0; i < seats.length; i++) {
            taken += (seats[i] != null) ? 1 : 0;
        }

        return (double)(taken * 100) / seats.length;
    }

    public static void main(String[] args) {
        stdin = new Scanner(System.in);
        
        int arraySize = stdin.nextInt();
        String[] seats = new String[arraySize];


        while (true) {
            System.out.println("1) Arrive <name>");
            System.out.println("2) Sell next");
            System.out.println("3) Cancel seat <index>");
            System.out.println("4) Status");
            System.out.println("5) Quit");
            
            int choice = stdin.nextInt();

            switch(choice){
                case 1:
                    String input = stdin.nextLine();
                    line.add(input);
                case 2:
                    sellSeat(seats, line, waitlist);
                case 3:
                    cancelSeat(seats, choice, waitlist);
                case 5:
                    return;
            }

            printSeatMap(seats);
            System.out.println("Filled: " + seatFillPercent(seats) + " Line: " + line.size() + " Waitlist: " + waitlist.size());
        }
    }
}