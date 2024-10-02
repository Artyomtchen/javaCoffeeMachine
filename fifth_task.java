import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;

        while (true) {

            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            switch (action) {
                case "remaining":
                    System.out.println("The coffee machine has:");
                    System.out.println(water + " of water");
                    System.out.println(milk + " of milk");
                    System.out.println(beans + " of coffee beans");
                    System.out.println(cups + " of disposable cups");
                    System.out.println(money + " of money");
                    break;
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String coffeeChoice = scanner.next();

                    switch (coffeeChoice) {
                        case "1":
                            int espressoWater = 250;
                            int espressoBeans = 16;
                            if (water < espressoWater) {
                                System.out.println("Sorry, not enough water!");
                                break;
                            } else if (milk < 0) {
                                System.out.println("Sorry, not enough milk!");
                                break;
                            } else if (beans < espressoBeans) {
                                System.out.println("Sorry, not enough coffee beans!");
                                break;
                            } else if (cups < 1) {
                                System.out.println("Sorry, not enough disposable cups!");
                                break;
                            }
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 250;
                            milk -= 0;
                            beans -= 16;
                            money += 4;
                            cups -= 1;
                            break;
                        case "2":
                            int latteWater = 350;
                            int latteMilk = 75;
                            int latteBeans = 20;
                            if (water < latteWater) {
                                System.out.println("Sorry, not enough water!");
                                break;
                            } else if (milk < latteMilk) {
                                System.out.println("Sorry, not enough milk!");
                                break;
                            } else if (beans < latteBeans) {
                                System.out.println("Sorry, not enough coffee beans!");
                                break;
                            } else if (cups < 1) {
                                System.out.println("Sorry, not enough disposable cups!");
                                break;
                            }
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 350;
                            milk -= 75;
                            beans -= 20;
                            money += 7;
                            cups -= 1;
                            break;
                        case "3":
                            int cappuccinoWater = 200;
                            int cappuccinoMilk = 100;
                            int cappuccinoBeans = 12;
                            if (water < cappuccinoWater) {
                                System.out.println("Sorry, not enough water!");
                                break;
                            } else if (milk < cappuccinoMilk) {
                                System.out.println("Sorry, not enough milk!");
                                break;
                            } else if (beans < cappuccinoBeans) {
                                System.out.println("Sorry, not enough coffee beans!");
                                break;
                            } else if (cups < 1) {
                                System.out.println("Sorry, not enough disposable cups!");
                                break;
                            }
                            water -= 200;
                            milk -= 100;
                            beans -= 12;
                            money += 6;
                            cups -= 1;
                            break;
                        case "back":
                            break;
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    int addWater = scanner.nextInt();
                    water += addWater;

                    System.out.println("Write how many ml of milk do your want to add:");
                    int addMilk = scanner.nextInt();
                    milk += addMilk;

                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    int addBeans = scanner.nextInt();
                    beans += addBeans;

                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    int addCups = scanner.nextInt();
                    cups += addCups;
                    break;
                case "take":
                    System.out.println("I gave you $" + money);
                    money = 0;
                    break;
                case "exit":
                    System.exit(0);
                    break;
            }
        }
    }
}