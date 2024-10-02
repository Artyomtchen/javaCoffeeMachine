package machine;

import java.util.Scanner;

class CoffeeMachine {

    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    static boolean exit = false;

    enum Status {
        CHOOSING, BUYING, FILLING, TAKING, REMAINING, EXITING
    }

    static Scanner sc = new Scanner(System.in);

    static Status currentStatus = Status.CHOOSING;

    public static void main(String[] args) {

        do {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = sc.next();
            switch (action) {
                case "buy":
                    changeStatus(Status.BUYING);
                    buy();
                    break;
                case "fill":
                    changeStatus(Status.FILLING);
                    fill();
                    break;
                case "take":
                    changeStatus(Status.TAKING);
                    take();
                    break;
                case "remaining":
                    changeStatus(Status.REMAINING);
                    remaining();
                    break;
                case "exit":
                    exit();
                    break;
            }
        } while (currentStatus != Status.EXITING);

    }

    static void changeStatus(Status value) {
        currentStatus = value;
    }

    static void exit() {
        changeStatus(Status.EXITING);
    }

    static void buy() {
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String switchBuy = sc.next();
        switch (switchBuy) {
            case "1": {
                countResources(250, 0, 16, 1, 4);
                break;
            }
            case "2": {
                countResources(350, 75, 20, 1, 7);
                break;
            }
            case "3": {
                countResources(200, 100, 12, 1, 6);
                break;
            }
            default: {
                break;
            }
        }
    }

    static boolean enoughResources(int value, int sizeValue, String nameValue) {
        if (value >= sizeValue) {
            return true;
        } else {
            System.out.println("Sorry, not enough " + nameValue + "!");
            changeStatus(Status.CHOOSING);
            return false;
        }
    }

    static boolean countResources(int waterSize, int milkSize, int beansSize, int cupsSize, int cost) {

        if (!enoughResources(water, waterSize, "water")) {
            return false;
        }

        if (!enoughResources(milk, milkSize, "milk")) {
            return false;
        }

        if (!enoughResources(beans, beansSize, "beans")) {
            return false;
        }

        if (!enoughResources(cups, cupsSize, "cups")) {
            return false;
        }
        income(cost);
        consuming(waterSize, milkSize, beansSize, cupsSize);
        System.out.println("I have enough resources, making you a coffee!");
        return true;
    }

    static void consuming(int waterSize, int milkSize, int beansSize, int cupsSize) {
        water -= waterSize;
        milk -= milkSize;
        beans -= beansSize;
        cups -= cupsSize;
    }

    static void income(int cost) {
        money += cost;
    }

    static void take() {
        System.out.println("I gave you $" + money + '\n');
        money = 0;

        currentStatus = Status.CHOOSING;
    }

    static void fill() {
        water = whichFill(water,"ml of water");
        milk = whichFill(milk,"ml of milk");
        beans = whichFill(beans,"grams of coffee beans");
        cups = whichFill(cups,"disposable cups of coffee");

        currentStatus = Status.CHOOSING;
    }

    static int whichFill(int value, String name) {
        System.out.println("Write how many " + name + " you want to add:");
        int add = sc.nextInt();
        value += add;

        return value;
    }

    static void remaining() {

        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println(money + "$ of money");

        currentStatus = Status.CHOOSING;
    }
}