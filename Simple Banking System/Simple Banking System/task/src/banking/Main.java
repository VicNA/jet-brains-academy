package banking;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int BIN = 400000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input;

        do {
            printMainMenu();
            input = sc.nextInt();
            if (input == 1) {

            }

        } while (input != 0);
    }

    public static void printMainMenu() {
        System.out.println("\n1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
    }

    public static void createAccount() {
        Random random = new Random();
        String card = String.valueOf(BIN);
        int number = (int) (1000000000 + random.nextFloat() * 9000000000L);
        card += number;
        System.out.println("\nYour card has been created");
        System.out.println("Your card number:");
        System.out.println(card);
        int pin = 1000 + random.nextInt(9000);
    }
}