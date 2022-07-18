package banking;

import java.util.*;

public class Main {

    private static final int BIN = 400000;
    private static final Map<String, String> MAP = new HashMap<>();
    private static final Scanner SC = new Scanner(System.in);
    private static boolean exit = false;

    public static void main(String[] args) {
        String input;
        do {
            printMainMenu();
            input = SC.nextLine();
            switch (input) {
                case "0":
                    System.out.println("Bye!");
                    break;
                case "1":
                    createAccount();
                    break;
                case "2":
                    if (logIntoAccount()) {
                        actionSubMenu();
                    }
                    break;
            }
        } while (!"0".equals(input) || exit);
    }

    public static void printMainMenu() {
        System.out.println("\n1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
    }

    public static void printSubMenu() {
        System.out.println("\n1. Balance");
        System.out.println("2. Log out");
        System.out.println("0. Exit");
    }

    public static void createAccount() {
        System.out.println("\nYour card has been created");
        System.out.println("Your card number:");
        String card = applyLuhnAlgorithm(BIN + generateNumber(9));
        System.out.println(card);

        String pin = generateNumber(4);
        System.out.println("Your card PIN:");
        System.out.println(pin);

        MAP.put(card, pin);
    }

    public static String applyLuhnAlgorithm(String number) {
        char[] chars = Arrays.copyOf(number.toCharArray(), number.length() + 1);
        int num;
        int sum = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            num = chars[i] - '0';
            num = i % 2 == 0 ? num * 2 : num;
            sum += num > 9 ? num - 9 : num;
        }
        num = sum % 10 != 0 ? 10 - (sum % 10) : 0;
        chars[chars.length - 1] = Character.forDigit(num, 10);

        return String.valueOf(chars);
    }

    public static String generateNumber(int len) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        while (len > 0) {
            sb.append(random.nextInt(10));
            len--;
        }
        return sb.toString();
    }

    public static boolean logIntoAccount() {
        System.out.println("\nEnter your card number:");
        String card = SC.nextLine();
        System.out.println("Enter your PIN:");
        String pin = SC.nextLine();

        if (pin.equals(MAP.get(card))) {
            System.out.println("\nYou have successfully logged in!");
            return true;
        } else {
            System.out.println("\nWrong card number or PIN!");
            return false;
        }
    }

    public static void actionSubMenu() {
        String input;
        do {
            printSubMenu();
            input = SC.nextLine();
            switch (input) {
                case "0":
                    System.out.println("\nBye!");
                    exit = true;
                    break;
                case "1":
                    System.out.println("\nBalance: 0");
                    break;
                case "2":
                    System.out.println("\nYou have successfully logged out!");
                    input = "0";
                    break;
            }
        } while (!"0".equals(input));
    }
}