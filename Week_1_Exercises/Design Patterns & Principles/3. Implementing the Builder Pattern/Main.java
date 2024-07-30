import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // First Computer Configuration
        System.out.println("Enter CPU for Computer 1:");
        String cpu1 = scanner.nextLine();
        
        System.out.println("Enter RAM for Computer 1:");
        String ram1 = scanner.nextLine();
        
        System.out.println("Enter Storage for Computer 1:");
        String storage1 = scanner.nextLine();
        
        Computer computer1 = new Computer.Builder()
                .setCPU(cpu1)
                .setRAM(ram1)
                .setStorage(storage1)
                .build();
        
        System.out.println("Computer 1: " + computer1);

        // Second Computer Configuration
        System.out.println("Enter CPU for Computer 2:");
        String cpu2 = scanner.nextLine();
        
        System.out.println("Enter RAM for Computer 2:");
        String ram2 = scanner.nextLine();
        
        System.out.println("Enter Storage for Computer 2:");
        String storage2 = scanner.nextLine();
        
        System.out.println("Enter GPU for Computer 2:");
        String gpu2 = scanner.nextLine();
        
        System.out.println("Enter Power Supply for Computer 2:");
        String powerSupply2 = scanner.nextLine();
        
        Computer computer2 = new Computer.Builder()
                .setCPU(cpu2)
                .setRAM(ram2)
                .setStorage(storage2)
                .setGPU(gpu2)
                .setPowerSupply(powerSupply2)
                .build();
        
        System.out.println("Computer 2: " + computer2);
        
        scanner.close();
    }
}
