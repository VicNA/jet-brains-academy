package banking;

import java.sql.SQLException;
import java.util.*;

public class Main {

    private static final int BIN = 400000;
    private static final Map<String, String> MAP = new HashMap<>();
    private static final Scanner SC = new Scanner(System.in);
    private static boolean exit = false;
    private static final DatabaseUtil util = new DatabaseUtil();

    public static void main(String[] args) {
        if (args.length < 2) return;
        if (!"-fileName".equals(args[0])) return;

        try {
            util.openDb(args[1]);

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
                        Card card = logIntoAccount();
                        if (card != null) {
                            System.out.println("\nYou have successfully logged in!");
                            actionSubMenu();
                        } else {
                            System.out.println("\nWrong card number or PIN!");
                        }
                        break;
                }
                System.out.println(input);
                System.out.println(exit);
            } while (!"0".equals(input) && !exit);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SC.close();
            util.close();
        }
    }

    public static void printMainMenu() {
        System.out.println("\n1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
    }

    public static void printSubMenu() {
        System.out.println("\n1. Balance");
        System.out.println("2. Add income");
        System.out.println("3. Do transfer");
        System.out.println("4. Close account");
        System.out.println("5. Log out");
        System.out.println("0. Exit");
    }

    public static void createAccount() {
        System.out.println("\nYour card has been created");
        System.out.println("Your card number:");
        String number = applyLuhnAlgorithm(BIN + generateNumber(9));
        System.out.println(number);

        String pin = generateNumber(4);
        System.out.println("Your card PIN:");
        System.out.println(pin);

        util.insert(number, pin);
    }

    public static String applyLuhnAlgorithm(String number) {
        char[] chars = Arrays.copyOf(number.toCharArray(), number.length() + 1);
        int tmp;
        int sum = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            tmp = chars[i] - '0';
            tmp = i % 2 == 0 ? tmp * 2 : tmp;
            sum += tmp > 9 ? tmp - 9 : tmp;
        }
        tmp = sum % 10 != 0 ? 10 - (sum % 10) : 0;
        chars[chars.length - 1] = Character.forDigit(tmp, 10);

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

    public static Card logIntoAccount() {
        System.out.println("\nEnter your card number:");
        String number = SC.nextLine();
        System.out.println("Enter your PIN:");
        String pin = SC.nextLine();

        return util.select(number, pin);
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