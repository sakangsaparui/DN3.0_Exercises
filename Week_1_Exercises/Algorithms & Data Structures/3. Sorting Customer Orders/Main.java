import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of orders: ");
        int numOrders = sc.nextInt();
        sc.nextLine(); 
        
        Order[] orders = new Order[numOrders];
        
        for (int i = 0; i < numOrders; i++) {
            System.out.print("Enter Order ID: ");
            int orderId = sc.nextInt();
            sc.nextLine();
            
            System.out.print("Enter Customer Name: ");
            String customerName = sc.nextLine();
            
            System.out.print("Enter Total Price: ");
            double totalPrice = sc.nextDouble();
            sc.nextLine();
            
            orders[i] = new Order(orderId, customerName, totalPrice);
        }
        
        System.out.println("\nOriginal Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }
        
        Order[] bubbleSortedOrders = orders.clone();
        BubbleSort.bubbleSort(bubbleSortedOrders);
        System.out.println("\nBubble Sorted Orders:");
        for (Order order : bubbleSortedOrders) {
            System.out.println(order);
        }
        
        Order[] quickSortedOrders = orders.clone();
        QuickSort.quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        System.out.println("\nQuick Sorted Orders:");
        for (Order order : quickSortedOrders) {
            System.out.println(order);
        }
        sc.close();
    }
}
