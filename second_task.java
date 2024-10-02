import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int coffeecups = scan.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        System.out.println(coffeecups);
        System.out.println("For " + coffeecups + " cups of coffee you will need:");
        System.out.println(coffeecups * 200 + " ml of water");
        System.out.println(coffeecups * 50 + " ml of milk");
        System.out.println(coffeecups * 15 + " g of coffee beans");
    }
}