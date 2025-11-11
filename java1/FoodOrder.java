import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class FoodOrder {
    private static Scanner stdin; // hahar
    private static ArrayList<MenuItem> menu = new ArrayList<>(Arrays.asList(new MenuItem("pizza", 8.50d), new MenuItem("burger", 6.00d), new MenuItem("salad", 5.25d)));

    private static double calaculteTotal(ArrayList<MenuItem> orderItems) {
        double total = 0;

        for (MenuItem item : orderItems) {
            total += item.price * item.count;
        }

        return total;
    }

    public static void printThankYou() {
        System.out.println("Thanks for ordering - enjoy your meal!");
    }

    private static double round(double in, int digits) {
        return Math.round((in * Math.pow(10, digits))) / Math.pow(10, digits);
    }

    public static void main(String[] args) {
        stdin = new Scanner(System.in);

        System.out.println("Welcome to Food Palace!\n\nMenu:");

        for (MenuItem item : menu) {
            System.out.println(item.name + " - " + item.price); // too lazy to pad with zeros
        }

        ArrayList<MenuItem> orderItems = new ArrayList<>();

        while(true) {
            System.out.println("What would you like to order?");

            String orderItem = stdin.next(); // cannot be bothered to check inputs

            if (orderItem.equalsIgnoreCase("done")) {
                break;
            }

            System.out.println("How many?");

            int orderCount = stdin.nextInt();
            
            for (MenuItem item : menu) {
                if (item.name.equalsIgnoreCase(orderItem)) {
                    item.count = orderCount;
                    orderItems.add(item);
                }
            }
        }

        double orderPrice = calaculteTotal(orderItems);

        System.out.println("Total before discount: $" + orderPrice);
        if (orderPrice > 20) {
            System.out.println("Discounted applied: $" + round(orderPrice * 0.1, 2));
            orderPrice = orderPrice * 0.9;
        }
        
        System.out.println("Final Price: $" + round(orderPrice, 2));

        printThankYou();
    }
}

class MenuItem { // why cant java have c-style structs or js/ts-style interface/type declarations?
    public String name;
    public double price; 
    public int count; // encapsulation begone

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}